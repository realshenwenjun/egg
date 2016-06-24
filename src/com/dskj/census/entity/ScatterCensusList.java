package com.dskj.census.entity;

import java.io.Serializable;

public class ScatterCensusList implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -678798378085647458L;
	private Integer areaId;
	private String area;
	private int count;
	private double percent;
	
	public Integer getAreaId() {
		return areaId;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public double getPercent() {
		return percent;
	}
	public void setPercent(double percent) {
		this.percent = percent;
	}
}
