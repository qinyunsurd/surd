package com.gulang.surd.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: gulang
 * Create Date : 2017/7/25
 * Company     : Garden Plus
 * Description :
 */
public class UserDO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**用户ID,对应用户主表的ID*/
    private String userId;
    /**用户手机*/
    private String mobile;
    /**用户账号*/
    private String userName;
    /**邮箱*/
    private String email;
    /**作用域*/
    private String appDomain;
    /**创建时间*/
    private Date createDate;
    /**修改时间*/
    private Date modDate;
    /**版本号*/
    private Integer rowVersion;
    /**是否删除*/
    private Integer isDel;
    /**用户状态*/
    private Integer status;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAppDomain() {
        return appDomain;
    }

    public void setAppDomain(String appDomain) {
        this.appDomain = appDomain;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModDate() {
        return modDate;
    }

    public void setModDate(Date modDate) {
        this.modDate = modDate;
    }

    public Integer getRowVersion() {
        return rowVersion;
    }

    public void setRowVersion(Integer rowVersion) {
        this.rowVersion = rowVersion;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserDO{" +
                "userId='" + userId + '\'' +
                ", mobile='" + mobile + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", appDomain='" + appDomain + '\'' +
                ", createDate=" + createDate +
                ", modDate=" + modDate +
                ", rowVersion=" + rowVersion +
                ", isDel=" + isDel +
                ", status=" + status +
                '}';
    }
}
