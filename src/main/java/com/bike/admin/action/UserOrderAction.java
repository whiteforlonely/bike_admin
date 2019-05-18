package com.bike.admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bike.admin.service.TUserOrderService;
import com.bike.admin.service.base.AdminServiceManager;

public class UserOrderAction extends BaseAction{
	
	private static TUserOrderService tUserOrderService = AdminServiceManager.getTUserOrderService();

	public UserOrderAction() {
		super();
	}

	public UserOrderAction(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
	}
	
//	public void getOrderList() {
//		int orderId = ParameterUtil.getIntParameter(request, "id", 0);
//		int useId = ParameterUtil.getIntParameter(request, "useId", 0);
//		int issueId = ParameterUtil.getIntParameter(request, "issueId", 0);
//		int bikeId = ParameterUtil.getIntParameter(request, "bikeId", 0);
//		String createTimeStart = ParameterUtil.getStringParameter(request, "createTimeStart", "");
//		String createTimeEnd = ParameterUtil.getStringParameter(request, "createTimeEnd", "");
//		String paySuccessTimeStart = ParameterUtil.getStringParameter(request, "paySuccessTimeStart", "");
//		String paySuccessTimeEnd = ParameterUtil.getStringParameter(request, "paySuccessTimeEnd", "");
//		int start = ParameterUtil.getIntParameter(request, "start", 0);
//		int length = ParameterUtil.getIntParameter(request, "length", 20);
//		int status = ParameterUtil.getIntParameter(request, "status", -1000);
//		String orderCode = ParameterUtil.getStringParameter(request, "orderCode", "");
//
//		TUserOrderDTO searchDto = new TUserOrderDTO();
//		searchDto.setId(orderId);
//		searchDto.setOrderStatus(status);
//		searchDto.setOrderCode(orderCode);
//		searchDto.setUseId(useId);
//		searchDto.setIssueId(issueId);
//		searchDto.setBikeId(bikeId);
//
//		List<TUserOrderDTO> list = tUserOrderService.adminList(searchDto, start, length, createTimeStart, createTimeEnd, paySuccessTimeStart, paySuccessTimeEnd);
//		int totalCount = tUserOrderService.adminCount(searchDto, createTimeStart, createTimeEnd, paySuccessTimeStart, paySuccessTimeEnd);
//		JSONObject json = new JSONObject();
//		if (totalCount == 0) {
//			json.put("total", 0);
//			json.put("list", "[]");
//		} else {
//			JsonConfig jsonConfig = new JsonConfig();
//			jsonConfig.registerJsonBeanProcessor(TUserOrderDTO.class, new TUserOrder2JSON());
//			json.put("list", JSONArray.fromObject(list, jsonConfig));
//			json.put("total", totalCount);
//		}
//		this.sendResult(json.toString());
//	}
}
