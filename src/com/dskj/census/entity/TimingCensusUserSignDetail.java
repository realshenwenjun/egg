package com.dskj.census.entity;

import java.io.Serializable;
import java.util.Date;

public class TimingCensusUserSignDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2131316273530730158L;
	private Date createTime;
	private String address;
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
	
}
