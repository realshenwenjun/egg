package com.dskj.community.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dskj.base.CacheBean;
import com.dskj.community.entity.PostComment;
import com.dskj.util.Page;

@Repository
public interface PostCommentMapper extends CacheBean {

	public void add(PostComment postComment) throws Exception;

	public int getCommentCount(int postId) throws Exception;

	public List<Integer> getPostCommentIds(@Param("postId") int postId,
			@Param("page") Page page) throws Exception;
	public int deleteComment(int commentId) throws Exception;
}
