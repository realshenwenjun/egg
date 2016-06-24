package com.dskj.course.entity;

import java.io.Serializable;

public class CourserClassTeacherList implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8483888281387039981L;
	private Integer courseId;
	private String courseName;
	private String cover;
	private Integer classId;
	private String className;
	private String userId;
	private String userName;
	private String phone;
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
	public String getUserName() {
		return userName;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	
}
