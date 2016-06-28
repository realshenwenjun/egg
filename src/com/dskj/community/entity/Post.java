package com.dskj.community.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liuyang
 * @version 2.0
 * @date 创建时间：2016年4月5日 下午9:54:07
 * @parameter
 * @return 帖子
 */
public class Post implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 2330169645657106808L;

    private Integer id;            //主键id
    private String userId;        //用户id
    private Integer circleId;    //圈子id
    private String context;        //帖子内容
    private Integer type;        //帖子类型(1:公开,2:朋友可见,3:自己可见)
    private Integer topicId;    //话题id
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

    public Integer getCircleId() {
        return circleId;
    }

    public void setCircleId(Integer circleId) {
        this.circleId = circleId;
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

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
