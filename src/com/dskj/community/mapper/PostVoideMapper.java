package com.dskj.community.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dskj.base.CacheBean;
import com.dskj.community.entity.PostVoide;

@Repository
public interface PostVoideMapper extends CacheBean {
    public void add(@Param("postVoides") List<PostVoide> postVoides) throws Exception;

    public void delete(int postId) throws Exception;
    
    public PostVoide getPostVoide(@Param("postId") Integer postId) throws Exception;
    
}
