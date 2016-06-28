package com.dskj.course.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dskj.base.CacheBean;
import com.dskj.course.entity2_0.ClassComment;
import com.dskj.util.Page;

@Repository
public interface ClassCommentMapper extends CacheBean{
	public void add(ClassComment classComment) throws Exception;
	
	public void delete(int classId,int commentId) throws Exception;
	
	public List<Integer> getCommentIds(@Param("classId") int classId,@Param("page") Page page) throws Exception;
	
	public int getCommentCount(int classId) throws Exception;
	
}
