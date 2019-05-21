package com.bike.admin.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.bike.admin.bean.TSiteDTO2Json;
import com.bike.admin.dto.TSiteDTO;
import com.bike.admin.service.TSiteService;
import com.bike.admin.service.base.AdminServiceManager;
import com.bike.admin.util.ParameterUtil;

public class SiteAction extends BaseAction {
	
	private static TSiteService tSiteService = AdminServiceManager.getTSiteService();

	public SiteAction() {
		super();
	}
	
	public SiteAction(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
	}
	
	public void siteList(){
		int start = ParameterUtil.getIntParameter(request, "start", 0);
		int length = ParameterUtil.getIntParameter(request, "length", 20);
		String name = ParameterUtil.getStringParameter(request, "name", "");
		int id = ParameterUtil.getIntParameter(request, "id", 0);
		int userId = ParameterUtil.getIntParameter(request, "userId", 0);
		
		TSiteDTO dto = new TSiteDTO();
		dto.setId(id);
		dto.setName(name);
		dto.setUserId(userId);

		List<TSiteDTO> list = tSiteService.getList(dto, start, length);
		int totalCount = tSiteService.getCount(dto);
		JSONObject json = new JSONObject();
		if (totalCount == 0) {
			json.put("total", 0);
			json.put("list", "[]");
		} else {
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.registerJsonBeanProcessor(TSiteDTO.class, new TSiteDTO2Json());
			json.put("total", totalCount);
			json.put("list", JSONArray.fromObject(list, jsonConfig));
		}

		this.sendResult(json.toString());
	}
	
	public void addSite() {
		int userId= ParameterUtil.getIntParameter(request, "userId", 0);
		String name = ParameterUtil.getStringParameter(request, "name", "");
		int bikeQuantity= ParameterUtil.getIntParameter(request, "bikeQuantity", 0);
		String siteSize= ParameterUtil.getStringParameter(request, "siteSize", "");
		String position = ParameterUtil.getStringParameter(request, "sitePosition","");
		
		TSiteDTO dto = new TSiteDTO();
		dto.setUserId(userId);
		dto.setName(name);
		dto.setBikeQuantity(bikeQuantity);
		dto.setSitePosition(position);
		dto.setSiteSize(siteSize);
		dto.setCreateTime(new Date());

		int result = tSiteService.saveTSite(dto);

		if (result > 0) {
			this.sendSuccessMsg("保存成功！");
		} else {
			this.sendFailMsg("保存失败！");
		}
	}
	
	public void deleteSite() {
		int id = ParameterUtil.getIntParameter(request, "id", 0);

		TSiteDTO dto = tSiteService.getTSiteById(id);
		if (dto == null) {
			this.sendFailMsg("站点不存在！");
			return;
		}

		boolean result = tSiteService.deleteTSiteById(id);

		if (result) {
			this.sendSuccessMsg("删除成功！");
		} else {
			this.sendFailMsg("删除失败！");
		}
	}
	
	public void modifySite() {
		int id = ParameterUtil.getIntParameter(request, "id", 0);
		String name = ParameterUtil.getStringParameter(request, "name", "");
		int bikeQuantity= ParameterUtil.getIntParameter(request, "bikeQuantity", 0);
		String siteSize= ParameterUtil.getStringParameter(request, "siteSize", "");
		String position = ParameterUtil.getStringParameter(request, "sitePosition","");

		if (id <= 0) {
			this.sendFailMsg("错误ID！");
			return;
		}
		
		TSiteDTO dto = tSiteService.getTSiteById(id);
		if (dto == null) {
			this.sendFailMsg("账号不存在！");
			return;
		}

		dto.setBikeQuantity(bikeQuantity);
		dto.setSitePosition(position);
		dto.setSiteSize(siteSize);
		dto.setName(name);


		boolean result = tSiteService.updateTSite(dto);

		if (result) {
			this.sendSuccessMsg("修改成功！");
		} else {
			this.sendFailMsg("修改失败！");
		}
	}
}
