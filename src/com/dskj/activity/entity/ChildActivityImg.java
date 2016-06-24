package com.dskj.activity.entity;

import java.io.Serializable;
import java.util.Date;

public class ChildActivityImg implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3640478167960226913L;
	
	private Integer id;
	private Integer activityId;
	private String url;
	private Date createTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Integer getActivityId() {
		return activityId;
	}
	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}
	
	

}
