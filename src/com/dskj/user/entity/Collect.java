package com.dskj.user.entity;

import java.io.Serializable;
import java.util.Date;

public class Collect implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 608883671169622446L;
    private Integer id;
    private String userId;
    private String institutionId;
    private Integer courseId;
    private Integer classId;
    private String beenUserId;
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

    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getBeenUserId() {
        return beenUserId;
    }

    public void setBeenUserId(String beenUserId) {
        this.beenUserId = beenUserId;
    }
}
