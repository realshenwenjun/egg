package com.dskj.census.entity;

import java.io.Serializable;

public class SignCensusUserSignList implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8809104243690096140L;
	private String userId;
	private String name;
	private String phone;
	private String photo;
	private int planSignCount;
	private int planCount;
	private int lackCount;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getPlanSignCount() {
		return planSignCount;
	}
	public void setPlanSignCount(int planSignCount) {
		this.planSignCount = planSignCount;
	}
	public int getPlanCount() {
		return planCount;
	}
	public void setPlanCount(int planCount) {
		this.planCount = planCount;
	}
	public int getLackCount() {
		return lackCount;
	}
	public void setLackCount(int lackCount) {
		this.lackCount = lackCount;
	}
	
}
