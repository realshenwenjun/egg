package com.dskj.course.entity2_0;

import java.io.Serializable;
import java.util.List;

public class CourseClassTypeOf implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2753078795104373818L;
	private Integer id;
	private String name;
	private List<CourseClassType> courses;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<CourseClassType> getCourses() {
		return courses;
	}
	public void setCourses(List<CourseClassType> courses) {
		this.courses = courses;
	}
	
	
}
