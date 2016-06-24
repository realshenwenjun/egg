package com.dskj.course.entity;

import java.io.Serializable;

public class ManageUserCourseClassSignPlan implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2002259665966841809L;
	private Integer courseId;
	private String courseName;
	private String cover;
	private Integer classId;
	private String className;
	private String userName;
	private int planSignCount;
	private int planCount;
	public String getCourseName() {
		return courseName;
	}
	
	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Integer getClassId() {
		return classId;
	}
	
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
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
	
}
