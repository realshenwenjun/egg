package com.dskj.user.entity2_0;

import java.io.Serializable;
import java.util.Date;

public class UserGroup implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4974130603770067789L;
	private Integer id;
	private String uid;
	private String url;
	private Date createTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	

}
