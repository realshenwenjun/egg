package com.dskj.census.entity;

import java.io.Serializable;

public class TimingCensusUserSignList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5697062309413642808L;
	private String userId;
	private String name;
	private String phone;
	private String photo;
	private int signCount;

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

	public int getSignCount() {
		return signCount;
	}

	public void setSignCount(int signCount) {
		this.signCount = signCount;
	}

}
