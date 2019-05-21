package com.bike.admin.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.Date;

/**
 * 这是t_bike的数据传输对象直接与表对应,只允许在dao与service之间传递<br>
 */
public  class TBikeModel  implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 属性:id<br>
     */
    private Integer id = 0;
    /**
     * 属性:用户ID<br>
     * 含义:用户ID<br>
     */
    private Integer userId = 0;
    /**
     * 属性:站点ID<br>
     * 含义:站点ID<br>
     */
    private Integer siteId = 0;
    /**
     * 属性:车辆编号<br>
     * 含义:车辆编号<br>
     */
    private String bikeCode = "";
    /**
     * 属性:使用车辆所需金额<br>
     * 含义:使用车辆所需金额<br>
     */
    private Double bikeAmount = 0.0;
    /**
     * 属性:车辆颜色<br>
     * 含义:车辆颜色<br>
     */
    private String color = "";
    /**
     * 属性:使用状态：1=使用中；2=未使用；3=车辆故障；<br>
     * 含义:使用状态：1=使用中；2=未使用；3=车辆故障；<br>
     */
    private Integer status = 0;
    /**
     * 属性:车辆所属位置<br>
     * 含义:车辆所属位置<br>
     */
    private String position = "";
    /**
     * 属性:自行车外观新旧程度<br>
     * 含义:自行车外观新旧程度<br>
     */
    private String appearance = "";
    /**
     * 属性:车辆开始使用时间<br>
     * 含义:车辆开始使用时间<br>
     */
    private Date useTime = new Date();
    /**
     * 属性:车辆最后使用时间<br>
     * 含义:车辆最后使用时间<br>
     */
    private Date endTime = new Date();
    /**
     * 属性:车辆发布时间<br>
     * 含义:车辆发布时间<br>
     */
    private Date createTime = new Date();

    /**
     *  默认构造方法,构造一个默认的TBikeModel对象
     */
    public TBikeModel(){
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
     * 设置属性用户ID<br>
     * 含义:用户ID<br>
     * @param userId 待设置的属性用户ID的值
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取属性用户ID<br>
     * 含义:用户ID<br>
     * @return 属性用户ID的值
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置属性站点ID<br>
     * 含义:站点ID<br>
     * @param siteId 待设置的属性站点ID的值
     */
    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    /**
     * 获取属性站点ID<br>
     * 含义:站点ID<br>
     * @return 属性站点ID的值
     */
    public Integer getSiteId() {
        return siteId;
    }

    /**
     * 设置属性车辆编号<br>
     * 含义:车辆编号<br>
     * @param bikeCode 待设置的属性车辆编号的值
     */
    public void setBikeCode(String bikeCode) {
        this.bikeCode = bikeCode;
    }

    /**
     * 获取属性车辆编号<br>
     * 含义:车辆编号<br>
     * @return 属性车辆编号的值
     */
    public String getBikeCode() {
        return bikeCode;
    }

    /**
     * 设置属性使用车辆所需金额<br>
     * 含义:使用车辆所需金额<br>
     * @param bikeAmount 待设置的属性使用车辆所需金额的值
     */
    public void setBikeAmount(Double bikeAmount) {
        this.bikeAmount = bikeAmount;
    }

    /**
     * 获取属性使用车辆所需金额<br>
     * 含义:使用车辆所需金额<br>
     * @return 属性使用车辆所需金额的值
     */
    public Double getBikeAmount() {
        return bikeAmount;
    }

    /**
     * 设置属性车辆颜色<br>
     * 含义:车辆颜色<br>
     * @param color 待设置的属性车辆颜色的值
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * 获取属性车辆颜色<br>
     * 含义:车辆颜色<br>
     * @return 属性车辆颜色的值
     */
    public String getColor() {
        return color;
    }

    /**
     * 设置属性使用状态：1=使用中；2=未使用；3=车辆故障；<br>
     * 含义:使用状态：1=使用中；2=未使用；3=车辆故障；<br>
     * @param status 待设置的属性使用状态：1=使用中；2=未使用；3=车辆故障；的值
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取属性使用状态：1=使用中；2=未使用；3=车辆故障；<br>
     * 含义:使用状态：1=使用中；2=未使用；3=车辆故障；<br>
     * @return 属性使用状态：1=使用中；2=未使用；3=车辆故障；的值
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置属性车辆所属位置<br>
     * 含义:车辆所属位置<br>
     * @param position 待设置的属性车辆所属位置的值
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * 获取属性车辆所属位置<br>
     * 含义:车辆所属位置<br>
     * @return 属性车辆所属位置的值
     */
    public String getPosition() {
        return position;
    }

    /**
     * 设置属性自行车外观新旧程度<br>
     * 含义:自行车外观新旧程度<br>
     * @param appearance 待设置的属性自行车外观新旧程度的值
     */
    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }

    /**
     * 获取属性自行车外观新旧程度<br>
     * 含义:自行车外观新旧程度<br>
     * @return 属性自行车外观新旧程度的值
     */
    public String getAppearance() {
        return appearance;
    }

    /**
     * 设置属性车辆开始使用时间<br>
     * 含义:车辆开始使用时间<br>
     * @param useTime 待设置的属性车辆开始使用时间的值
     */
    public void setUseTime(Date useTime) {
        this.useTime = useTime;
    }

    /**
     * 获取属性车辆开始使用时间<br>
     * 含义:车辆开始使用时间<br>
     * @return 属性车辆开始使用时间的值
     */
    public Date getUseTime() {
        return useTime;
    }

    /**
     * 设置属性车辆最后使用时间<br>
     * 含义:车辆最后使用时间<br>
     * @param endTime 待设置的属性车辆最后使用时间的值
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取属性车辆最后使用时间<br>
     * 含义:车辆最后使用时间<br>
     * @return 属性车辆最后使用时间的值
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置属性车辆发布时间<br>
     * 含义:车辆发布时间<br>
     * @param createTime 待设置的属性车辆发布时间的值
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取属性车辆发布时间<br>
     * 含义:车辆发布时间<br>
     * @return 属性车辆发布时间的值
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
        if (!(other instanceof TBikeModel)) {
            return false;
        }

        final TBikeModel otherModel = (TBikeModel) other;
        if (getId()!=null && !getId().equals(otherModel.getId())) {
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
        sb.append("\"userId\":"+this.getUserId());
        sb.append(",");
        sb.append("\"siteId\":"+this.getSiteId());
        sb.append(",");
        sb.append("\"bikeCode\":\""+this.getBikeCode()+"\"");
        sb.append(",");
        sb.append("\"bikeAmount\":"+this.getBikeAmount());
        sb.append(",");
        sb.append("\"color\":\""+this.getColor()+"\"");
        sb.append(",");
        sb.append("\"status\":"+this.getStatus());
        sb.append(",");
        sb.append("\"position\":\""+this.getPosition()+"\"");
        sb.append(",");
        sb.append("\"appearance\":\""+this.getAppearance()+"\"");
        sb.append(",");
        sb.append("\"useTime\":\""+this.getUseTime()+"\"");
        sb.append(",");
        sb.append("\"endTime\":\""+this.getEndTime()+"\"");
        sb.append(",");
        sb.append("\"createTime\":\""+this.getCreateTime()+"\"");
        sb.append("}"); 
        return sb.toString(); 
    }

}
