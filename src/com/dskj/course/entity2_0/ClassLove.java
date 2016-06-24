package com.dskj.course.entity2_0;

import java.io.Serializable;
import java.util.Date;

public class ClassLove implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7373772315608954518L;
	private Integer id;
	private Integer classId;
	private String userId;
	private Date createTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
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
