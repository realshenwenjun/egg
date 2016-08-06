package com.dskj.community.service;

import java.util.List;

import com.dskj.community.entity.Circle;
import com.dskj.community.entity.Post;
import com.dskj.community.entity.PostCollect;
import com.dskj.community.entity.PostDetails;
import com.dskj.community.entity.PostImg;
import com.dskj.community.entity.PostLove;
import com.dskj.community.entity.PostVoide;
import com.dskj.community.entity.Topic;
import com.dskj.util.Page;

public interface CommunityService {
    public void addCircle(Circle circle) throws Exception;

    public List<Circle> getCircleList() throws Exception;

    public void updateCircle(Circle circle) throws Exception;

    public void deleteCircle(Integer id) throws Exception;

    public void addPost(Post post, List<PostImg> postImgs, List<PostVoide> postVoides) throws Exception;

    public void deletePost(int postId) throws Exception;

    public void addPostLove(PostLove postLove) throws Exception;

    public void deletePostLove(int postLoveId) throws Exception;

    public void addPostCollect(PostCollect postCollect) throws Exception;

    public void deletePostCollect(int id) throws Exception;
    
    public Integer addPostComment(String userId,Integer postId,String context) throws Exception;
    
  
    //topic表的业务方法start
    public void addTopic(Topic topic) throws Exception;

    public List<Topic> getTopicList(Page page) throws Exception;

    public void updateTopic(Topic topic) throws Exception;

    public void deleteTopic(Integer id) throws Exception;
    //topic表的业务方法end

    public List<PostDetails> getCirclePostList(String userId,int circleId,Page page) throws Exception;
    
    public List<PostDetails> getActivityPostList(String userId,Page page) throws Exception;
    
    public PostDetails getPostDetail(String userId,Integer postId) throws Exception;
    
    public Object getPostComments(Integer postId, String userId, Page page) throws Exception;
    
    public Object getInstitutionPostList(String institutionId,String userId,Page page) throws Exception;
    
    public Object getUserPostList(String visitorId,String userId,Page page) throws Exception;
    
    public Object getInstitutionCirclePostList(String institutionId,String userId,Page page) throws Exception;

    public Object getUserCirclePostList(String visitorId,String userId,Page page) throws Exception;
    
    public Post getPostById(Integer postId) throws Exception;
}
