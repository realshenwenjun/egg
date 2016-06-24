package com.dskj.course.entity2_0;

import java.io.Serializable;

public class CourseClassType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2753078795104373818L;
	private Integer id;
	private String name;
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
	
}
