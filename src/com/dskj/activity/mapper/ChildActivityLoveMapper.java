package com.dskj.activity.mapper;


import org.springframework.stereotype.Repository;

import com.dskj.activity.entity.ChildActivityLove;
import com.dskj.base.CacheBean;

@Repository
public interface ChildActivityLoveMapper extends CacheBean{
	public void add(ChildActivityLove childActivityLove) throws Exception;

	public void deleteById(int activityId,String userId) throws Exception;

	public int getLoveCount(int activitylId) throws Exception;
	
	public Integer getByActivitylIdAndUserId(int activitylId,String userId) throws Exception;
}