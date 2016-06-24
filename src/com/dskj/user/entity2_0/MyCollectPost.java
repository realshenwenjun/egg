package com.dskj.user.entity2_0;

import java.io.Serializable;
import java.util.List;

public class MyCollectPost implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6236683116028299033L;
	
    private String context; 
    private String userName;
    private List<String> imgUrls;
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
    
}
