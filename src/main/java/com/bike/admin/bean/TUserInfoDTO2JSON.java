package com.bike.admin.bean;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonBeanProcessor;

import com.bike.admin.dto.TUserInfoDTO;
import com.bike.admin.util.EncryUtil;

public class TUserInfoDTO2JSON implements JsonBeanProcessor{
	
	public JSONObject processBean(Object bean, JsonConfig arg1) {
        if(!(bean instanceof TUserInfoDTO || bean == null )){
             return new JSONObject(true);
         }
        TUserInfoDTO  dto = (TUserInfoDTO)bean;

         return new JSONObject()
                    .element("userType",dto.getUserType())
                    .element("userSex",dto.getUserSex())
                    .element("userName", dto.getUserName())
                    .element("mobilephone",dto.getPhoneNum())
                    .element("password",EncryUtil.decode(dto.getPassword()))
                    .element("identityCard",dto.getIdentityCard())
                    .element("amount",dto.getAmount())
                    .element("createTime", dto.getCreateTime())
         ;
    }


}
