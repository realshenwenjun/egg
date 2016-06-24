package com.dskj.course.entity;

import java.io.Serializable;

public class ManageCourseClassCount implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3205868610331229752L;
	private int courseTypeId;
	private String courseTypeCover;
	private String institutionId;
	private String courseTypeName;
	private int courseCount;
	private int classCount;
	public int getCourseTypeId() {
		return courseTypeId;
	}
	public void setCourseTypeId(int courseTypeId) {
		this.courseTypeId = courseTypeId;
	}
	public String getInstitutionId() {
		return institutionId;
	}
	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
	}
	public String getCourseTypeName() {
		return courseTypeName;
	}
	public void setCourseTypeName(String courseTypeName) {
		this.courseTypeName = courseTypeName;
	}
	public int getCourseCount() {
		return courseCount;
	}
	public void setCourseCount(int courseCount) {
		this.courseCount = courseCount;
	}
	public int getClassCount() {
		return classCount;
	}
	public void setClassCount(int classCount) {
		this.classCount = classCount;
	}
	public String getCourseTypeCover() {
		return courseTypeCover;
	}
	public void setCourseTypeCover(String courseTypeCover) {
		this.courseTypeCover = courseTypeCover;
	}
	
}
