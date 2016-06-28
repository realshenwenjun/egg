package com.dskj.spread.entity;

import java.io.Serializable;
import java.util.Date;

public class CarouselComment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1720608420856298340L;
	
	private Integer id;
	private Integer carouselId;
	private Integer commentId;
	private Date createTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCarouselId() {
		return carouselId;
	}
	public void setCarouselId(Integer carouselId) {
		this.carouselId = carouselId;
	}
	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}
