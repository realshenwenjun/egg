package com.dskj.course.entity;

import java.io.Serializable;
import java.util.Date;

public class MoreCourseList implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2339075967738302784L;
	private String cover;
	private String institutionName;
	private Integer courseId;
	private String courseName;
	private Integer classId;
	private String className;
	private String userName;
	private String phone;
	private Date minDate;
	private Date maxDate;
	
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public String getInstitutionName() {
		return institutionName;
	}
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getMinDate() {
		return minDate;
	}
	public void setMinDate(Date minDate) {
		this.minDate = minDate;
	}
	public Date getMaxDate() {
		return maxDate;
	}
	public void setMaxDate(Date maxDate) {
		this.maxDate = maxDate;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
