package com.dskj.message.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by chenbo on 2016/4/1.
 */
public class MessageConfig implements Serializable {
    private static final long serialVersionUID = 7631794998041034771L;

    private Integer id;

    private String key;
    private String value;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
