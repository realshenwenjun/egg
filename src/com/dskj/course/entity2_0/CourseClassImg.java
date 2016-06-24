package com.dskj.course.entity2_0;

import java.io.Serializable;
import java.util.Date;

public class CourseClassImg implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 225931911757231428L;
	private Integer id;
	private Integer classId;
	private String url;
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
