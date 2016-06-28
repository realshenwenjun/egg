package com.dskj.course.entity;

import java.io.Serializable;

public class ClassSignUser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3582177600582224243L;
	private String userId;
	private String photo;
	private String name;
	private String phone;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
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
	
}
