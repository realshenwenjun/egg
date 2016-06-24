package com.dskj.course.entity;

import java.io.Serializable;
import java.util.Date;

public class PlanSign implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8703174797496558637L;
	private Integer id;
	private String institutionId;
	private Integer classId;
	private Integer classPlanId;
	private String userId;
	private String address;
	private Date createTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	public Integer getClassPlanId() {
		return classPlanId;
	}
	public void setClassPlanId(Integer classPlanId) {
		this.classPlanId = classPlanId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getInstitutionId() {
		return institutionId;
	}
	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
	}
	
}
