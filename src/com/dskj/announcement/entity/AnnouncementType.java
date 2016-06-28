package com.dskj.announcement.entity;

import java.io.Serializable;
import java.util.Date;

public class AnnouncementType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2780181922619924629L;
	private Integer id;
	private String name;
	private Date createTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
