package com.bike.admin.bean;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonBeanProcessor;

import com.bike.admin.dto.TUserInfoDTO;
import com.bike.admin.util.EncryUtil;
import com.bike.admin.util.TimeUtils;

public class TUserInfoDTO2JSON implements JsonBeanProcessor{
	
	public JSONObject processBean(Object bean, JsonConfig arg1) {
        if(!(bean instanceof TUserInfoDTO || bean == null )){
             return new JSONObject(true);
         }
        TUserInfoDTO  dto = (TUserInfoDTO)bean;

         return new JSONObject()
         			.element("id", dto.getId())
                    .element("userType",dto.getUserType())
                    .element("sex",dto.getSex())
                    .element("userName", dto.getUserName())
                    .element("phoneNum",dto.getPhoneNum())
                    .element("password",EncryUtil.decode(dto.getPassword()))
                    .element("identityCard",dto.getIdentityCard())
                    .element("amount",dto.getAmount())
                    .element("createTime", TimeUtils.dateToString(dto.getCreateTime()))
                    .element("status", dto.getStatus())
                    .element("address", dto.getAddress())
         ;
    }


}
