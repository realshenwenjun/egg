package com.dskj.user.entity;

import java.io.Serializable;
import java.util.Date;

public class Role implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1187696697600518504L;
    private int id;
    private String name;
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
