package com.dskj.course.entity;

import java.io.Serializable;

public class PlanWeek implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8370974228312195633L;
	private Integer week;
	private String startTime;
	private String EndTime;
	private String address;
	public Integer getWeek() {
		return week;
	}
	public void setWeek(Integer week) {
		this.week = week;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return EndTime;
	}
	public void setEndTime(String endTime) {
		EndTime = endTime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
