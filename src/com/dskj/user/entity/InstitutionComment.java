package com.dskj.user.entity;

import java.io.Serializable;
import java.util.Date;

public class InstitutionComment implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 8127069083467008413L;

    private Integer id;
    private String InstitutionId;
    private Integer commentId;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInstitutionId() {
        return InstitutionId;
    }

    public void setInstitutionId(String institutionId) {
        InstitutionId = institutionId;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


}
