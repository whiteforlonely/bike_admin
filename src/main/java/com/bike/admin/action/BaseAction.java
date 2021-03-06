package com.bike.admin.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import com.framework.action.http.HttpClient;

import net.sf.json.JSONObject;

/**
 * 基础action
 */
public abstract class BaseAction {
	
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession sessionUser = null;
	protected int loginUid;
	protected String userName;
	protected int userType;	// 0=用户， 1=管理员
	
	private static Lock requestLock = new ReentrantLock();

	public BaseAction() {
	}

	public BaseAction(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.initParams();
	}

	protected void init(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.initParams();
	}

	protected void initParams(){
		sessionUser = request.getSession();
		if(sessionUser != null) {
			@SuppressWarnings("unchecked")
			Enumeration<String> enums = sessionUser.getAttributeNames();
			List<String> list = new ArrayList<String>();
			while (enums.hasMoreElements()) {
				list.add(enums.nextElement());
			}
			if (list.contains("uid")) {
				loginUid = (int) sessionUser.getAttribute("uid");				
			}
			if (list.contains("userName")) {
				userName = (String) sessionUser.getAttribute("userName");				
			}
			if (list.contains("userType")) {
				userType = (int) sessionUser.getAttribute("userType");				
			}
		}
	}

	protected String initTab(){
		return "success";
	}
	/**
	 * 设置传值对像
	 * 
	 * @param key
	 *            键值
	 * @param value
	 *            值
	 */
	public void setInfoForRequest(String key, Object value) {
		request.setAttribute(key, value);
	}

	protected void redirectToAnyWhere(String targetUri) {
		try {
			response.sendRedirect(targetUri);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void forwardToAnyWhere(String targetUri) {
		try {
			request.getRequestDispatcher(targetUri).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void redirect404() {
		this.setInfoForRequest("redirect", "/404");
	}

	protected void redirect500() {
		this.setInfoForRequest("redirect", "/500");
	}

	/**
	 * @Title: getIpAddr
	 * @Description: TODO(获取ip地址)
	 * @return:
	 */
	protected String getIpAddr() {
		String ip = request.getHeader("RealIP");
		if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if (StringUtils.isBlank(ip)) {
			ip = "127.0.0.1";// 实在是判断不出IP了...
		}
		return ip;
	}

	protected void sendSuccess() {
		JSONObject result = new JSONObject();
		result.put("result", "success");
		this.sendResult(result.toString());
		return;
	}

	/**
	 * @Description: TODO(发送AJAX结果)
	 * @param result
	 * @return void
	 */
	public void sendResult(String result) {
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter out = response.getWriter();
			out.print(result);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendEmptyArrayResult(){
		JSONObject json = new JSONObject();
		json.put("result", "success");
		json.put("data", "[]");
		sendResult(json.toString());
	}
	
	/**
	 * 
	 * @Title: getCookieValue
	 * @Description: 如果cookieName为空或者找不到该cookie返回null
	 * @param
	 * @param cookieName
	 * @return:
	 */
	protected String getCookieValue(String cookieName) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				if (StringUtils.equals(cookieName, cookie.getName())) {
					return cookie.getValue();
				}
			}
		}

		return null;
	}

	protected void sendFailMsg(String msg) {
		JSONObject result = new JSONObject();
		result.put("result","fail");
		result.put("msg", msg);
		this.sendResult(result.toString());
	}

	protected void sendSuccessMsg(String msg) {
		JSONObject result = new JSONObject();
		result.put("result", "success");
		result.put("msg", msg);
		this.sendResult(result.toString());
	}

	public void setPlatform() {
		String ua = request.getHeader("User-Agent");
		String platform = "windows";
		boolean isWeixin = false;
		if (StringUtils.isNotBlank(ua)) {
			if (ua.toLowerCase().contains("android")) {
				platform = "android";
			} else if (ua.toLowerCase().contains("iphone")
					|| ua.toLowerCase().contains("ipod")
					|| ua.toLowerCase().contains("ipad")) {
				platform = "ios";
			}
			if (ua.toLowerCase().contains("micromessenger")) {
				isWeixin = true;
			}
		}

		this.setInfoForRequest("isWeixin", isWeixin);
		this.setInfoForRequest("platform", platform);
	}
	
	//同步请求队列！
	protected String doGet(String url, Map<Object, Object> params) {
		JSONObject resp = new JSONObject();
		try {
			requestLock.lock();
			resp = HttpClient.doPost(url, params); 
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			requestLock.unlock();
		}
		return resp.toString();
	}
	
}
