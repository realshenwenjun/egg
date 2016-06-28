package com.dskj.user.entity;

import java.io.Serializable;
import java.util.Date;

public class UserLoginLog implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 5882134151941217624L;
    private int id;
    private String userId;
    private String userName;
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
