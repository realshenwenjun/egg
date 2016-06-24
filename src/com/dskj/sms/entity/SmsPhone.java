package com.dskj.sms.entity;

import java.io.Serializable;

public class SmsPhone implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8192164950493215974L;
	private String phone;
	private String templeteId;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTempleteId() {
		return templeteId;
	}

	public void setTempleteId(String templeteId) {
		this.templeteId = templeteId;
	}

}
