package com.dskj.course.entity;

import java.io.Serializable;
import java.util.Date;

public class PlanByClass implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8131407088026934129L;
	private Integer id;
	private Date date;
	private String startTime;
	private String endTime;
	private String address;
	private Integer lackId;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getLackId() {
		return lackId;
	}
	public void setLackId(Integer lackId) {
		this.lackId = lackId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}
