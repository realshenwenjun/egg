package com.dskj.comment.entity;

import java.io.Serializable;
import java.util.Date;

public class CommentImage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5015372305047673036L;
	
	private Integer id;
	private Integer commentId;
	private String imgPath;
	private Date createTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	

}
