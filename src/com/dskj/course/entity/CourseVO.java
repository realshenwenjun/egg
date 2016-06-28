package com.dskj.course.entity;

import java.io.Serializable;
import java.util.Date;

public class CourseVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3595154267001241803L;
	private int id;
	private int courseTypeId;
	private String institutionId;
	private String institutionName;
	private String name;
	private String describition;
	private String cover;//课程图片
	private Date createTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescribition() {
		return describition;
	}
	public void setDescribition(String describition) {
		this.describition = describition;
	}
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}
