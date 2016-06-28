package com.dskj.course.entity2_0;

import java.io.Serializable;
import java.util.Date;

public class ClassComment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1930817316554204687L;
	private Integer id;
	private Integer classId;
	private Integer commentId;
	private Date createTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
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
