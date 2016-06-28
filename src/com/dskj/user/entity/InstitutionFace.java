package com.dskj.user.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class InstitutionFace implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -2710956498730714159L;
    private String id;
    private String name;
    private String fatherInstitution;
    private String summary;
    private String logo;
    private String face;
    private String tel;
    private String address;
    private String parentId;
    private String regionId;
    private Date createTime;
    private int visitCount;
    private int commentCount;
    private int fansCount;
    private int loveCount;
    private Integer fansId;
    private Integer loveId;
    private String sign;
    private List<String> courseName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public List<String> getCourseName() {
        return courseName;
    }

    public void setCourseName(List<String> courseName) {
        this.courseName = courseName;
    }

    public Integer getLoveId() {
        return loveId;
    }

    public void setLoveId(Integer loveId) {
        this.loveId = loveId;
    }

    public int getLoveCount() {
        return loveCount;
    }

    public void setLoveCount(int loveCount) {
        this.loveCount = loveCount;
    }

    public int getFansCount() {
        return fansCount;
    }

    public void setFansCount(int fansCount) {
        this.fansCount = fansCount;
    }

    public Integer getFansId() {
        return fansId;
    }

    public void setFansId(Integer fansId) {
        this.fansId = fansId;
    }

    public String getFatherInstitution() {
        return fatherInstitution;
    }

    public void setFatherInstitution(String fatherInstitution) {
        this.fatherInstitution = fatherInstitution;
    }

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
    
}
