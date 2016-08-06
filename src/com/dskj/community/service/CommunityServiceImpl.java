package com.dskj.community.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dskj.base.Base;
import com.dskj.comment.entity.Comment;
import com.dskj.comment.mapper.CommentMapper;
import com.dskj.community.entity.Circle;
import com.dskj.community.entity.Post;
import com.dskj.community.entity.PostCollect;
import com.dskj.community.entity.PostComment;
import com.dskj.community.entity.PostDetails;
import com.dskj.community.entity.PostImg;
import com.dskj.community.entity.PostLove;
import com.dskj.community.entity.PostVoide;
import com.dskj.community.entity.Topic;
import com.dskj.community.mapper.CircleMapper;
import com.dskj.community.mapper.PostCollectMapper;
import com.dskj.community.mapper.PostCommentMapper;
import com.dskj.community.mapper.PostImgMapper;
import com.dskj.community.mapper.PostLoveMapper;
import com.dskj.community.mapper.PostMapper;
import com.dskj.community.mapper.PostVoideMapper;
import com.dskj.community.mapper.TopicMapper;
import com.dskj.util.Page;

@Service
public class CommunityServiceImpl extends Base implements CommunityService {

    @Autowired
    private CircleMapper circleMapper;

    @Autowired
    private PostMapper postMapper;
    @Autowired
    private PostImgMapper postImgMapper;
    @Autowired
    private PostVoideMapper postVoideMapper;
    @Autowired
    private TopicMapper topicMapper;
    @Autowired
    private PostLoveMapper postLoveMapper;
    @Autowired
    private PostCollectMapper postCollectMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private PostCommentMapper postCommentMapper;

    public void addCircle(Circle circle) throws Exception {
        circleMapper.add(circle);
    }

    public List<Circle> getCircleList() throws Exception {
        return circleMapper.getList();
    }

    public void updateCircle(Circle circle) throws Exception {
        circleMapper.update(circle);
    }

    public void deleteCircle(Integer id) throws Exception {
        circleMapper.delete(id);
    }

    public void addPost(Post post, List<PostImg> postImgs,
                        List<PostVoide> postVoides) throws Exception {
        if (post.getCircleId() == 0){
            post.setCircleId(null);
        }
        postMapper.add(post);
        for (PostImg postImg : postImgs) {
            postImg.setPostId(post.getId());
        }
        for (PostVoide postVoide : postVoides) {
            postVoide.setPostId(post.getId());
        }
        if (postImgs.size() != 0)
            postImgMapper.add(postImgs);
        if (postVoides.size() != 0)
            postVoideMapper.add(postVoides);
    }

    public void deletePost(int postId) throws Exception {
        postMapper.delete(postId);
        postImgMapper.delete(postId);
        postVoideMapper.delete(postId);
    }

    public void addPostLove(PostLove postLove) throws Exception {
        postLoveMapper.add(postLove);
    }

    public void deletePostLove(int postLoveId) throws Exception {
        postLoveMapper.delete(postLoveId);
    }

    public void addPostCollect(PostCollect postCollect) throws Exception {
        postCollectMapper.add(postCollect);
    }

    public void deletePostCollect(int id) throws Exception {
        postCollectMapper.delete(id);
    }

    public void addTopic(Topic topic) throws Exception {
        topicMapper.add(topic);

    }

    public List<Topic> getTopicList(Page page) throws Exception {
        return topicMapper.getList(page);
    }

    public void updateTopic(Topic topic) throws Exception {
        topicMapper.update(topic);

    }

    public void deleteTopic(Integer id) throws Exception {
        topicMapper.delete(id);

    }

    public Integer addPostComment(String userId, Integer postId, String context)
            throws Exception {
        Comment comment = new Comment();
        comment.setContext(context);
        comment.setCreateTime(new Date());
        comment.setIsOriginal(false);
        comment.setUserId(userId);
        commentMapper.add(comment);
        PostComment postComment = new PostComment();
        postComment.setCommentId(comment.getId());
        postComment.setPostId(postId);
        postComment.setCreateTime(new Date());
        postCommentMapper.add(postComment);
        return comment.getId();
    }

    public List<PostDetails> getCirclePostList(String userId, int circleId,
                                               Page page) throws Exception {
        return postMapper.getCirclePostList(userId, circleId == 0 ? null : circleId, page);
    }

    public List<PostDetails> getActivityPostList(String userId, Page page)
            throws Exception {
        return postMapper.getActivityPostList(userId, page);
    }

    public PostDetails getPostDetail(String userId, Integer postId)
            throws Exception {
        return postMapper.getPostDetail(userId, postId);
    }

    public Object getPostComments(Integer postId, String userId, Page page)
            throws Exception {
        List<Integer> commentIds = postCommentMapper.getPostCommentIds(postId,
                page);
        if (commentIds != null && commentIds.size() != 0) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("list", commentIds);
            map.put("userId", userId);
            Object o = commentMapper.getCommentsByIds(map);
            return o;
        }
        return null;
    }

	public Object getInstitutionPostList(String institutionId,String userId, Page page)
			throws Exception {
		return postMapper.getInstitutionPostList(institutionId, userId, page);
	}

	public Object getUserPostList(String visitorId,String userId, Page page) throws Exception {
		return postMapper.getUserPostList(visitorId,userId,page);
	}

	public Object getInstitutionCirclePostList(String institutionId,
			String userId, Page page) throws Exception {
//		List<Integer> circleIds = postMapper.getInstitutionCirclrIds(institutionId);
//        if (circleIds == null || circleIds.size() == 0) {
//            circleIds = new ArrayList<Integer>();
//            circleIds.add(0);
//        }
		Object o = postMapper.getInstitutionCirclesPostList(institutionId, userId, page);
		int count = postMapper.getInstitutionCirclesPostCount(institutionId);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("posts", o);
		map.put("count", count);
		return map;
	}

    public Object getUserCirclePostList(String visitorId, String userId, Page page) throws Exception {
//        List<Integer> circleIds = circleMapper.getUserCircles(userId);
//        if (circleIds == null || circleIds.size() == 0) {
//            circleIds = new ArrayList<Integer>();
//            circleIds.add(0);
//        }
        Object o = postMapper.getUserCirclesPostList(userId, visitorId, page);
        int count = postMapper.getUserCirclesPostCount(userId);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("posts", o);
        map.put("count", count);
        return map;
    }

	@Override
	public Post getPostById(Integer postId) throws Exception {
		return postMapper.get(postId);
	}

}
