package com.dskj.community.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dskj.base.CacheBean;
import com.dskj.community.entity.Post;
import com.dskj.community.entity.PostDetails;
import com.dskj.util.Page;

@Repository
public interface PostMapper extends CacheBean {

	public void add(Post post) throws Exception;
	
	public Post get(Integer id) throws Exception;

	public void delete(int id) throws Exception;

	// 查询数据
	public List<PostDetails> getCirclePostList(@Param("userId") String userId,
			@Param("circleId") Integer circleId, @Param("page") Page page)
			throws Exception;

	// 查询数据
	public List<PostDetails> getActivityPostList(
			@Param("userId") String userId, @Param("page") Page page)
			throws Exception;
	
	public PostDetails getPostDetail(String userId,Integer postId) throws Exception;
	
	public List<PostDetails> getInstitutionPostList(@Param("institutionId") String institutionId ,@Param("userId") String userId, @Param("page") Page page) throws Exception;
	
	public List<PostDetails> getUserPostList(@Param("visitorId") String visitorId,@Param("userId") String userId, @Param("page") Page page) throws Exception;
	
	public List<PostDetails> getInstitutionCirclesPostList(@Param("institutionId") String institutionId,@Param("userId") String userId, @Param("page") Page page) throws Exception;
	
	public int getInstitutionCirclesPostCount(@Param("institutionId") String institutionId) throws Exception;

	public List<PostDetails> getUserCirclesPostList(@Param("userId") String userId,@Param("visitorId") String visitorId, @Param("page") Page page) throws Exception;

	public int getUserCirclesPostCount(@Param("userId") String userId) throws Exception;
}
