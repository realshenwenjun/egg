package com.dskj.comment.mapper;

import org.springframework.stereotype.Repository;

import com.dskj.base.CacheBean;
import com.dskj.comment.entity.CommentLove;

@Repository
public interface CommentLoveMapper extends CacheBean {
	
	public void add(CommentLove commentLove) throws Exception;
	
	public void delete(int commentId,String userId) throws Exception;
}
