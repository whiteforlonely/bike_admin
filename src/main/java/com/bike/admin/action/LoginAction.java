package com.bike.admin.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.bike.admin.bean.AdminUser2JSON;
import com.bike.admin.bean.TUserInfoDTO2JSON;
import com.bike.admin.dto.TAdminUserDTO;
import com.bike.admin.dto.TUserInfoDTO;
import com.bike.admin.service.TAdminUserService;
import com.bike.admin.service.TUserInfoService;
import com.bike.admin.service.base.AdminServiceManager;
import com.bike.admin.util.EncryUtil;
import com.bike.admin.util.ParameterUtil;

public class LoginAction extends BaseAction{

	private static TAdminUserService adminUserService = AdminServiceManager.getAdminUserService();
	private static TUserInfoService tUserInfoService = AdminServiceManager.getTUserInfoService();
	public LoginAction() {
		super();
	}

	public LoginAction(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
	}
	
	public void login(){
		String phone = ParameterUtil.getStringParameter(request, "mobilePhone", "");
		String password = ParameterUtil.getStringParameter(request, "password", "");
		int loginType = ParameterUtil.getIntParameter(request, "loginType", 0);
		int id = 0;
		String userName = null;
		TAdminUserDTO adminUserDTO = null;
		TUserInfoDTO userDTO = null;
		
		if (loginType == 1) {
			adminUserDTO = adminUserService.getByPhoneAndPwd(phone, EncryUtil.encode(password));
			if (adminUserDTO == null) {
				this.sendFailMsg("用户名或密码错误");
				return;
			}
			
			if (adminUserDTO.getStatus() == 1) {
				this.sendFailMsg("已被停用！");
				return;
			}
			
			id = adminUserDTO.getId();
			userName = adminUserDTO.getNickname();
		} else if(loginType == 0){
			userDTO = tUserInfoService.getByPhoneAndPwd(phone, EncryUtil.encode(password));
			if (userDTO == null) {
				this.sendFailMsg("用户名或密码错误");
				return;
			}
			
			id = userDTO.getId();
			userName = userDTO.getUserName();
		}
		
		request.getSession().setAttribute("uid", id);
		request.getSession().setAttribute("userName", userName);
		request.getSession().setAttribute("userType", loginType);
		
		JsonConfig jsonConfig = new JsonConfig();
		JSONObject json = new JSONObject();
		json.put("result", "success");
		if (loginType == 0) {
			jsonConfig.registerJsonBeanProcessor(TUserInfoDTO.class, new TUserInfoDTO2JSON());
			json.put("userInfo", JSONObject.fromObject(userDTO, jsonConfig));
		}else {
			jsonConfig.registerJsonBeanProcessor(TAdminUserDTO.class, new AdminUser2JSON());
			json.put("userInfo", JSONObject.fromObject(adminUserDTO, jsonConfig));
		}
		this.sendResult(json.toString());
	}
	
	public void register(){
		String userName = ParameterUtil.getStringParameter(request, "userName", ""); 
		String phone = ParameterUtil.getStringParameter(request, "mobilePhone", "");
		String password = ParameterUtil.getStringParameter(request, "password", "");
		int registerType = ParameterUtil.getIntParameter(request, "registerType", 0);
		
		if (registerType == 1) {
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
		} else {
			TUserInfoDTO dto = new TUserInfoDTO();
			dto.setUserName(userName);
			dto.setPassword(EncryUtil.encode(password));
			dto.setPhoneNum(phone);
			dto.setCreateTime(new Date());
			tUserInfoService.saveTUserInfo(dto);
		}
		
		this.sendSuccess();
	} 

}
