package com.dskj.system.entity;

import java.io.Serializable;

public class Token implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7566811240947024992L;
	private String token;
	private Long expires_in;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Long getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(Long expires_in) {
		this.expires_in = expires_in;
	}
	
	
}
