package com.dskj.course.entity;

import java.io.Serializable;
import java.util.Date;

public class ClassPlanLackList implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2630884469894364862L;
	private Integer classId;
	private Integer planId;
	private Date planDate;
	private String planStart;
	private String planEnd;
	private String address;
	private Integer lackId;
	private Integer cancelId;
	private Integer suppleId;
	
	
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getSuppleId() {
		return suppleId;
	}
	public void setSuppleId(Integer suppleId) {
		this.suppleId = suppleId;
	}
	public Integer getCancelId() {
		return cancelId;
	}
	public void setCancelId(Integer cancelId) {
		this.cancelId = cancelId;
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
	public Date getPlanDate() {
		return planDate;
	}
	public void setPlanDate(Date planDate) {
		this.planDate = planDate;
	}
	public String getPlanStart() {
		return planStart;
	}
	public void setPlanStart(String planStart) {
		this.planStart = planStart;
	}
	public String getPlanEnd() {
		return planEnd;
	}
	public void setPlanEnd(String planEnd) {
		this.planEnd = planEnd;
	}
	public Integer getLackId() {
		return lackId;
	}
	public void setLackId(Integer lackId) {
		this.lackId = lackId;
	}
	
}
