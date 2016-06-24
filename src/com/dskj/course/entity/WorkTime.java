package com.dskj.course.entity;

import java.io.Serializable;
import java.util.Date;

public class WorkTime implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -474910368400469447L;
	private Integer id;
	private String institutionId;
	private Date workDate;
	private String workStart;
	private String workEnd;
	private Boolean free;
	private Date createTime = new Date();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getInstitutionId() {
		return institutionId;
	}
	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
	}
	public Date getWorkDate() {
		return workDate;
	}
	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}
	public String getWorkStart() {
		return workStart;
	}
	public void setWorkStart(String workStart) {
		this.workStart = workStart;
	}
	public String getWorkEnd() {
		return workEnd;
	}
	public void setWorkEnd(String workEnd) {
		this.workEnd = workEnd;
	}
	public Boolean getFree() {
		return free;
	}
	public void setFree(Boolean free) {
		this.free = free;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
