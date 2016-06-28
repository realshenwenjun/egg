package com.dskj.util;

import java.io.Serializable;

public class Page implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -254805986581553417L;
	private int pageNo = 0;
	private int pageSize = 10;
	private int totleCount;
	private int pageCount;

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotleCount() {
		return totleCount;
	}

	public void setTotleCount(int totleCount) {
		this.totleCount = totleCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

}
