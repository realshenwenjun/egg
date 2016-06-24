package com.dskj.course.entity;

import java.io.Serializable;
import java.util.Date;

public class UserPlanListByDay implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6662136707158418810L;
	private Integer classId;
	private String className;
	private String userName;
	private String phone;
	private Date planDate;
	private String planStart;
	private String planEnd;
	private String address;
	private Integer planSignId;
	private Integer lackId;
	private Integer cancelId;
	private long serverTimestamp = System.currentTimeMillis();
	public Date getPlanDate() {
		return planDate;
	}
	public void setPlanDate(Date planDate) {
		this.planDate = planDate;
	}
	public Integer getPlanSignId() {
		return planSignId;
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
	public void setPlanSignId(Integer planSignId) {
		this.planSignId = planSignId;
	}
	public Integer getLackId() {
		return lackId;
	}
	public void setLackId(Integer lackId) {
		this.lackId = lackId;
	}
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getCancelId() {
		return cancelId;
	}
	public void setCancelId(Integer cancelId) {
		this.cancelId = cancelId;
	}
	public long getServerTimestamp() {
		return serverTimestamp;
	}
	public void setServerTimestamp(long serverTimestamp) {
		this.serverTimestamp = serverTimestamp;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
