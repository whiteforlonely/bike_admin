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
import com.bike.admin.service.TBikeService;
import com.bike.admin.service.base.AdminServiceManager;
import com.bike.admin.util.ParameterUtil;

public class BikeAction extends BaseAction{
	
	private TBikeService tBikeService = AdminServiceManager.getTBikeService();
	
	public BikeAction() {
		super();
	}

	public BikeAction(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
	}
	
	public void bikeList() {
		int start = ParameterUtil.getIntParameter(request, "start", 0);
		int length = ParameterUtil.getIntParameter(request, "length", 20);

		List<TBikeDTO> list = tBikeService.getPage(start, length);
		int totalCount = tBikeService.getCount();
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
		String color = ParameterUtil.getStringParameter(request, "color", "黑");
		String position = ParameterUtil.getStringParameter(request, "position", "二环西路");
		String appearance = ParameterUtil.getStringParameter(request, "appearance", "新");

		TBikeDTO dto = new TBikeDTO();
		dto.setUserId(userId);
		dto.setSiteId(siteId);
		dto.setBikeAmount(bikeAmount);
		dto.setColor(color);
		dto.setPosition(position);
		dto.setAppearance(appearance);
		dto.setStatu(2);
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
		double bikeAmount = ParameterUtil.getDoubleParameter(request, "bikeAmount", 0);
		String color = ParameterUtil.getStringParameter(request, "color", "");
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

}
