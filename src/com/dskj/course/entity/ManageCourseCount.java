package com.dskj.course.entity;

import java.io.Serializable;

public class ManageCourseCount implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1531729300202611175L;
	private int courseId;
	private String courseName;
	private String cover;
	private int classCount;
	public int getCourseId() {
		return courseId;
	}
	
	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getClassCount() {
		return classCount;
	}
	public void setClassCount(int classCount) {
		this.classCount = classCount;
	}
	
}
