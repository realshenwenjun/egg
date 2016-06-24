package com.dskj.comment.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dskj.base.CacheBean;
import com.dskj.comment.entity.CommentImage;

@Repository
public interface CommentImageMapper extends CacheBean {
	public void add(List<CommentImage> commentImages) throws Exception;
}
