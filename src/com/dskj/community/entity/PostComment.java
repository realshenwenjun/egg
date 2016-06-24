package com.dskj.community.entity;

import java.io.Serializable;
import java.util.Date;

public class PostComment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7674172216442871982L;
	private Integer id;
	private Integer postId;
	private Integer commentId;
	private Date createTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
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
