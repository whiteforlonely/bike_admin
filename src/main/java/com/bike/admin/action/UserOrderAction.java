package com.bike.admin.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.bike.admin.bean.TUserOrder2JSON;
import com.bike.admin.dto.TUserOrderDTO;
import com.bike.admin.service.TUserOrderService;
import com.bike.admin.service.base.AdminServiceManager;
import com.bike.admin.util.ParameterUtil;

public class UserOrderAction extends BaseAction{
	
	private static TUserOrderService tUserOrderService = AdminServiceManager.getTUserOrderService();

	public UserOrderAction() {
		super();
	}

	public UserOrderAction(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
	}
	
	public void list() {
		int orderId = ParameterUtil.getIntParameter(request, "id", 0);
		int useId = ParameterUtil.getIntParameter(request, "useId", 0);
		int issueId = ParameterUtil.getIntParameter(request, "issueId", 0);
		int bikeId = ParameterUtil.getIntParameter(request, "bikeId", 0);
		String createTimeStart = ParameterUtil.getStringParameter(request, "createTimeStart", "");
		String createTimeEnd = ParameterUtil.getStringParameter(request, "createTimeEnd", "");
		int start = ParameterUtil.getIntParameter(request, "start", 0);
		int length = ParameterUtil.getIntParameter(request, "length", 20);
		int status = ParameterUtil.getIntParameter(request, "orderStatus", -1000);
		int orderType = ParameterUtil.getIntParameter(request, "orderType", -1000);
		String orderCode = ParameterUtil.getStringParameter(request, "orderCode", "");

		TUserOrderDTO searchDto = new TUserOrderDTO();
		searchDto.setId(orderId);
		searchDto.setOrderStatus(status);
		searchDto.setOrderCode(orderCode);
		searchDto.setUseId(useId);
		searchDto.setIssueId(issueId);
		searchDto.setBikeId(bikeId);
		searchDto.setOrderType(orderType);

		List<TUserOrderDTO> list = tUserOrderService.getList(searchDto, start, length, createTimeStart, createTimeEnd);
		int totalCount = tUserOrderService.getCount(searchDto, createTimeStart, createTimeEnd);
		JSONObject json = new JSONObject();
		if (totalCount == 0) {
			json.put("total", 0);
			json.put("list", "[]");
		} else {
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.registerJsonBeanProcessor(TUserOrderDTO.class, new TUserOrder2JSON());
			json.put("list", JSONArray.fromObject(list, jsonConfig));
			json.put("total", totalCount);
		}
		this.sendResult(json.toString());
	}
	
	public void update() {
		int orderId = ParameterUtil.getIntParameter(request, "id", 0);
		int status = ParameterUtil.getIntParameter(request, "orderStatus", -1000);
		int orderType = ParameterUtil.getIntParameter(request, "orderType", -1000);
		
		if (orderId <= 0) {
			this.sendFailMsg("无效订单ID！");
			return;
		}
		
		TUserOrderDTO dto = tUserOrderService.getTUserOrderById(orderId);
		if (dto == null) {
			this.sendFailMsg("无订单数据！");
			return;
		}
		
		if (status >= 0) {
			dto.setOrderStatus(status);
		}
		
		if (orderType >= 0) {
			dto.setOrderType(orderType);
		}
		
		boolean result = tUserOrderService.updateTUserOrder(dto);
		if (result) {
			this.sendSuccess();
		}else{
			this.sendFailMsg("操作失败！");
		}
	}
	
	public void delete(){
		int orderId = ParameterUtil.getIntParameter(request, "id", 0);
		if (orderId <= 0) {
			this.sendFailMsg("无效订单ID！");
			return;
		}
		
		TUserOrderDTO dto = tUserOrderService.getTUserOrderById(orderId);
		if (dto == null) {
			this.sendFailMsg("无订单数据！");
			return;
		}
		
		boolean result = tUserOrderService.deleteTUserOrderById(orderId);
		if (result) {
			this.sendSuccess();
		}else{
			this.sendFailMsg("操作失败！");
		}
	}
}
