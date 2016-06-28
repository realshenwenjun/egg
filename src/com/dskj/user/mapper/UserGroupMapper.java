package com.dskj.user.mapper;

import org.springframework.stereotype.Repository;

import com.dskj.base.CacheBean;
import com.dskj.user.entity2_0.UserGroup;

@Repository
public interface UserGroupMapper extends CacheBean {
	
	public void add(UserGroup userGroup) throws Exception;
	
	public UserGroup get(String uid) throws Exception;

}
