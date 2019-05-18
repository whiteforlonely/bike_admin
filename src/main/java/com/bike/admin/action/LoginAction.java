package com.bike.admin.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.bike.admin.bean.AdminUser2JSON;
import com.bike.admin.dto.TAdminUserDTO;
import com.bike.admin.service.TAdminUserService;
import com.bike.admin.service.base.AdminServiceManager;
import com.bike.admin.util.EncryUtil;
import com.bike.admin.util.ParameterUtil;
import com.framework.action.session.WebSessionManager;
import com.framework.action.session.model.WebSessionUser;

public class LoginAction extends BaseAction{

	private static TAdminUserService adminUserService = AdminServiceManager.getAdminUserService();
	public LoginAction() {
		super();
	}

	public LoginAction(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
	}
	
	public void login(){
		String phone = ParameterUtil.getStringParameter(request, "mobilePhone", "");
		String password = ParameterUtil.getStringParameter(request, "password", "");
		
		TAdminUserDTO dto = adminUserService.getByPhoneAndPwd(phone, EncryUtil.encode(password));
		if (dto == null) {
			this.sendFailMsg("用户名或密码错误");
			return;
		}
		
		if (dto.getStatus() == 1) {
			this.sendFailMsg("已被停用！");
			return;
		}
		
		initSession(dto);
		
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonBeanProcessor(TAdminUserDTO.class, new AdminUser2JSON());
		JSONObject json = new JSONObject();
		json.put("result", "success");
		json.put("userInfo", JSONObject.fromObject(dto, jsonConfig));
		this.sendResult(json.toString());
	}
	
	public void register(){
		String userName = ParameterUtil.getStringParameter(request, "userName", ""); 
		String phone = ParameterUtil.getStringParameter(request, "mobilePhone", "");
		String password = ParameterUtil.getStringParameter(request, "password", "");
		TAdminUserDTO dto = adminUserService.getUserInfoByPhone(phone);
		if(dto != null){
			this.sendFailMsg("手机号已被注册");
			return;
		}
		dto = new TAdminUserDTO();
		dto.setNickname(userName);
		dto.setMobilephone(phone);
		dto.setPassword(EncryUtil.encode(password));
		dto.setStatus(0);
		dto.setCreateTime(new Date());
		adminUserService.saveTAdminUser(dto);
		
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonBeanProcessor(TAdminUserDTO.class, new AdminUser2JSON());
		JSONObject json = new JSONObject();
		json.put("result", "success");
		json.put("userInfo", JSONObject.fromObject(dto, jsonConfig));
		this.sendResult(json.toString());
		
		
	} 
	
	private void initSession(TAdminUserDTO dto){
		WebSessionUser sessionUser = WebSessionManager.getSessionUser(request);
		if (sessionUser == null) {
			return;
		}
		
		sessionUser.setUserName(dto.getNickname());
		sessionUser.setPhone(dto.getMobilephone());
		sessionUser.setUserId(dto.getId());
	}

}
