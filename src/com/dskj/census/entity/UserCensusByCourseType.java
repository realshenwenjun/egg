package com.dskj.census.entity;

import java.io.Serializable;

public class UserCensusByCourseType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7158354368778875714L;
	private String courseTypeName;
	private int userCount;
	public String getCourseTypeName() {
		return courseTypeName;
	}
	public void setCourseTypeName(String courseTypeName) {
		this.courseTypeName = courseTypeName;
	}
	public int getUserCount() {
		return userCount;
	}
	public void setUserCount(int userCount) {
		this.userCount = userCount;
	}
	
}
