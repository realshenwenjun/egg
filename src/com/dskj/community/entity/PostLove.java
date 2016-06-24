package com.dskj.community.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by chenbo on 2016/4/15.
 */
public class PostLove implements Serializable {
    private static final long serialVersionUID = -2589830732317423698L;
    private Integer id;
    private Integer postId;
    private String userId;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
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
