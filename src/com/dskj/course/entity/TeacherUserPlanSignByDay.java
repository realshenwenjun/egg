package com.dskj.course.entity;

import java.io.Serializable;
import java.util.Date;

public class TeacherUserPlanSignByDay implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9114270849298066582L;
	private Integer planId;
	private Integer classId;
	private Date planDate;
	private String planStart;
	private String planEnd;
	private String address;
	private int signCount;
	private int userCount;
	private Integer lackId;
	public Integer getPlanId() {
		return planId;
	}
	public void setPlanId(Integer planId) {
		this.planId = planId;
	}
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
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
	public int getSignCount() {
		return signCount;
	}
	public void setSignCount(int signCount) {
		this.signCount = signCount;
	}
	public int getUserCount() {
		return userCount;
	}
	public void setUserCount(int userCount) {
		this.userCount = userCount;
	}
	public Integer getLackId() {
		return lackId;
	}
	public void setLackId(Integer lackId) {
		this.lackId = lackId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
