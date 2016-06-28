package com.dskj.course.entity;

import java.io.Serializable;

public class ManageClassTeacherList implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -920187692621088930L;
	private Integer courseId;
	private String courseName;
	private String cover;
	private Integer classId;
	private String className;
	private Integer userId;
	private String userName;
	public Integer getCourseId() {
		return courseId;
	}
	
	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
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
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
