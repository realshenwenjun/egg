package com.dskj.course.entity;

import java.io.Serializable;
import java.util.Date;

public class Course implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3595154267001241803L;
	private Integer id;
	private Integer courseTypeId;
	private String institutionId;
	private String name;
	private String describition;
	private String cover;// 课程图片
	private Date createTime;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCourseTypeId() {
		return courseTypeId;
	}

	public void setCourseTypeId(Integer courseTypeId) {
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Course convert(Course courseSrc) throws Exception {
		if(this.courseTypeId == null)
			this.setCourseTypeId(courseSrc.getCourseTypeId());
		if(this.name == null)
			this.setName(courseSrc.getName());
		if(this.describition == null)
			this.setDescribition(courseSrc.getDescribition());
		if(this.cover == null)
			this.setCover(courseSrc.getCover());
		if(this.createTime == null)
			this.setCreateTime(courseSrc.getCreateTime());
		if(this.institutionId == null)
			this.setInstitutionId(courseSrc.getInstitutionId());
		return this;
	}
}
