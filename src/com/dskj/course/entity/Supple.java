package com.dskj.course.entity;

import java.io.Serializable;
import java.util.Date;

public class Supple implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6683578342682402150L;
	
	private Integer id;
	private Integer classId;
	private Integer planId;
	private String userId;
	private Integer suppleClassId;
	private Integer supplePlanId;
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
	public Integer getPlanId() {
		return planId;
	}
	public void setPlanId(Integer planId) {
		this.planId = planId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getSuppleClassId() {
		return suppleClassId;
	}
	public void setSuppleClassId(Integer suppleClassId) {
		this.suppleClassId = suppleClassId;
	}
	public Integer getSupplePlanId() {
		return supplePlanId;
	}
	public void setSupplePlanId(Integer supplePlanId) {
		this.supplePlanId = supplePlanId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	

}
