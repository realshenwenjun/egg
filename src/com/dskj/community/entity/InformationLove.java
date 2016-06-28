package com.dskj.community.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * InformationLove
 *
 * @author shenwenjun
 * @date 2016/5/24
 */
public class InformationLove implements Serializable{
    private static final long serialVersionUID = 2501597680252695116L;
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
