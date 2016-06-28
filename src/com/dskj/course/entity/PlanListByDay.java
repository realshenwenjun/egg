package com.dskj.course.entity;

import java.io.Serializable;
import java.util.Date;

public class PlanListByDay implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2637494138428551860L;
	private String userId;
	private String userName;
	private String courseName;
	private String cover;
	private Integer classId;
	private Integer planId;
	private Date planDate;
	private String planStart;
	private String planEnd;
	private Integer planSignId;
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
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	public Integer getPlanId() {
		return planId;
	}
	public void setPlanId(Integer planId) {
		this.planId = planId;
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
	public Integer getPlanSignId() {
		return planSignId;
	}
	public void setPlanSignId(Integer planSignId) {
		this.planSignId = planSignId;
	}
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
	
}
