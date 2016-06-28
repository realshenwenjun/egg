package com.dskj.comment.entity;

import java.io.Serializable;
import java.util.Date;

public class CommentLove implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6423282610234511562L;
	private Integer id;
	private String userId;
	private Integer commentId;
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
