package com.dskj.user.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by chenbo on 2016/4/28.
 */
public class UserVisit implements Serializable {
    private static final long serialVersionUID = 3385323270025127299L;

    private Integer id;
    private String userId;
    private String beenUserId;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBeenUserId() {
        return beenUserId;
    }

    public void setBeenUserId(String beenUserId) {
        this.beenUserId = beenUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
