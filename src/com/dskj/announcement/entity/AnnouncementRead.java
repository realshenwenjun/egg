package com.dskj.announcement.entity;

import java.io.Serializable;
import java.util.Date;

public class AnnouncementRead implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2133753110990730076L;
	private Integer id;
	private String userId;
	private Integer announcementId;
	private String institutionId;
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
	public Integer getAnnouncementId() {
		return announcementId;
	}
	public void setAnnouncementId(Integer announcementId) {
		this.announcementId = announcementId;
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
	
}
