package com.frame.elastic.core;

import java.io.Serializable;

public class Shards implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5556588977981739973L;
	private int total;
	private int successful;
	private int failed;
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getSuccessful() {
		return successful;
	}
	public void setSuccessful(int successful) {
		this.successful = successful;
	}
	public int getFailed() {
		return failed;
	}
	public void setFailed(int failed) {
		this.failed = failed;
	}
	
}
