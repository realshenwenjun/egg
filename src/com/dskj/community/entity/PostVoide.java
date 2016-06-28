package com.dskj.community.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liuyang
 * @version 2.0
 * @date 创建时间：2016年4月5日 下午10:00:23
 * @parameter
 * @return
 */
public class PostVoide implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -2118949281900376203L;
	private Integer id;            //主键id
    private Integer postId;        //帖子id
    private String url;        //帖子视频url
    private Date createTime;//创建时间

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
