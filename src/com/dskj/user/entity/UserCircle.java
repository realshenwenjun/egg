package com.dskj.user.entity;

import java.io.Serializable;
import java.util.Date;

public class UserCircle implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1041972122499626192L;
    private Integer id;
    private String userId;
    private Integer circleId;
    private String circleName;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCircleName() {
        return circleName;
    }

    public void setCircleName(String circleName) {
        this.circleName = circleName;
    }

    public Integer getCircleId() {
        return circleId;
    }

    public void setCircleId(Integer circleId) {
        this.circleId = circleId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


}
