package com.bike.admin.bean;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonBeanProcessor;

import com.bike.admin.dto.TAdminUserDTO;
import com.bike.admin.util.EncryUtil;

/**
 * AdminUserDTO转化为Json
 * @author autoTool 工具生成
 */
public class AdminUser2JSON implements JsonBeanProcessor {

    public JSONObject processBean(Object bean, JsonConfig arg1) {
        if(!(bean instanceof TAdminUserDTO || bean == null )){
             return new JSONObject(true);
         }
        TAdminUserDTO  adminUserDto = (TAdminUserDTO)bean;

         return new JSONObject()
                    .element("id",adminUserDto.getId())
                    .element("nickname",adminUserDto.getNickname())
                    .element("mobilephone",adminUserDto.getMobilephone())
                    .element("password",EncryUtil.decode(adminUserDto.getPassword()))
                    .element("userType",adminUserDto.getUserType())
                    .element("auths",adminUserDto.getAuths())
                    .element("status",adminUserDto.getStatus())
         ;
    }

}
