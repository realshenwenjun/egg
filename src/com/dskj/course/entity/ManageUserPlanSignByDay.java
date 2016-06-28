package com.dskj.course.entity;

import java.io.Serializable;
import java.util.Date;

public class ManageUserPlanSignByDay implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6424485650068050641L;
	private Integer courseId;
	private String courseName;
	private String cover;
	private Integer classId;
	private String className;
	private Integer planId;
	private Date planDate;
	private String planStart;
	private String planEnd;
	private String planAddress;
	private String userName;
	private int planSignCount;
	private int userCount;
	private Integer lackId;
	
	
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public Integer getLackId() {
		return lackId;
	}
	public void setLackId(Integer lackId) {
		this.lackId = lackId;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
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
	public String getPlanAddress() {
		return planAddress;
	}
	public void setPlanAddress(String planAddress) {
		this.planAddress = planAddress;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getPlanSignCount() {
		return planSignCount;
	}
	public void setPlanSignCount(int planSignCount) {
		this.planSignCount = planSignCount;
	}
	public int getUserCount() {
		return userCount;
	}
	public void setUserCount(int userCount) {
		this.userCount = userCount;
	}
	
	
}
