package com.dskj.comment.entity;

import java.io.Serializable;
import java.util.Date;

public class CommentVoide implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7837685369799713026L;
	
	private Integer id;
	private Integer commentId;
	private String voidePath;
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
	public String getVoidePath() {
		return voidePath;
	}
	public void setVoidePath(String voidePath) {
		this.voidePath = voidePath;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}
