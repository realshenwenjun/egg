package com.dskj.community.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * InformationCollect
 *
 * @author shenwenjun
 * @date 2016/8/5
 */
public class InformationCollect implements Serializable {
    private Integer id;
    private Integer infoId;
    private String userId;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
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
