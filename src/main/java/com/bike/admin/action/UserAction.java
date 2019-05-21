package com.bike.admin.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.bike.admin.bean.TUserInfoDTO2JSON;
import com.bike.admin.dto.TUserInfoDTO;
import com.bike.admin.service.TUserInfoService;
import com.bike.admin.service.base.AdminServiceManager;
import com.bike.admin.util.EncryUtil;
import com.bike.admin.util.ParameterUtil;

public class UserAction extends BaseAction {
	
	private static TUserInfoService tUserInfoService = AdminServiceManager.getTUserInfoService();
	
	public UserAction() {
		super();
	}
	
	public UserAction(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
	}
	
	public void userList() {
		int start = ParameterUtil.getIntParameter(request, "start", 0);
		int length = ParameterUtil.getIntParameter(request, "length", 20);
		//性别，名称，手机号，身份证号，注册时间
		int sex = ParameterUtil.getIntParameter(request, "sex", 0);
		int id = ParameterUtil.getIntParameter(request, "id", 0);
		String userName = ParameterUtil.getStringParameter(request, "userName", "");
		String phoneNum = ParameterUtil.getStringParameter(request, "phoneNum", "");
		String idCard = ParameterUtil.getStringParameter(request, "identityCard", "");
		String startCreateTime = ParameterUtil.getStringParameter(request, "createTimeStart", "");
		String endCreateTime = ParameterUtil.getStringParameter(request, "createTimeEnd", "");

		TUserInfoDTO dto = new TUserInfoDTO();
		dto.setId(id);
		dto.setSex(sex);
		dto.setUserName(userName);
		dto.setPhoneNum(phoneNum);
		dto.setIdentityCard(idCard);
		List<TUserInfoDTO> list = tUserInfoService.getList(dto, start, length, startCreateTime, endCreateTime);
		int totalCount = tUserInfoService.getCount(dto, startCreateTime, endCreateTime);
		JSONObject json = new JSONObject();
		if (totalCount == 0) {
			json.put("total", 0);
			json.put("list", "[]");
		} else {
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.registerJsonBeanProcessor(TUserInfoDTO.class, new TUserInfoDTO2JSON());
			json.put("total", totalCount);
			json.put("list", JSONArray.fromObject(list, jsonConfig));
		}

		this.sendResult(json.toString());
	}
	
	public void addUser() {
		String nickname = ParameterUtil.getStringParameter(request, "userName", "匿名");
		String mobilePhone = ParameterUtil.getStringParameter(request, "phoneNum", "");
		String password = ParameterUtil.getStringParameter(request, "password", "");
		String identityCard = ParameterUtil.getStringParameter(request, "identityCard", "");
		String address = ParameterUtil.getStringParameter(request, "address", "");
		int userSex = ParameterUtil.getIntParameter(request, "sex", 1);

		if (mobilePhone.isEmpty()) {
			this.sendFailMsg("手机不为空！");
			return;
		}
		
		boolean isPhoneExist = tUserInfoService.isPhoneExists(mobilePhone);
		if (isPhoneExist) {
			this.sendFailMsg("手机号已经注册过！");
			return;
		}

		TUserInfoDTO dto = new TUserInfoDTO();
		dto.setUserName(nickname);
		dto.setPhoneNum(mobilePhone);
		dto.setPassword(EncryUtil.encode(password));
		dto.setSex(userSex);
		dto.setAddress(address);
		dto.setIdentityCard(identityCard);
		dto.setCreateTime(new Date());

		int result = tUserInfoService.saveTUserInfo(dto);

		if (result > 0) {
			this.sendSuccessMsg("保存成功！");
		} else {
			this.sendFailMsg("保存失败！");
		}
	}
	
	public void modifyUser() {
		int id = ParameterUtil.getIntParameter(request, "id", 0);
		String nickname = ParameterUtil.getStringParameter(request, "userName", "匿名");
		String mobilePhone = ParameterUtil.getStringParameter(request, "phoneNum", "");
		String password = ParameterUtil.getStringParameter(request, "password", "");
		String identityCard = ParameterUtil.getStringParameter(request, "identityCard", "");
		String address = ParameterUtil.getStringParameter(request, "address", "");
		int sex = ParameterUtil.getIntParameter(request, "sex", 0);

		if (id <= 0) {
			this.sendFailMsg("错误ID！");
			return;
		}

		if (mobilePhone.isEmpty()) {
			this.sendFailMsg("手机不为空！");
			return;
		}
		
		boolean isPhoneExist = tUserInfoService.isPhoneExists(mobilePhone, id);
		if (isPhoneExist) {
			this.sendFailMsg("手机号已经存在！");
			return;
		}

		TUserInfoDTO dto = tUserInfoService.getTUserInfoById(id);
		if (dto == null) {
			this.sendFailMsg("账号不存在！");
			return;
		}

		dto.setUserName(nickname);
		dto.setPhoneNum(mobilePhone);
		dto.setPassword(EncryUtil.encode(password));
		dto.setSex(sex);
		dto.setAddress(address);
		if(!identityCard.equals("")){
			dto.setIdentityCard(identityCard);
		}
		
		boolean result = tUserInfoService.updateTUserInfo(dto);
		if (result) {
			this.sendSuccessMsg("修改成功！");
		} else {
			this.sendFailMsg("修改失败！");
		}
	}
	
	public void deleteUser() {
		int id = ParameterUtil.getIntParameter(request, "id", 0);

		TUserInfoDTO dto = tUserInfoService.getTUserInfoById(id);
		if (dto == null) {
			this.sendFailMsg("账号不存在！");
			return;
		}

		boolean result = tUserInfoService.deleteTUserInfoById(id);
		
		if (result) {
			this.sendSuccessMsg("删除成功！");
		} else {
			this.sendFailMsg("删除失败！");
		}
	}
	

}
