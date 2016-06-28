package com.dskj.comment.mapper;

import com.dskj.base.CacheBean;
import com.dskj.comment.entity.Comment;
import com.dskj.comment.entity.CommentChildVO;
import com.dskj.comment.entity.CommentMessage;
import com.dskj.comment.entity.CommentVO;
import com.dskj.util.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CommentMapper extends CacheBean {
	public void add(Comment comment) throws Exception;
	
	public void delete(int id) throws Exception;
	
	public List<Integer> getChildrenIds(@Param("id") int id,
			@Param("page") Page page) throws Exception;

	public List<CommentVO> getCommentsByIds(Map<String, Object> map)
			throws Exception;

	public List<CommentChildVO> getChildComments(
			@Param("commentId") int commentId, @Param("Page") Page Page)
			throws Exception;

	public Comment getById(int id) throws Exception;

	public List<CommentMessage> getCommentMessageList(@Param("userId") String userId , @Param("page") Page page) throws Exception;
	
	public void updateCommentMessageRead(int messageId) throws Exception;

	public int getCommentMessageNewCount(String userId) throws Exception;
}
