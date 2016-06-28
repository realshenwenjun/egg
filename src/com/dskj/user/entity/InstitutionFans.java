package com.dskj.user.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by chenbo on 2016/4/27.
 */
public class InstitutionFans implements Serializable {
    private static final long serialVersionUID = 7807943679167752608L;

    private Integer id;
    private String institutionId;
    private String userId;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}
