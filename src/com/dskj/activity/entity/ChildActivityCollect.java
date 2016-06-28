package com.dskj.activity.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by chenbo on 2016/4/8.
 */
public class ChildActivityCollect implements Serializable {
    private static final long serialVersionUID = 7547877020261854647L;

    private Integer id;
    private String userId;
    private Integer activityId;
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

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
