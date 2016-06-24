package com.dskj.course.mapper;

import org.springframework.stereotype.Repository;

import com.dskj.base.CacheBean;
import com.dskj.course.entity2_0.ClassLove;

@Repository
public interface ClassLoveMapper extends CacheBean{
	
	public void add(ClassLove classLove) throws Exception;
	
	public int getClassLoveCount(int classId) throws Exception;
	
	public Integer getLoveId(int classId,String userId) throws Exception;
	
	public void delete(int id) throws Exception;
	
}
