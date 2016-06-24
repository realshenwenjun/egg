package com.dskj.course.entity;

import java.io.Serializable;
import java.util.Date;

public class SuppleDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6881704126488599806L;
	private String studentName;
	private String courseName;
	private String teacherName;
	private String teacherPhoto;
	private Date planDate;
	private String planStart;
	private String planEnd;
	private String address;
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getTeacherPhoto() {
		return teacherPhoto;
	}
	public void setTeacherPhoto(String teacherPhoto) {
		this.teacherPhoto = teacherPhoto;
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
	
}
