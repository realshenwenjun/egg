package com.dskj.spread.entity;

import java.io.Serializable;
import java.util.Date;

public class CarouselLove implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7565148740863313518L;
	private Integer id;
	private String userId;
	private Integer carouselId;
	private Date createTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getCarouselId() {
		return carouselId;
	}
	public void setCarouselId(Integer carouselId) {
		this.carouselId = carouselId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
