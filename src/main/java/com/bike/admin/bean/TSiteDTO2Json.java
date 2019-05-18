package com.bike.admin.bean;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonBeanProcessor;

import com.bike.admin.dto.TSiteDTO;

public class TSiteDTO2Json  implements JsonBeanProcessor{
	
	 public JSONObject processBean(Object bean, JsonConfig arg1) {
	        if(!(bean instanceof TSiteDTO || bean == null )){
	             return new JSONObject(true);
	         }
	        TSiteDTO  dto = (TSiteDTO)bean;

	         return new JSONObject()
	                    .element("id",dto.getId())
	                    .element("userId", dto.getUserId())
	                    .element("siteSize",dto.getSiteSize())
	                    .element("sitePosition",dto.getSitePosition())
	                    .element("bikeQuantity",dto.getBikeQuantity())
	                    .element("createTime", dto.getCreateTime())
	         ;
	    }

}
