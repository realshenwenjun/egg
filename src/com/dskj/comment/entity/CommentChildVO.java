package com.dskj.comment.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by chenbo on 2016/4/10.
 */
public class CommentChildVO implements Serializable {
    private static final long serialVersionUID = -2923830345377689436L;
    private Integer id;
    private String sendUserId;
    private String senderName;
    private String receiveName;
    private String context;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public String getSendUserId() {
		return sendUserId;
	}

	public void setSendUserId(String sendUserId) {
		this.sendUserId = sendUserId;
	}
    
}
