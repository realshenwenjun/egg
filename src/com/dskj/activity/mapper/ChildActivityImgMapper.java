package com.dskj.activity.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dskj.activity.entity.ChildActivityImg;
import com.dskj.base.CacheBean;
import com.dskj.util.Page;

@Repository
public interface ChildActivityImgMapper extends CacheBean{
	public void add(@Param("childActivityImgs") List<ChildActivityImg> childActivityImgs) throws Exception;
	
	public void deleteById(int id) throws Exception;
	
	public List<ChildActivityImg> getList(@Param("activityId") int activityId,@Param("page") Page page) throws Exception;
}