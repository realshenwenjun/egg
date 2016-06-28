package com.dskj.course.entity;

import java.io.Serializable;
import java.util.Date;

public class CourseType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9015125873762876230L;
	private Integer id;
	private String name;
	private String cover;
	private Integer ofId;
	private Date createTime;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOfId() {
		return ofId;
	}
	public void setOfId(Integer ofId) {
		this.ofId = ofId;
	}
	
}
