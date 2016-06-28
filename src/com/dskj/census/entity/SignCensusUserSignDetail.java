package com.dskj.census.entity;

import java.io.Serializable;
import java.util.Date;

public class SignCensusUserSignDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -682769816779589835L;
	private String courseName;
	private String cover;
	private String className;
	private String userName;
	private String phone;
	private String photo;
	private Date planDate;
	private String planStart;
	private String planEnd;
	private String address;
	private Integer planSignId;
	private Integer lackId;
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public Date getPlanDate() {
		return planDate;
	}
	public void setPlanDate(Date planDate) {
		this.planDate = planDate;
	}
	public String getPlanStart() {
		return planStart;
	}
	public void setPlanStart(String planStart) {
		this.planStart = planStart;
	}
	public String getPlanEnd() {
		return planEnd;
	}
	public void setPlanEnd(String planEnd) {
		this.planEnd = planEnd;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
