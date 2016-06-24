package com.dskj.course.entity;

import java.io.Serializable;

public class ManageCensusPlanSignByDay implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5880902693166447412L;
	private int signPlanCount = 0;
	private int planCount = 0;
	private int signCount = 0;
	private int userCount = 0;
	public int getSignPlanCount() {
		return signPlanCount;
	}
	public void setSignPlanCount(int signPlanCount) {
		this.signPlanCount = signPlanCount;
	}
	public int getPlanCount() {
		return planCount;
	}
	public void setPlanCount(int planCount) {
		this.planCount = planCount;
	}
	public int getSignCount() {
		return signCount;
	}
	public void setSignCount(int signCount) {
		this.signCount = signCount;
	}
	public int getUserCount() {
		return userCount;
	}
	public void setUserCount(int userCount) {
		this.userCount = userCount;
	}
	
}
