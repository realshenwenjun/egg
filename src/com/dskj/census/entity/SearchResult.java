package com.dskj.census.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SearchResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7771193683513319400L;
	
	private Integer type;//1: 机构，2:课程 ，3：帖子，4：活动,5:好友
	
	
	private String institutionId;
	private String institutionName;
	private String institutionLogo;
	private String institutionCourseType;
	private int institutionCommentCount;
	private String institutionAddress;
	
	private Integer classId;
	private String classCover;
	private String className;
	private Integer classPlanCount;
	private Integer classStudentCount;
	private Date classStartDate;
	private Date classEndDate;
	private String classStartTime;
	private String classEndTime;
	private String classTeacherName;
	private Double classPrice;

	private Integer activityId;
	private String activityAdverImg;
	private String activityTitle;
	private Double activityOldPrice;
	private Double activityPrice;
	private Integer activitySaleCount;
	private String activityUrl;

	private Integer postId;
	private String postUserPhoto;
	private Integer postUserSex;
	private Date postCreateTime;
	private String postContext;
    private String postUserName;
    private List<String> postImgUrls;
    private int postLoveCount;
    private int postCollectCount;
    private int postCommentCount;
    private Integer postLoveId;
    private Integer postCollectId;
    
    private String friendId;
    private String friendPhoto;
    private String friendName;
    private String friendPhone;
    private Integer friendSex;
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getInstitutionId() {
		return institutionId;
	}
	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
	}
	public String getInstitutionName() {
		return institutionName;
	}
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}
	public String getInstitutionLogo() {
		return institutionLogo;
	}
	public void setInstitutionLogo(String institutionLogo) {
		this.institutionLogo = institutionLogo;
	}
	public String getInstitutionCourseType() {
		return institutionCourseType;
	}
	public void setInstitutionCourseType(String institutionCourseType) {
		this.institutionCourseType = institutionCourseType;
	}
	public int getInstitutionCommentCount() {
		return institutionCommentCount;
	}
	public void setInstitutionCommentCount(int institutionCommentCount) {
		this.institutionCommentCount = institutionCommentCount;
	}
	public String getInstitutionAddress() {
		return institutionAddress;
	}
	public void setInstitutionAddress(String institutionAddress) {
		this.institutionAddress = institutionAddress;
	}
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	public String getClassCover() {
		return classCover;
	}
	public void setClassCover(String classCover) {
		this.classCover = classCover;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Integer getClassPlanCount() {
		return classPlanCount;
	}
	public void setClassPlanCount(Integer classPlanCount) {
		this.classPlanCount = classPlanCount;
	}
	public Integer getClassStudentCount() {
		return classStudentCount;
	}
	public void setClassStudentCount(Integer classStudentCount) {
		this.classStudentCount = classStudentCount;
	}
	public Date getClassStartDate() {
		return classStartDate;
	}
	public void setClassStartDate(Date classStartDate) {
		this.classStartDate = classStartDate;
	}
	public Date getClassEndDate() {
		return classEndDate;
	}
	public void setClassEndDate(Date classEndDate) {
		this.classEndDate = classEndDate;
	}
	public String getClassStartTime() {
		return classStartTime;
	}
	public void setClassStartTime(String classStartTime) {
		this.classStartTime = classStartTime;
	}
	public String getClassEndTime() {
		return classEndTime;
	}
	public void setClassEndTime(String classEndTime) {
		this.classEndTime = classEndTime;
	}
	public String getClassTeacherName() {
		return classTeacherName;
	}
	public void setClassTeacherName(String classTeacherName) {
		this.classTeacherName = classTeacherName;
	}
	public Double getClassPrice() {
		return classPrice;
	}
	public void setClassPrice(Double classPrice) {
		this.classPrice = classPrice;
	}
	public Integer getActivityId() {
		return activityId;
	}
	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}
	public String getActivityAdverImg() {
		return activityAdverImg;
	}
	public void setActivityAdverImg(String activityAdverImg) {
		this.activityAdverImg = activityAdverImg;
	}
	public String getActivityTitle() {
		return activityTitle;
	}
	public void setActivityTitle(String activityTitle) {
		this.activityTitle = activityTitle;
	}
	public Double getActivityOldPrice() {
		return activityOldPrice;
	}
	public void setActivityOldPrice(Double activityOldPrice) {
		this.activityOldPrice = activityOldPrice;
	}
	public Double getActivityPrice() {
		return activityPrice;
	}
	public void setActivityPrice(Double activityPrice) {
		this.activityPrice = activityPrice;
	}
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public String getPostContext() {
		return postContext;
	}
	public void setPostContext(String postContext) {
		this.postContext = postContext;
	}
	public String getPostUserName() {
		return postUserName;
	}
	public void setPostUserName(String postUserName) {
		this.postUserName = postUserName;
	}
	public List<String> getPostImgUrls() {
		return postImgUrls;
	}
	public void setPostImgUrls(List<String> postImgUrls) {
		this.postImgUrls = postImgUrls;
	}
	public String getFriendId() {
		return friendId;
	}
	public void setFriendId(String friendId) {
		this.friendId = friendId;
	}
	public String getFriendPhoto() {
		return friendPhoto;
	}
	public void setFriendPhoto(String friendPhoto) {
		this.friendPhoto = friendPhoto;
	}
	public String getFriendName() {
		return friendName;
	}
	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}
	public String getFriendPhone() {
		return friendPhone;
	}
	public void setFriendPhone(String friendPhone) {
		this.friendPhone = friendPhone;
	}
	public Integer getFriendSex() {
		return friendSex;
	}
	public void setFriendSex(Integer friendSex) {
		this.friendSex = friendSex;
	}
	public Integer getActivitySaleCount() {
		return activitySaleCount;
	}
	public void setActivitySaleCount(Integer activitySaleCount) {
		this.activitySaleCount = activitySaleCount;
	}
	public int getPostLoveCount() {
		return postLoveCount;
	}
	public void setPostLoveCount(int postLoveCount) {
		this.postLoveCount = postLoveCount;
	}
	public int getPostCollectCount() {
		return postCollectCount;
	}
	public void setPostCollectCount(int postCollectCount) {
		this.postCollectCount = postCollectCount;
	}
	public int getPostCommentCount() {
		return postCommentCount;
	}
	public void setPostCommentCount(int postCommentCount) {
		this.postCommentCount = postCommentCount;
	}
	public String getPostUserPhoto() {
		return postUserPhoto;
	}
	public void setPostUserPhoto(String postUserPhoto) {
		this.postUserPhoto = postUserPhoto;
	}
	public Integer getPostUserSex() {
		return postUserSex;
	}
	public void setPostUserSex(Integer postUserSex) {
		this.postUserSex = postUserSex;
	}
	public Date getPostCreateTime() {
		return postCreateTime;
	}
	public void setPostCreateTime(Date postCreateTime) {
		this.postCreateTime = postCreateTime;
	}
	public Integer getPostLoveId() {
		return postLoveId;
	}
	public void setPostLoveId(Integer postLoveId) {
		this.postLoveId = postLoveId;
	}
	public Integer getPostCollectId() {
		return postCollectId;
	}
	public void setPostCollectId(Integer postCollectId) {
		this.postCollectId = postCollectId;
	}

	public String getActivityUrl() {
		return activityUrl;
	}

	public void setActivityUrl(String activityUrl) {
		this.activityUrl = activityUrl;
	}
}
