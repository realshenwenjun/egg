package com.dskj.user.entity2_0;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2016/5/17.
 */
public class UserAsk implements Serializable {

    private static final long serialVersionUID = -7748458529795753302L;

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
