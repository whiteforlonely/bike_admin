package com.bike.admin.bean;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonBeanProcessor;
import com.bike.admin.dto.TUserOrderDTO;
import com.bike.admin.util.TimeUtils;

/**
 * TUserOrderDTO转化为Json
 * @author autoTool 工具生成
 */
public  class TUserOrder2JSON implements JsonBeanProcessor {

    public JSONObject processBean(Object bean, JsonConfig arg1) {
        if(!(bean instanceof TUserOrderDTO || bean == null )){
             return new JSONObject(true);
         }
         TUserOrderDTO  tUserOrderDto = (TUserOrderDTO)bean;

         return new JSONObject()
                    .element("id",tUserOrderDto.getId())
                    .element("useId",tUserOrderDto.getUseId())
                    .element("issueId",tUserOrderDto.getIssueId())
                    .element("bikeId",tUserOrderDto.getBikeId())
                    .element("orderCode",tUserOrderDto.getOrderCode())
                    .element("orderType",tUserOrderDto.getOrderType())
                    .element("amount",tUserOrderDto.getAmount())
                    .element("orderStatus",tUserOrderDto.getOrderStatus())
                    .element("createTime",TimeUtils.dateToString(tUserOrderDto.getCreateTime()))
         ;
    }

}
