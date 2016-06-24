package com.dskj.community.mapper;

import com.dskj.base.CacheBean;
import com.dskj.community.entity.PostLove;
import org.springframework.stereotype.Repository;

@Repository
public interface PostLoveMapper extends CacheBean {

    public void add(PostLove postLove) throws Exception;

    public void delete(int id) throws Exception;
    //查询帖子点赞数
    public int getLoveCount(int postId) throws Exception;

}
