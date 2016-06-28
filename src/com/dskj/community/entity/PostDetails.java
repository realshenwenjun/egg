package com.dskj.community.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author liuyang
 * @date 创建时间：2016年4月15日 下午9:37:22
 * @version 2.0
 * @parameter
 * @since
 * @return 帖子详情信息
 */
public class PostDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1891417251710704395L;
	private Integer id;            //主键id
    private String userId;        //用户id
	private String userLevelId;
	private String userName;
	private String userPhoto;
	private Integer sex;
    private Integer circleId;    //圈子id
    private String context;        //帖子内容
    private Integer type;        //帖子类型(1:公开,2:朋友可见,3:自己可见)
    private Integer topicId;    //话题id
    private Date createTime;    //创建时间
    private int loveCount;
    private int collectCount;
    private int commentCount;
    private Integer loveId;
    private Integer collectId;
    private List<String> imgUrls;
    private List<String> voideUrls;
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
	public int getLoveCount() {
		return loveCount;
	}
	public void setLoveCount(int loveCount) {
		this.loveCount = loveCount;
	}
	public int getCollectCount() {
		return collectCount;
	}
	public void setCollectCount(int collectCount) {
		this.collectCount = collectCount;
	}
	public int getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	public Integer getLoveId() {
		return loveId;
	}
	public void setLoveId(Integer loveId) {
		this.loveId = loveId;
	}
	public Integer getCollectId() {
		return collectId;
	}
	public void setCollectId(Integer collectId) {
		this.collectId = collectId;
	}
	public List<String> getImgUrls() {
		return imgUrls;
	}
	public void setImgUrls(List<String> imgUrls) {
		this.imgUrls = imgUrls;
	}
	public List<String> getVoideUrls() {
		return voideUrls;
	}
	public void setVoideUrls(List<String> voideUrls) {
		this.voideUrls = voideUrls;
	}

	public String getUserLevelId() {
		return userLevelId;
	}

	public void setUserLevelId(String userLevelId) {
		this.userLevelId = userLevelId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}
}
