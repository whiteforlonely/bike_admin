package com.bike.admin.dto.base;

import java.io.Serializable;
import com.systemframework.annotations.Field;
import java.util.Date;

/**
 * 与t_admin_userModel形成映射，只允许在api接口与service之间传递<br>
 * @author autoTool 工具生成
 */
public  class TAdminUserDTOBase  implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 属性:id<br>
     */
     @Field(name="id")
    private Integer id = 0;
    /**
     * 属性:昵称<br>
     * 含义:昵称<br>
     */
     @Field(name="nickname")
    private String nickname = "";
    /**
     * 属性:手机号<br>
     * 含义:手机号<br>
     */
     @Field(name="mobilephone")
    private String mobilephone = "";
    /**
     * 属性:密码<br>
     * 含义:密码<br>
     */
     @Field(name="password")
    private String password = "";
    /**
     * 属性:用户类型<br>
     * 含义:用户类型<br>
     */
     @Field(name="userType")
    private Integer userType = 0;
    /**
     * 属性:操作权限<br>
     * 含义:操作权限<br>
     */
     @Field(name="auths")
    private String auths = "";
    /**
     * 属性:创建账号时间<br>
     * 含义:创建账号时间<br>
     */
     @Field(name="createTime")
    private Date createTime = new Date();
    /**
     * 属性:管理员状态 0正常 1停用 -100删除<br>
     * 含义:管理员状态 0正常 1停用 -100删除<br>
     */
     @Field(name="status")
    private Integer status = 0;

    /**
     *  默认构造方法,构造一个默认的TAdminUserDTOBase对象
     */
    public TAdminUserDTOBase(){
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
     * 设置属性昵称<br>
     * 含义:昵称<br>
     * @param nickname 待设置的属性昵称的值
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取属性昵称<br>
     * 含义:昵称<br>
     * @return 属性昵称的值
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置属性手机号<br>
     * 含义:手机号<br>
     * @param mobilephone 待设置的属性手机号的值
     */
    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    /**
     * 获取属性手机号<br>
     * 含义:手机号<br>
     * @return 属性手机号的值
     */
    public String getMobilephone() {
        return mobilephone;
    }

    /**
     * 设置属性密码<br>
     * 含义:密码<br>
     * @param password 待设置的属性密码的值
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取属性密码<br>
     * 含义:密码<br>
     * @return 属性密码的值
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置属性用户类型<br>
     * 含义:用户类型<br>
     * @param userType 待设置的属性用户类型的值
     */
    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    /**
     * 获取属性用户类型<br>
     * 含义:用户类型<br>
     * @return 属性用户类型的值
     */
    public Integer getUserType() {
        return userType;
    }

    /**
     * 设置属性操作权限<br>
     * 含义:操作权限<br>
     * @param auths 待设置的属性操作权限的值
     */
    public void setAuths(String auths) {
        this.auths = auths;
    }

    /**
     * 获取属性操作权限<br>
     * 含义:操作权限<br>
     * @return 属性操作权限的值
     */
    public String getAuths() {
        return auths;
    }

    /**
     * 设置属性创建账号时间<br>
     * 含义:创建账号时间<br>
     * @param createTime 待设置的属性创建账号时间的值
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取属性创建账号时间<br>
     * 含义:创建账号时间<br>
     * @return 属性创建账号时间的值
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置属性管理员状态 0正常 1停用 -100删除<br>
     * 含义:管理员状态 0正常 1停用 -100删除<br>
     * @param status 待设置的属性管理员状态 0正常 1停用 -100删除的值
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取属性管理员状态 0正常 1停用 -100删除<br>
     * 含义:管理员状态 0正常 1停用 -100删除<br>
     * @return 属性管理员状态 0正常 1停用 -100删除的值
     */
    public Integer getStatus() {
        return status;
    }


    /**
     * 比较两个对象在逻辑上是否相等
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TAdminUserDTOBase)) {
            return false;
        }

        final TAdminUserDTOBase otherDto = (TAdminUserDTOBase) other;
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
        sb.append("\"nickname\":\""+this.getNickname()+"\"");
        sb.append(",");
        sb.append("\"mobilephone\":\""+this.getMobilephone()+"\"");
        sb.append(",");
        sb.append("\"password\":\""+this.getPassword()+"\"");
        sb.append(",");
        sb.append("\"userType\":"+this.getUserType());
        sb.append(",");
        sb.append("\"auths\":\""+this.getAuths()+"\"");
        sb.append(",");
        sb.append("\"createTime\":\""+this.getCreateTime()+"\"");
        sb.append(",");
        sb.append("\"status\":"+this.getStatus());
        sb.append("}"); 
        return sb.toString(); 
    }

}
