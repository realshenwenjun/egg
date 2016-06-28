package com.dskj.course.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dskj.base.CacheBean;
import com.dskj.course.entity2_0.ClassFans;
import com.dskj.user.entity2_0.MyCollect;

@Repository
public interface ClassFansMapper extends CacheBean{
	
	public void add(ClassFans classFans) throws Exception;
	
	public void delete(int fansId) throws Exception;
	
	public Integer getFansId(int classId,String userId) throws Exception;
	
	public List<MyCollect> getUserCollectList2_0(String userId) throws Exception;
}
