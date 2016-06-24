package com.dskj.community.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * InformationImg
 *
 * @author shenwenjun
 * @date 2016/5/24
 */
public class InformationImg implements Serializable {
    private static final long serialVersionUID = 6084130928475820764L;
    private Integer id;
    private Integer infoId;
    private String url;
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
