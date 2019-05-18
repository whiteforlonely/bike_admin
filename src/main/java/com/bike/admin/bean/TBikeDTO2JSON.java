package com.bike.admin.bean;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonBeanProcessor;

import com.bike.admin.dto.TBikeDTO;

public class TBikeDTO2JSON implements JsonBeanProcessor{
	
	 public JSONObject processBean(Object bean, JsonConfig arg1) {
	        if(!(bean instanceof TBikeDTO || bean == null )){
	             return new JSONObject(true);
	         }
	        TBikeDTO  dto = (TBikeDTO)bean;

	         return new JSONObject()
	                    .element("userId",dto.getUserId())
	                    .element("siteId",dto.getSiteId())
	                    .element("bikeCode",dto.getBikeCode())
	                    .element("bikeAmount",dto.getBikeAmount())
	                    .element("color",dto.getColor())
	                    .element("status",dto.getStatu())
	                    .element("position", dto.getPosition())
	                    .element("appearance", dto.getAppearance())
	                    .element("useTime", dto.getUseTime())
	                    .element("endTime", dto.getEndTime())
	                    .element("createTime", dto.getCreateTime())
	                    
	         ;
	    }

}
