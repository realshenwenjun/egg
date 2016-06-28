package com.dskj.user.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by chenbo on 2016/4/27.
 */
public class UserFace implements Serializable {
    private static final long serialVersionUID = -8055657475463573744L;

    private String id;
    private Integer levelId;//用户等级
    private Integer type;//0:平台管理员,1:机构管理员,2:教师,3:学生
    private String name;
    private String phone;
    private String photo;
    private String qqOpenId;
    private String sinaOpenId;
    private String weixinOpenId;
    private String address;
    private Integer sex;//1:男,2:女
    private Date birthday;
    private Integer regionId;
    private Date createTime;
    private int visitCount;
    private int fansCount;
    private Integer fansId;
    private String interest;
    private String shortIntroduction;
    private String sign;

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getShortIntroduction() {
        return shortIntroduction;
    }

    public void setShortIntroduction(String shortIntroduction) {
        this.shortIntroduction = shortIntroduction;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getQqOpenId() {
        return qqOpenId;
    }

    public void setQqOpenId(String qqOpenId) {
        this.qqOpenId = qqOpenId;
    }

    public String getSinaOpenId() {
        return sinaOpenId;
    }

    public void setSinaOpenId(String sinaOpenId) {
        this.sinaOpenId = sinaOpenId;
    }

    public String getWeixinOpenId() {
        return weixinOpenId;
    }

    public void setWeixinOpenId(String weixinOpenId) {
        this.weixinOpenId = weixinOpenId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }

    public int getFansCount() {
        return fansCount;
    }

    public void setFansCount(int fansCount) {
        this.fansCount = fansCount;
    }

    public Integer getFansId() {
        return fansId;
    }

    public void setFansId(Integer fansId) {
        this.fansId = fansId;
    }

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
    
    
}
