package com.bike.admin.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
	private static final String PATH = "/";

	/**
	 * 设置cookie
	 * 
	 * @param response
	 * @param name
	 *            cookie名字
	 * @param value
	 *            cookie值
	 * @param maxAge
	 *            cookie生命周期 以秒为单位
	 */
	public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
		// Cookie cookie = new Cookie(name,value);
		Cookie cookie;
		try {
			// 如果不URLEncoder一下,放到resin服务器下,会取不到值,所以取cookie值的时候同样也要URLDecoder一下
			cookie = new Cookie(name, URLEncoder.encode(value, "UTF-8"));
			// cookie.setDomain(".diguread.com");
			cookie.setPath(PATH);
			// cookie.setDomain("feed.diguread.com");
			if (maxAge > 0)
				cookie.setMaxAge(maxAge);
			response.addCookie(cookie);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void addStaticCookie(HttpServletResponse response, String name, String value) {
		// Cookie cookie = new Cookie(name,value);
		Cookie cookie;
		try {
			// 如果不URLEncoder一下,放到resin服务器下,会取不到值,所以取cookie值的时候同样也要URLDecoder一下
			cookie = new Cookie(name, URLEncoder.encode(value, "UTF-8"));
			// cookie.setDomain(".diguread.com");
			cookie.setPath("/");
			// cookie.setDomain("feed.diguread.com");
			cookie.setMaxAge(31536000);
			response.addCookie(cookie);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 根据名字获取cookie
	 * 
	 * @param request
	 * @param name
	 *            cookie名字
	 * @return
	 */
	public static Cookie getCookieByName(HttpServletRequest request, String name) {
		Map<String, Cookie> cookieMap = ReadCookieMap(request);
		if (cookieMap.containsKey(name)) {
			Cookie cookie = (Cookie) cookieMap.get(name);
			return cookie;
		} else {
			return null;
		}
	}

	/**
	 * 将cookie封装到Map里面
	 * 
	 * @param request
	 * @return
	 */
	private static Map<String, Cookie> ReadCookieMap(HttpServletRequest request) {
		Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				cookieMap.put(cookie.getName(), cookie);
			}
		}
		return cookieMap;
	}

	/**
	 * 清除所有cookie,退出登录时使用
	 */
	public static void clearCookie(HttpServletRequest request, HttpServletResponse response) {
		Cookie cookies[] = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				if (!cookie.getName().equals("deviceId") && !cookie.getName().equals("forumCoupon")) {
					cookie.setMaxAge(0);
					cookie.setPath(PATH);
					response.addCookie(cookie);
				}
			}
		}
	}

	public static String getCookieValueByName(HttpServletRequest request, String name) {
		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				if (name.equals(cookie.getName()) && cookie.getValue() != null) {
					try {
						// 对应于设置时的URLEncoder
						return URLDecoder.decode(cookie.getValue(), "UTF-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
			}
			return null;
		} else {
			return null;
		}
	}
}
