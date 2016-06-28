package com.dskj.course.entity;

import java.io.Serializable;
import java.util.Date;

public class ClassSign implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6496800334233634976L;
	private int id;
	private int classId;
	private String userId;
	private String institutionId;
	private Date createTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
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
	
}
