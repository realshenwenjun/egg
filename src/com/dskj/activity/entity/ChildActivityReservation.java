package com.dskj.activity.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ChildActivityReservation {
    private Integer id;

    private String orderNumber;

    private Integer childActivityId;

    private String userId;

    private String realname;

    private String phone;

    private Integer reserveCount;

    private BigDecimal price;

    private Integer state;  // 0 : 失效   1 ： 有效

    private Integer cancelCode; //取消原因编号

    private String cancelRemark; //取消原因-用户自定义

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChildActivityId() {
        return childActivityId;
    }

    public void setChildActivityId(Integer childActivityId) {
        this.childActivityId = childActivityId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getReserveCount() {
        return reserveCount;
    }

    public void setReserveCount(Integer reserveCount) {
        this.reserveCount = reserveCount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getCancelCode() {
        return cancelCode;
    }

    public void setCancelCode(Integer cancelCode) {
        this.cancelCode = cancelCode;
    }

    public String getCancelRemark() {
        return cancelRemark;
    }

    public void setCancelRemark(String cancelRemark) {
        this.cancelRemark = cancelRemark;
    }


}