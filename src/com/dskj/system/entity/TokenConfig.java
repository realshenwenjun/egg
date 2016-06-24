package com.dskj.system.entity;

import java.io.Serializable;

public class TokenConfig implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6918945506600851927L;
	private Integer id;
	private String key;
	private Object value;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	
}
