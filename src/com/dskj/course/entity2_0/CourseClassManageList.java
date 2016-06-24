package com.dskj.course.entity2_0;

import java.io.Serializable;

public class CourseClassManageList implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7014162537004711628L;
	private Integer id;
	private String cover;
	private String name;
	private int planCount;
	private int studentCount;
	private String institutionName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPlanCount() {
		return planCount;
	}
	public void setPlanCount(int planCount) {
		this.planCount = planCount;
	}
	public int getStudentCount() {
		return studentCount;
	}
	public void setStudentCount(int studentCount) {
		this.studentCount = studentCount;
	}
	public String getInstitutionName() {
		return institutionName;
	}
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}
	
	

}
