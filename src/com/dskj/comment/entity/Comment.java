package com.dskj.comment.entity;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5937738927396272132L;
	
	private Integer id;
	private String userId;
	private String context;
	private boolean isPublic = true;
	private boolean isOriginal = true;
	private Integer parentId;
	private Date createTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContext() {
		return context;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public boolean isIsPublic() {
		return isPublic;
	}

	public void setIsPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	public boolean isIsOriginal() {
		return isOriginal;
	}

	public void setIsOriginal(boolean isOriginal) {
		this.isOriginal = isOriginal;
	}

}
