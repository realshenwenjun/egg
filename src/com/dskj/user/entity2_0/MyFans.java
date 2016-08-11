package com.dskj.user.entity2_0;

import java.io.Serializable;

public class MyFans implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6264506723078055600L;
	private Integer fansId;
	private String userId;
	private String institutionId;
	private String name;
	private String photo;
	private Integer type;


	public Integer getFansId() {
		return fansId;
	}

	public void setFansId(Integer fansId) {
		this.fansId = fansId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getInstitutionId() {
		return institutionId;
	}

	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
	}
}
