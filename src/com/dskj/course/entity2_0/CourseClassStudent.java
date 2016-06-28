package com.dskj.course.entity2_0;

import java.io.Serializable;

public class CourseClassStudent implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3400476762959338031L;
	private String id;
	private String name;
	private String photo;
	private String phone;
	private Integer sex;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	
	
}
