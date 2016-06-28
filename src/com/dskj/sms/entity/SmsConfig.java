package com.dskj.sms.entity;

import java.io.Serializable;
import java.util.Date;

public class SmsConfig implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5941393002909661566L;
	private Integer id;
	private String key;
	private String value;
	private Date createTime;

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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
