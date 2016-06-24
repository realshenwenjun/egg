package com.dskj.community.entity;

import java.io.Serializable;
import java.util.Date;

public class Circle implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 7602235150412257261L;

    private Integer id;
    private String name;
    private String imgUrl;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


}
