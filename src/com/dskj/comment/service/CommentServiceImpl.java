package com.dskj.comment.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dskj.message.Mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dskj.activity.mapper.ChildActivityCommentMapper;
import com.dskj.base.Base;
import com.dskj.comment.entity.Comment;
import com.dskj.comment.entity.CommentChildVO;
import com.dskj.comment.entity.CommentImage;
import com.dskj.comment.entity.CommentLove;
import com.dskj.comment.entity.CommentVO;
import com.dskj.comment.entity.CommentVoide;
import com.dskj.comment.mapper.CommentImageMapper;
import com.dskj.comment.mapper.CommentLoveMapper;
import com.dskj.comment.mapper.CommentMapper;
import com.dskj.comment.mapper.CommentVoideMapper;
import com.dskj.user.mapper.InstitutionCommentMapper;
import com.dskj.util.Page;

@Service
public class CommentServiceImpl extends Base implements CommentService {
	@Autowired
	private CommentMapper commentMapper;
	@Autowired
	private CommentLoveMapper commentLoveMapper;
	@Autowired
	private CommentImageMapper commentImageMapper;
	@Autowired
	private CommentVoideMapper commentVoideMapper;
	@Autowired
	private MessageMapper messageMapper;
	@Autowired
	private ChildActivityCommentMapper childActivityCommentMapper;
	@Autowired
	private InstitutionCommentMapper institutionCommentMapper;

	public List<CommentVO> getChildrenComments(int id, String userId, Page page)
			throws Exception {
		List<Integer> ids = commentMapper.getChildrenIds(id, page);
		if (ids != null && ids.size() != 0) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("list", ids);
			map.put("userId", userId);
			List<CommentVO> o = commentMapper.getCommentsByIds(map);
			return o;
		}
		return null;
	}

	public void addChildComment(Comment comment, String videoPaths,
			String imagePaths) throws Exception {
		commentMapper.add(comment);
		if (videoPaths != null && !"".equals(videoPaths)) {
			List<String> paths = jsonToList(videoPaths, ArrayList.class,
					String.class);
			List<CommentVoide> commentVoides = new ArrayList<CommentVoide>();
			for (String path : paths) {
				CommentVoide commentVoide = new CommentVoide();
				commentVoide.setCommentId(comment.getId());
				commentVoide.setCreateTime(new Date());
				commentVoide.setVoidePath(path);
				commentVoides.add(commentVoide);
			}
			commentVoideMapper.add(commentVoides);
		}
		if (imagePaths != null && !"".equals(imagePaths)) {
			List<String> paths = jsonToList(imagePaths, ArrayList.class,
					String.class);
			List<CommentImage> commentImages = new ArrayList<CommentImage>();
			for (String path : paths) {
				CommentImage commentImage = new CommentImage();
				commentImage.setCommentId(comment.getId());
				commentImage.setCreateTime(new Date());
				commentImage.setImgPath(path);
				commentImages.add(commentImage);
			}
			commentImageMapper.add(commentImages);
		}
	}

	public void addCommentLove(CommentLove commentLove) throws Exception {
		commentLoveMapper.add(commentLove);
		commentMapper.clear();
	}

	public void deleteCommentLove(int commentId, String userId)
			throws Exception {
		commentLoveMapper.delete(commentId, userId);
		commentMapper.clear();
	}

	public List<CommentChildVO> getChildComments(int commentId, Page page)
			throws Exception {
		return commentMapper.getChildComments(commentId, page);
	}

	public void deleteComment(int commentId) throws Exception {
		commentMapper.delete(commentId);
		//删除这条评论产生的消息
		messageMapper.deleteCommentMessage(commentId);
		//删除活动的评价数量
		childActivityCommentMapper.deleteComment(commentId);
		//删除机构的评价
		institutionCommentMapper.deleteComment(commentId);
	}

	public CommentVO getCommentVOById(int commentId, String userId)
			throws Exception {
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(commentId);
		if (ids != null && ids.size() != 0) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("list", ids);
			map.put("userId", userId);
			List<CommentVO> o = commentMapper.getCommentsByIds(map);
			if (o != null && o.size() != 0)
				return o.get(0);
		}
		return null;
	}

	public Comment getByCommentId(int commentId) throws Exception {
		return commentMapper.getById(commentId);
	}

	public Object getCommentMessageList(String userId, Page page)
			throws Exception {
		return commentMapper.getCommentMessageList(userId, page);
	}

	public void addCommentMessageRead(Integer messageId) throws Exception {
		commentMapper.updateCommentMessageRead(messageId);
	}

	public int getCommentMessageNewCount(String userId) throws Exception {
		return commentMapper.getCommentMessageNewCount(userId);
	}

}
