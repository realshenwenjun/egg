package com.dskj.course.entity;

import java.io.Serializable;

public class ManageUserListByPlan implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3166165269827366896L;
	private String userId;
	private String userName;
	private String userPhone;
	private String userPhoto;
	private Integer planSignId;
	private Integer lackId;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserPhoto() {
		return userPhoto;
	}
	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}
	public Integer getPlanSignId() {
		return planSignId;
	}
	public void setPlanSignId(Integer planSignId) {
		this.planSignId = planSignId;
	}
	public Integer getLackId() {
		return lackId;
	}
	public void setLackId(Integer lackId) {
		this.lackId = lackId;
	}
}
