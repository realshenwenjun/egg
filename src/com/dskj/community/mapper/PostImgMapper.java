package com.dskj.community.mapper;

import com.dskj.base.CacheBean;
import com.dskj.community.entity.PostImg;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostImgMapper extends CacheBean {

    public void add(@Param("posImgs") List<PostImg> postImgs) throws Exception;

    public void delete(int postId) throws Exception;
    
    public List<PostImg> getPostImgList(@Param("postId") Integer postId) throws Exception;
}
