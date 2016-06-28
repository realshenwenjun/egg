package com.dskj.comment.service;

import java.util.List;

import com.dskj.comment.entity.Comment;
import com.dskj.comment.entity.CommentChildVO;
import com.dskj.comment.entity.CommentLove;
import com.dskj.comment.entity.CommentVO;
import com.dskj.util.Page;

public interface CommentService {

	public List<CommentVO> getChildrenComments(int id, String userId, Page page)
			throws Exception;

	public void addChildComment(Comment comment,String videoPaths,String imagePaths) throws Exception;
	
	public void addCommentLove(CommentLove commentLove) throws Exception;
	
	public void deleteCommentLove(int commentId,String userId) throws Exception;
	
	public List<CommentChildVO> getChildComments(int commentId,Page page) throws Exception;
	
	public void deleteComment(int commentId) throws Exception;
	
	public CommentVO getCommentVOById(int commentId,String userId) throws Exception;

	public Comment getByCommentId(int commentId) throws Exception;
	
	public Object getCommentMessageList(String userId,Page page) throws Exception;
	
	public void addCommentMessageRead(Integer messageId) throws Exception;

	public int getCommentMessageNewCount(String userId) throws Exception;
}
