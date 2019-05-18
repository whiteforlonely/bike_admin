package com.bike.admin.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.Date;

/**
 * 这是t_site的数据传输对象直接与表对应,只允许在dao与service之间传递<br>
 */
public  class TSiteModel  implements Serializable {

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
     * 属性:站点大小<br>
     * 含义:站点大小<br>
     */
    private String siteSize = "";
    /**
     * 属性:站点位置<br>
     * 含义:站点位置<br>
     */
    private String sitePosition = "";
    /**
     * 属性:站点可容纳的车辆数量<br>
     * 含义:站点可容纳的车辆数量<br>
     */
    private Integer bikeQuantity = 0;
    /**
     * 属性:站点发布时间<br>
     * 含义:站点发布时间<br>
     */
    private Date createTime = new Date();

    /**
     *  默认构造方法,构造一个默认的TSiteModel对象
     */
    public TSiteModel(){
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
     * 设置属性站点大小<br>
     * 含义:站点大小<br>
     * @param siteSize 待设置的属性站点大小的值
     */
    public void setSiteSize(String siteSize) {
        this.siteSize = siteSize;
    }

    /**
     * 获取属性站点大小<br>
     * 含义:站点大小<br>
     * @return 属性站点大小的值
     */
    public String getSiteSize() {
        return siteSize;
    }

    /**
     * 设置属性站点位置<br>
     * 含义:站点位置<br>
     * @param sitePosition 待设置的属性站点位置的值
     */
    public void setSitePosition(String sitePosition) {
        this.sitePosition = sitePosition;
    }

    /**
     * 获取属性站点位置<br>
     * 含义:站点位置<br>
     * @return 属性站点位置的值
     */
    public String getSitePosition() {
        return sitePosition;
    }

    /**
     * 设置属性站点可容纳的车辆数量<br>
     * 含义:站点可容纳的车辆数量<br>
     * @param bikeQuantity 待设置的属性站点可容纳的车辆数量的值
     */
    public void setBikeQuantity(Integer bikeQuantity) {
        this.bikeQuantity = bikeQuantity;
    }

    /**
     * 获取属性站点可容纳的车辆数量<br>
     * 含义:站点可容纳的车辆数量<br>
     * @return 属性站点可容纳的车辆数量的值
     */
    public Integer getBikeQuantity() {
        return bikeQuantity;
    }

    /**
     * 设置属性站点发布时间<br>
     * 含义:站点发布时间<br>
     * @param createTime 待设置的属性站点发布时间的值
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取属性站点发布时间<br>
     * 含义:站点发布时间<br>
     * @return 属性站点发布时间的值
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
        if (!(other instanceof TSiteModel)) {
            return false;
        }

        final TSiteModel otherModel = (TSiteModel) other;
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
        sb.append("\"siteSize\":\""+this.getSiteSize()+"\"");
        sb.append(",");
        sb.append("\"sitePosition\":\""+this.getSitePosition()+"\"");
        sb.append(",");
        sb.append("\"bikeQuantity\":"+this.getBikeQuantity());
        sb.append(",");
        sb.append("\"createTime\":\""+this.getCreateTime()+"\"");
        sb.append("}"); 
        return sb.toString(); 
    }

}
