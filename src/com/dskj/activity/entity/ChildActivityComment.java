package com.dskj.activity.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 亲子活动评论
 *
 * @author 马金�?
 */
public class ChildActivityComment implements Serializable {

    private static final long serialVersionUID = 2941300610702362484L;
    private Integer id;
    private Integer activityId;
    private Integer commentId;

    private Date createTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }
}