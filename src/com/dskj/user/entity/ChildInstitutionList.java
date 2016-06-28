package com.dskj.user.entity;

import java.io.Serializable;

public class ChildInstitutionList implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -4192129266919208509L;
    private String institutionId;
    private String institutionName;
    private String courseType;
    private String logo;
    private String address;

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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


}
