package com.dskj.community.mapper;

import java.util.List;

import com.dskj.base.CacheBean;
import com.dskj.community.entity.PostCollect;
import com.dskj.user.entity2_0.MyCollect;

import org.springframework.stereotype.Repository;

@Repository
public interface PostCollectMapper extends CacheBean {

    public void add(PostCollect postCollect) throws Exception;

    public void delete(int id) throws Exception;

    //查询帖子收藏数
    public int getCollectCount(int postId) throws Exception;
    
    public List<MyCollect> getUserCollectList2_0(String userId) throws Exception;
}
