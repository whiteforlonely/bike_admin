package com.bike.admin.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.bike.admin.bean.TBikeDTO2JSON;
import com.bike.admin.dto.TBikeDTO;
import com.bike.admin.dto.TUserOrderDTO;
import com.bike.admin.service.TBikeService;
import com.bike.admin.service.TUserOrderService;
import com.bike.admin.service.base.AdminServiceManager;
import com.bike.admin.util.CodeUtils;
import com.bike.admin.util.ParameterUtil;

public class BikeAction extends BaseAction{
	
	private static TBikeService tBikeService = AdminServiceManager.getTBikeService();
	private static TUserOrderService tUserOrderService = AdminServiceManager.getTUserOrderService();
	
	public BikeAction() {
		super();
	}

	public BikeAction(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
	}
	
	public void bikeList() {
		int start = ParameterUtil.getIntParameter(request, "start", 0);
		int length = ParameterUtil.getIntParameter(request, "length", 20);
		
		int id = ParameterUtil.getIntParameter(request, "id", 0);
		int userId = ParameterUtil.getIntParameter(request, "userId", 0);
		int siteId = ParameterUtil.getIntParameter(request, "siteId", 0);
		String bikeCode = ParameterUtil.getStringParameter(request, "bikeCode", "");
		String color = ParameterUtil.getStringParameter(request, "color", "");
		int status = ParameterUtil.getIntParameter(request, "status", -1000);
		
		TBikeDTO dto = new TBikeDTO();
		dto.setId(id);
		dto.setUserId(userId);
		dto.setSiteId(siteId);
		dto.setBikeCode(bikeCode);
		dto.setColor(color);
		dto.setStatus(status);

		List<TBikeDTO> list = tBikeService.getList(dto, start, length);
		int totalCount = tBikeService.getCount(dto);
		JSONObject json = new JSONObject();
		if (totalCount == 0) {
			json.put("total", 0);
			json.put("list", "[]");
		} else {
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.registerJsonBeanProcessor(TBikeDTO.class, new TBikeDTO2JSON());
			json.put("total", totalCount);
			json.put("list", JSONArray.fromObject(list, jsonConfig));
		}

		this.sendResult(json.toString());
	}
	
	public void addBike() {
		int userId = ParameterUtil.getIntParameter(request, "userId", 0);
		int siteId = ParameterUtil.getIntParameter(request, "siteId", 0);
		double bikeAmount = ParameterUtil.getDoubleParameter(request, "bikeAmount", 0);
		String bikeCode = ParameterUtil.getStringParameter(request, "bikeCode", "");
		String color = ParameterUtil.getStringParameter(request, "color", "黑");
		String position = ParameterUtil.getStringParameter(request, "position", "二环西路");
		String appearance = ParameterUtil.getStringParameter(request, "appearance", "新");

		TBikeDTO dto = new TBikeDTO();
		dto.setUserId(userId);
		dto.setSiteId(siteId);
		dto.setBikeAmount(bikeAmount);
		dto.setColor(color);
		dto.setBikeCode(bikeCode);
		dto.setPosition(position);
		dto.setAppearance(appearance);
		dto.setStatus(2);
		dto.setCreateTime(new Date());

		int result = tBikeService.saveTBike(dto);

		if (result > 0) {
			this.sendSuccessMsg("保存成功！");
		} else {
			this.sendFailMsg("保存失败！");
		}
	}
	
	public void modifyBike() {
		int id = ParameterUtil.getIntParameter(request, "id", 0);
		int siteId = ParameterUtil.getIntParameter(request, "siteId", 0);
		double bikeAmount = ParameterUtil.getDoubleParameter(request, "bikeAmount", 0);
		String color = ParameterUtil.getStringParameter(request, "color", "");
		String bikeCode = ParameterUtil.getStringParameter(request, "bikeCode", "");
		String position = ParameterUtil.getStringParameter(request, "position", "");
		String appearance = ParameterUtil.getStringParameter(request, "appearance", "");
		

		TBikeDTO dto = tBikeService.getTBikeById(id);
		if (dto == null) {
			this.sendFailMsg("车辆不存在！");
			return;
		}
		
		if(!color.equals("")){
			dto.setColor(color);
		}
		if(!position.equals("")){
			dto.setPosition(position);
		}
		if(!appearance.equals("")){
			dto.setAppearance(appearance);
		}
		if(bikeAmount != 0){
			dto.setBikeAmount(bikeAmount);
		}
		dto.setSiteId(siteId);
		dto.setBikeCode(bikeCode);

		boolean result = tBikeService.updateTBike(dto);

		if (result) {
			this.sendSuccessMsg("修改成功！");
		} else {
			this.sendFailMsg("修改失败！");
		}
	}
	
	public void deleteBike() {
		int id = ParameterUtil.getIntParameter(request, "id", 0);

		TBikeDTO dto = tBikeService.getTBikeById(id);
		if (dto == null) {
			this.sendFailMsg("账号不存在！");
			return;
		}

		boolean result = tBikeService.deleteTBikeById(id);

		if (result) {
			this.sendSuccessMsg("删除成功！");
		} else {
			this.sendFailMsg("删除失败！");
		}
	}
	
	// 发布订单
	public void postOrder(){
		int issueid = ParameterUtil.getIntParameter(request, "issueId", 0);
		int bikeId = ParameterUtil.getIntParameter(request, "bikeId", 0);
		int orderType = ParameterUtil.getIntParameter(request, "orderType", 0);
		double amount = ParameterUtil.getDoubleParameter(request, "amount", 0.00);
		
		if (userType == 1) {
			this.sendFailMsg("管理员无权限发布订单！");
			return;
		}
		
		TUserOrderDTO dto = new TUserOrderDTO();
		dto.setIssueId(issueid);
		dto.setBikeId(bikeId);
		List<TUserOrderDTO> list = tUserOrderService.getList(dto, 0, 2, "", "");
		if (null != list && list.size() > 0) {
			this.sendFailMsg("已经有订单");
			return;
		}
		dto.setOrderType(orderType);
		dto.setOrderStatus(0);
		dto.setCreateTime(new Date());
		dto.setAmount(amount);
		
		int result = tUserOrderService.saveTUserOrder(dto);
		if (result > 0) {
			dto.setId(result);
			dto.setOrderCode(CodeUtils.getNum(String.valueOf(result)));
			tUserOrderService.updateTUserOrder(dto);
			this.sendSuccess();
		}else {
			this.sendFailMsg("发布失败！");
		}
	}

}
