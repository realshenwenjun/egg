package com.dskj.user.entity;

import java.io.Serializable;
import java.util.Date;

public class InstitutionUserEntity implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -8002804061984338179L;
    private int id;
    private String institutionId;
    private String userId;
    private Integer current;
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

}
