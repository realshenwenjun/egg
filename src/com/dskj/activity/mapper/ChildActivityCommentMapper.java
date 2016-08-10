package com.dskj.activity.mapper;

import com.dskj.util.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dskj.activity.entity.ChildActivityComment;

import java.util.List;

@Repository
public interface ChildActivityCommentMapper {

    public void add(ChildActivityComment childActivityComment) throws Exception;

    public int getCommentCount(int activityId) throws Exception;

    public List<Integer> getActivityCommentIds(@Param("activityId") int activityId,@Param("page") Page page) throws Exception;
    
    public int deleteComment(int commentId) throws Exception;
}