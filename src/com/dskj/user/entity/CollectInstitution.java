package com.dskj.user.entity;

import java.io.Serializable;

public class CollectInstitution implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 8671958550152068763L;
    private Integer id;
    private String institutionId;
    private String institutionName;
    private String address;
    private String logo;
    private String firstRegin;
    private String secondRegin;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getFirstRegin() {
        return firstRegin;
    }

    public void setFirstRegin(String firstRegin) {
        this.firstRegin = firstRegin;
    }

    public String getSecondRegin() {
        return secondRegin;
    }

    public void setSecondRegin(String secondRegin) {
        this.secondRegin = secondRegin;
    }
}
