package com.dskj.course.entity;

import java.io.Serializable;
import java.util.Date;

public class UserGatherCourseClassPlan implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6483399019069688884L;
	private String institutionId;
	private String institutionName;
	private Integer courseId;
	private String courseName;
	private String userName;
	private String courseCover;
	private Integer classId;
	private String className;
	private Date date;
	private int times;
	private int userCount;
	public String getInstitutionId() {
		return institutionId;
	}
	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
	}
	public String getInstitutionName() {
		return institutionName;
	}
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}
	public String getCourseCover() {
		return courseCover;
	}
	public void setCourseCover(String courseCover) {
		this.courseCover = courseCover;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
	}
	public int getUserCount() {
		return userCount;
	}
	public void setUserCount(int userCount) {
		this.userCount = userCount;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
