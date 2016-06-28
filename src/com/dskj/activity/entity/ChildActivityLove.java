package com.dskj.activity.entity;

import java.io.Serializable;
import java.util.Date;

public class ChildActivityLove implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6330696640174800747L;
	
	private Integer id;
	private String userId;
	private Integer activityId;
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
	public Integer getActivityId() {
		return activityId;
	}
	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	

}
