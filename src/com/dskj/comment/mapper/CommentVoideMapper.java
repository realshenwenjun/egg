package com.dskj.comment.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dskj.base.CacheBean;
import com.dskj.comment.entity.CommentVoide;

@Repository
public interface CommentVoideMapper extends CacheBean {
	public void add(List<CommentVoide> commentVoides) throws Exception;
}
