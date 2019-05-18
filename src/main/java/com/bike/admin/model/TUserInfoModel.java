package com.bike.admin.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.Date;

/**
 * 这是t_user_info的数据传输对象直接与表对应,只允许在dao与service之间传递<br>
 */
public  class TUserInfoModel  implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 属性:id<br>
     */
    private Integer id = 0;
    /**
     * 属性:用户类型：1=发布者；2=使用者<br>
     * 含义:用户类型：1=发布者；2=使用者<br>
     */
    private Integer userType = 0;
    /**
     * 属性:用户性别：1=男；2=女<br>
     * 含义:用户性别：1=男；2=女<br>
     */
    private Integer userSex = 0;
    /**
     * 属性:用户名<br>
     * 含义:用户名<br>
     */
    private String userName = "";
    /**
     * 属性:用户手机号<br>
     * 含义:用户手机号<br>
     */
    private String phoneNum = "";
    /**
     * 属性:登录密码<br>
     * 含义:登录密码<br>
     */
    private String password = "";
    /**
     * 属性:用户身份证号<br>
     * 含义:用户身份证号<br>
     */
    private String identityCard = "";
    /**
     * 属性:用户账号余额<br>
     * 含义:用户账号余额<br>
     */
    private Double amount = 0.0;
    /**
     * 属性:用户注册时间<br>
     * 含义:用户注册时间<br>
     */
    private Date createTime = new Date();

    /**
     *  默认构造方法,构造一个默认的TUserInfoModel对象
     */
    public TUserInfoModel(){
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
     * 设置属性用户类型：1=发布者；2=使用者<br>
     * 含义:用户类型：1=发布者；2=使用者<br>
     * @param userType 待设置的属性用户类型：1=发布者；2=使用者的值
     */
    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    /**
     * 获取属性用户类型：1=发布者；2=使用者<br>
     * 含义:用户类型：1=发布者；2=使用者<br>
     * @return 属性用户类型：1=发布者；2=使用者的值
     */
    public Integer getUserType() {
        return userType;
    }

    /**
     * 设置属性用户性别：1=男；2=女<br>
     * 含义:用户性别：1=男；2=女<br>
     * @param userSex 待设置的属性用户性别：1=男；2=女的值
     */
    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    /**
     * 获取属性用户性别：1=男；2=女<br>
     * 含义:用户性别：1=男；2=女<br>
     * @return 属性用户性别：1=男；2=女的值
     */
    public Integer getUserSex() {
        return userSex;
    }

    /**
     * 设置属性用户名<br>
     * 含义:用户名<br>
     * @param userName 待设置的属性用户名的值
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取属性用户名<br>
     * 含义:用户名<br>
     * @return 属性用户名的值
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置属性用户手机号<br>
     * 含义:用户手机号<br>
     * @param phoneNum 待设置的属性用户手机号的值
     */
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    /**
     * 获取属性用户手机号<br>
     * 含义:用户手机号<br>
     * @return 属性用户手机号的值
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     * 设置属性登录密码<br>
     * 含义:登录密码<br>
     * @param password 待设置的属性登录密码的值
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取属性登录密码<br>
     * 含义:登录密码<br>
     * @return 属性登录密码的值
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置属性用户身份证号<br>
     * 含义:用户身份证号<br>
     * @param identityCard 待设置的属性用户身份证号的值
     */
    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    /**
     * 获取属性用户身份证号<br>
     * 含义:用户身份证号<br>
     * @return 属性用户身份证号的值
     */
    public String getIdentityCard() {
        return identityCard;
    }

    /**
     * 设置属性用户账号余额<br>
     * 含义:用户账号余额<br>
     * @param amount 待设置的属性用户账号余额的值
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * 获取属性用户账号余额<br>
     * 含义:用户账号余额<br>
     * @return 属性用户账号余额的值
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * 设置属性用户注册时间<br>
     * 含义:用户注册时间<br>
     * @param createTime 待设置的属性用户注册时间的值
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取属性用户注册时间<br>
     * 含义:用户注册时间<br>
     * @return 属性用户注册时间的值
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
        if (!(other instanceof TUserInfoModel)) {
            return false;
        }

        final TUserInfoModel otherModel = (TUserInfoModel) other;
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
        sb.append("\"userType\":"+this.getUserType());
        sb.append(",");
        sb.append("\"userSex\":"+this.getUserSex());
        sb.append(",");
        sb.append("\"userName\":\""+this.getUserName()+"\"");
        sb.append(",");
        sb.append("\"phoneNum\":\""+this.getPhoneNum()+"\"");
        sb.append(",");
        sb.append("\"password\":\""+this.getPassword()+"\"");
        sb.append(",");
        sb.append("\"identityCard\":\""+this.getIdentityCard()+"\"");
        sb.append(",");
        sb.append("\"amount\":"+this.getAmount());
        sb.append(",");
        sb.append("\"createTime\":\""+this.getCreateTime()+"\"");
        sb.append("}"); 
        return sb.toString(); 
    }

}
