package com.dskj.user.entity2_0;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class MyCollect implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4811475600668632217L;
	private Integer collectId;
	private Integer type;
	private Date createTime;

	private Integer classId;
	private String logo;
	private String name;
	private int planCount;
	private int studentCount;
	private Date startDate;
	private Date endDate;
	private String startTime;
	private String endTime;
	private String teacherName;
	private Double price;

	private Integer activityId;
	private String adverImg;
	private String title;
	private Double oldPrice;

	private Integer postId;
	private String context;
	private String postUserId;
    private String userName;
    private List<String> imgUrls;

	private Integer infoId;
	private String infoTitle;
	private String infoSummary;
	private List<String> infoImgUrls;

	private String carouselId;
	private String carouselUrl;
	private String carouselVal;
	private String carouselTitle;


	public String getCarouselId() {
		return carouselId;
	}

	public void setCarouselId(String carouselId) {
		this.carouselId = carouselId;
	}

	public String getCarouselUrl() {
		return carouselUrl;
	}

	public void setCarouselUrl(String carouselUrl) {
		this.carouselUrl = carouselUrl;
	}

	public String getCarouselVal() {
		return carouselVal;
	}

	public void setCarouselVal(String carouselVal) {
		this.carouselVal = carouselVal;
	}

	public String getCarouselTitle() {
		return carouselTitle;
	}

	public void setCarouselTitle(String carouselTitle) {
		this.carouselTitle = carouselTitle;
	}

	public Integer getCollectId() {
		return collectId;
	}
	public void setCollectId(Integer collectId) {
		this.collectId = collectId;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPlanCount() {
		return planCount;
	}
	public void setPlanCount(int planCount) {
		this.planCount = planCount;
	}
	public int getStudentCount() {
		return studentCount;
	}
	public void setStudentCount(int studentCount) {
		this.studentCount = studentCount;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getAdverImg() {
		return adverImg;
	}
	public void setAdverImg(String adverImg) {
		this.adverImg = adverImg;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<String> getImgUrls() {
		return imgUrls;
	}
	public void setImgUrls(List<String> imgUrls) {
		this.imgUrls = imgUrls;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public Double getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(Double oldPrice) {
		this.oldPrice = oldPrice;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public Integer getInfoId() {
		return infoId;
	}

	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}

	public String getInfoTitle() {
		return infoTitle;
	}

	public void setInfoTitle(String infoTitle) {
		this.infoTitle = infoTitle;
	}

	public String getInfoSummary() {
		return infoSummary;
	}

	public void setInfoSummary(String infoSummary) {
		this.infoSummary = infoSummary;
	}

	public List<String> getInfoImgUrls() {
		return infoImgUrls;
	}

	public void setInfoImgUrls(List<String> infoImgUrls) {
		this.infoImgUrls = infoImgUrls;
	}

	public String getPostUserId() {
		return postUserId;
	}

	public void setPostUserId(String postUserId) {
		this.postUserId = postUserId;
	}
}
