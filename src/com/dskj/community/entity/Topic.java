package com.dskj.community.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liuyang
 * @version 2.0
 * @date 创建时间：2016年4月5日 下午9:54:07
 * @parameter
 * @return 话题
 */
public class Topic implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 7829098693879981997L;


    private Integer id;                //主键id
    private String userId;        //用户id
    private String title;        //话题标题
    private String context;        //话题内容
    private Integer type;        //话题类型(1:公开,2:朋友可见,3:自己可见)
    private String imgUrl;     //图片url
    private Date createTime;    //创建时间

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Topic [id=" + id + ", userId=" + userId + ", title=" + title
                + ", context=" + context + ", type=" + type + ", imgUrl="
                + imgUrl + ", createTime=" + createTime + "]";
    }


}
