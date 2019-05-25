package com.bike.admin.dto.base;

import java.io.Serializable;
import com.systemframework.annotations.Field;
import java.util.Date;

/**
 * 与t_user_orderModel形成映射，只允许在api接口与service之间传递<br>
 * @author autoTool 工具生成
 */
public  class TUserOrderDTOBase  implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 属性:id<br>
     */
     @Field(name="id")
    private Integer id = 0;
    /**
     * 属性:使用者用户ID<br>
     * 含义:使用者用户ID<br>
     */
     @Field(name="useId")
    private Integer useId = 0;
    /**
     * 属性:发布者用户ID<br>
     * 含义:发布者用户ID<br>
     */
     @Field(name="issueId")
    private Integer issueId = 0;
    /**
     * 属性:车辆ID<br>
     * 含义:车辆ID<br>
     */
     @Field(name="bikeId")
    private Integer bikeId = 0;
    /**
     * 属性:订单号<br>
     * 含义:订单号<br>
     */
     @Field(name="orderCode")
    private String orderCode = "";
    /**
     * 属性:订单类型 0=购买；1=租赁；<br>
     * 含义:订单类型 0=购买；1=租赁；<br>
     */
     @Field(name="orderType")
    private Integer orderType = 0;
    /**
     * 属性:订单金额<br>
     * 含义:订单金额<br>
     */
     @Field(name="amount")
    private Double amount = 0d;
    /**
     * 属性:订单状态：0=新建订单；5=下单失败；10=下单成功；<br>
     * 含义:订单状态：0=新建订单；5=下单失败；10=下单成功；<br>
     */
     @Field(name="orderStatus")
    private Integer orderStatus = 0;
    /**
     * 属性:下单时间<br>
     * 含义:下单时间<br>
     */
     @Field(name="createTime")
    private Date createTime = new Date();

    /**
     *  默认构造方法,构造一个默认的TUserOrderDTOBase对象
     */
    public TUserOrderDTOBase(){
    }



    /**
     * 设置属性id<br>
     * @param id 待设置的属性id的值
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取属性id<br>
     * @return 属性id的值
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置属性使用者用户ID<br>
     * 含义:使用者用户ID<br>
     * @param useId 待设置的属性使用者用户ID的值
     */
    public void setUseId(Integer useId) {
        this.useId = useId;
    }

    /**
     * 获取属性使用者用户ID<br>
     * 含义:使用者用户ID<br>
     * @return 属性使用者用户ID的值
     */
    public Integer getUseId() {
        return useId;
    }

    /**
     * 设置属性发布者用户ID<br>
     * 含义:发布者用户ID<br>
     * @param issueId 待设置的属性发布者用户ID的值
     */
    public void setIssueId(Integer issueId) {
        this.issueId = issueId;
    }

    /**
     * 获取属性发布者用户ID<br>
     * 含义:发布者用户ID<br>
     * @return 属性发布者用户ID的值
     */
    public Integer getIssueId() {
        return issueId;
    }

    /**
     * 设置属性车辆ID<br>
     * 含义:车辆ID<br>
     * @param bikeId 待设置的属性车辆ID的值
     */
    public void setBikeId(Integer bikeId) {
        this.bikeId = bikeId;
    }

    /**
     * 获取属性车辆ID<br>
     * 含义:车辆ID<br>
     * @return 属性车辆ID的值
     */
    public Integer getBikeId() {
        return bikeId;
    }

    /**
     * 设置属性订单号<br>
     * 含义:订单号<br>
     * @param orderCode 待设置的属性订单号的值
     */
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    /**
     * 获取属性订单号<br>
     * 含义:订单号<br>
     * @return 属性订单号的值
     */
    public String getOrderCode() {
        return orderCode;
    }

    /**
     * 设置属性订单类型 0=购买；1=租赁；<br>
     * 含义:订单类型 0=购买；1=租赁；<br>
     * @param orderType 待设置的属性订单类型 0=购买；1=租赁；的值
     */
    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    /**
     * 获取属性订单类型 0=购买；1=租赁；<br>
     * 含义:订单类型 0=购买；1=租赁；<br>
     * @return 属性订单类型 0=购买；1=租赁；的值
     */
    public Integer getOrderType() {
        return orderType;
    }

    /**
     * 设置属性订单金额<br>
     * 含义:订单金额<br>
     * @param amount 待设置的属性订单金额的值
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * 获取属性订单金额<br>
     * 含义:订单金额<br>
     * @return 属性订单金额的值
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * 设置属性订单状态：0=新建订单；5=下单失败；10=下单成功；<br>
     * 含义:订单状态：0=新建订单；5=下单失败；10=下单成功；<br>
     * @param orderStatus 待设置的属性订单状态：0=新建订单；5=下单失败；10=下单成功；的值
     */
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * 获取属性订单状态：0=新建订单；5=下单失败；10=下单成功；<br>
     * 含义:订单状态：0=新建订单；5=下单失败；10=下单成功；<br>
     * @return 属性订单状态：0=新建订单；5=下单失败；10=下单成功；的值
     */
    public Integer getOrderStatus() {
        return orderStatus;
    }

    /**
     * 设置属性下单时间<br>
     * 含义:下单时间<br>
     * @param createTime 待设置的属性下单时间的值
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取属性下单时间<br>
     * 含义:下单时间<br>
     * @return 属性下单时间的值
     */
    public Date getCreateTime() {
        return createTime;
    }


    /**
     * 比较两个对象在逻辑上是否相等
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TUserOrderDTOBase)) {
            return false;
        }

        final TUserOrderDTOBase otherDto = (TUserOrderDTOBase) other;
        if (getId()!=null && !getId().equals(otherDto.getId())) {
            return false;
        }
        return true;
    }

    /**
     * 根据主键生成HashCode
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        StringBuffer buffer = new StringBuffer();
        buffer.append('|').append(id);
        return buffer.toString().hashCode();
    }


    public String toString() {
        StringBuffer sb = new StringBuffer(); 
        sb.append("{"); 
        sb.append("\"id\":"+this.getId());
        sb.append(",");
        sb.append("\"useId\":"+this.getUseId());
        sb.append(",");
        sb.append("\"issueId\":"+this.getIssueId());
        sb.append(",");
        sb.append("\"bikeId\":"+this.getBikeId());
        sb.append(",");
        sb.append("\"orderCode\":\""+this.getOrderCode()+"\"");
        sb.append(",");
        sb.append("\"orderType\":"+this.getOrderType());
        sb.append(",");
        sb.append("\"amount\":"+this.getAmount());
        sb.append(",");
        sb.append("\"orderStatus\":"+this.getOrderStatus());
        sb.append(",");
        sb.append("\"createTime\":\""+this.getCreateTime()+"\"");
        sb.append("}"); 
        return sb.toString(); 
    }

}
