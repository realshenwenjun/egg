package com.dskj.course.entity2_0;

import java.io.Serializable;
import java.util.Date;

/**
 * TeacherSign
 *
 * @author shenwenjun
 * @date 2016/5/18
 */
public class TeacherSign implements Serializable {
    private static final long serialVersionUID = -2594536794990914329L;
    
    private String institutionId;
    private String institutionName;
    private String logo;
    private String type;
    private String address;
    private Date createTime;
    
    
    
    
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
