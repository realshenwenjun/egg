package com.dskj.oss.entity;

import java.io.Serializable;

public class OssConfig implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3353092771211672513L;
	private String key;
	private String value;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	

}
