package com.dskj.user.entity;

import java.io.Serializable;
import java.util.Date;

public class InstitutionLove implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 8127069083467008413L;

    private Integer id;
    private String InstitutionId;
    private String userId;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInstitutionId() {
        return InstitutionId;
    }

    public void setInstitutionId(String institutionId) {
        InstitutionId = institutionId;
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


}
