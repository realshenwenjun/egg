package com.dskj.census.entity;

import java.io.Serializable;
import java.util.Date;

import com.dskj.util.DateUtil;

public class DailyLiveCensusDateList implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7010417885224510033L;
	private String date;
	private int count;
	public String getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = DateUtil.formatDate(date, DateUtil.normalDateFormat);
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
