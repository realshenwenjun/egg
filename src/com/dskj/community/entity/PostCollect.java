package com.dskj.community.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by chenbo on 2016/4/15.
 */
public class PostCollect implements Serializable {
    private static final long serialVersionUID = 416695653666742530L;
    private Integer id;
    private String userId;
    private Integer postId;
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

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
