package com.bike.admin.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.bike.admin.bean.AdminUser2JSON;
import com.bike.admin.dto.TAdminUserDTO;
import com.bike.admin.enums.AdminUserStatusEnum;
import com.bike.admin.service.TAdminUserService;
import com.bike.admin.service.base.AdminServiceManager;
import com.bike.admin.util.EncryUtil;
import com.bike.admin.util.ExportCsvUtil;
import com.bike.admin.util.ParameterUtil;
import com.bike.admin.util.TimeUtils;

public class AdminUserAction extends BaseAction {

	private static TAdminUserService adminUserService = AdminServiceManager.getAdminUserService();

	public AdminUserAction() {
		super();
	}

	public AdminUserAction(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
	}

	// admin user list
	public void adminUserList() {
		int start = ParameterUtil.getIntParameter(request, "start", 0);
		int length = ParameterUtil.getIntParameter(request, "length", 20);

		List<TAdminUserDTO> list = adminUserService.getPage(start, length);
		int totalCount = adminUserService.getCount();
		JSONObject json = new JSONObject();
		if (totalCount == 0) {
			json.put("total", 0);
			json.put("list", "[]");
		} else {
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.registerJsonBeanProcessor(TAdminUserDTO.class, new AdminUser2JSON());
			json.put("total", totalCount);
			json.put("list", JSONArray.fromObject(list, jsonConfig));
		}

		this.sendResult(json.toString());
	}
	
	// export data
	public void export(){
		List<TAdminUserDTO> list = adminUserService.getPage(0, 5000);

		List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
		
		if (list == null || list.size() <= 0) {
			this.sendFailMsg("没有数据！");
			return;
		}
		
		int listSize = list.size();
		for (int i = 0; i < listSize; i++) {
			TAdminUserDTO dto = list.get(i);
			LinkedHashMap<String, String> dtoMap = new LinkedHashMap<String, String>();
			dtoMap.put("1", String.valueOf(dto.getId()));
			dtoMap.put("2", dto.getNickname());
			dtoMap.put("3", dto.getMobilephone());
			dtoMap.put("4", String.valueOf(dto.getStatus()));
			dtoMap.put("5", TimeUtils.dateToString(dto.getCreateTime()));
			
			dataList.add(dtoMap);
		}
		
		LinkedHashMap<String, String> titleMap = new LinkedHashMap<String, String>();
		titleMap.put("1", "ID");
		titleMap.put("2", "姓名");
		titleMap.put("3", "手机");
		titleMap.put("4", "状态（0正常 1限制 -100删除）");
		titleMap.put("5", "时间");
		
		try {
			response.setContentType("application/octet-stream");
			response.setCharacterEncoding("utf-8");
			ExportCsvUtil.createCSVFile(dataList, titleMap, response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
			this.sendFailMsg("导出异常！");
		}
	}

	// add admin user
	public void addAdminUser() {
		String nickname = ParameterUtil.getStringParameter(request, "nickname", "匿名");
		String mobilePhone = ParameterUtil.getStringParameter(request, "mobilephone", "");
		String password = ParameterUtil.getStringParameter(request, "password", "");

		if (mobilePhone.isEmpty()) {
			this.sendFailMsg("手机不为空！");
			return;
		}
		
		boolean isPhoneExist = adminUserService.isPhoneExists(mobilePhone);
		if (isPhoneExist) {
			this.sendFailMsg("手机号已经注册过！");
			return;
		}

		TAdminUserDTO dto = new TAdminUserDTO();
		dto.setNickname(nickname);
		dto.setMobilephone(mobilePhone);
		dto.setPassword(EncryUtil.encode(password));
		dto.setCreateTime(new Date());

		int result = adminUserService.saveTAdminUser(dto);

		if (result > 0) {
			this.sendSuccessMsg("保存成功！");
		} else {
			this.sendFailMsg("保存失败！");
		}
	}

	// modify admin user
	public void modifyAdminUser() {
		int id = ParameterUtil.getIntParameter(request, "id", 0);
		String nickname = ParameterUtil.getStringParameter(request, "nickname", "匿名");
		String mobilePhone = ParameterUtil.getStringParameter(request, "mobilephone", "");
		String password = ParameterUtil.getStringParameter(request, "password", "");

		if (id <= 0) {
			this.sendFailMsg("错误ID！");
			return;
		}

		if (mobilePhone.isEmpty()) {
			this.sendFailMsg("手机不为空！");
			return;
		}
		
		boolean isPhoneExist = adminUserService.isPhoneExists(mobilePhone, id);
		if (isPhoneExist) {
			this.sendFailMsg("手机号已经存在！");
			return;
		}

		TAdminUserDTO dto = adminUserService.getTAdminUserById(id);
		if (dto == null) {
			this.sendFailMsg("账号不存在！");
			return;
		}

		if (dto.getStatus() == -100) {
			this.sendFailMsg("用户已经被删除！");
			return;
		}

		dto.setNickname(nickname);
		dto.setMobilephone(mobilePhone);
		dto.setPassword(EncryUtil.encode(password));

		boolean result = adminUserService.updateTAdminUser(dto);

		if (result) {
			this.sendSuccessMsg("修改成功！");
		} else {
			this.sendFailMsg("修改失败！");
		}
	}

	// delete admin user
	public void deleteAdminUser() {
		int id = ParameterUtil.getIntParameter(request, "id", 0);

		TAdminUserDTO dto = adminUserService.getTAdminUserById(id);
		if (dto == null) {
			this.sendFailMsg("账号不存在！");
			return;
		}

		if (dto.getStatus() == AdminUserStatusEnum.DELETED.getCode()) {
			this.sendFailMsg("用户已经被删除！");
			return;
		}

		int result = adminUserService.updateStatus(id, AdminUserStatusEnum.DELETED.getCode());

		if (result > 0) {
			this.sendSuccessMsg("删除成功！");
		} else {
			this.sendFailMsg("删除失败！");
		}
	}

	// forbid admin user
	public void forbidAdminUser() {
		int id = ParameterUtil.getIntParameter(request, "id", 0);

		TAdminUserDTO dto = adminUserService.getTAdminUserById(id);
		if (dto == null) {
			this.sendFailMsg("账号不存在！");
			return;
		}

		if (dto.getStatus() == AdminUserStatusEnum.FORBIDDEN.getCode()) {
			this.sendFailMsg("用户已被停用！");
			return;
		}

		int result = adminUserService.updateStatus(id, AdminUserStatusEnum.FORBIDDEN.getCode());

		if (result > 0) {
			this.sendSuccessMsg("操作成功！");
		} else {
			this.sendFailMsg("操作失败！");
		}
	}

	// resue admin user
	public void reuseAdminUser() {
		int id = ParameterUtil.getIntParameter(request, "id", 0);

		TAdminUserDTO dto = adminUserService.getTAdminUserById(id);
		if (dto == null) {
			this.sendFailMsg("账号不存在！");
			return;
		}

		if (dto.getStatus() == AdminUserStatusEnum.NORMAL.getCode()) {
			this.sendFailMsg("账号已经正常！");
			return;
		}

		int result = adminUserService.updateStatus(id, AdminUserStatusEnum.NORMAL.getCode());

		if (result > 0) {
			this.sendSuccessMsg("操作成功！");
		} else {
			this.sendFailMsg("操作失败！");
		}
	}

}
