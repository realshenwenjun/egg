package com.dskj.user.entity2_0;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2016/5/11.
 */
public class UserPhoto implements Serializable {
    private static final long serialVersionUID = 3818062277068053928L;
    private Integer id;
    private String userId;
    private String url;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
