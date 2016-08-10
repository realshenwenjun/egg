package com.dskj.spread.mapper;

import com.dskj.util.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dskj.base.CacheBean;
import com.dskj.spread.entity.CarouselComment;

import java.util.List;

@Repository
public interface CarouselCommentMapper extends CacheBean {

	public void add(CarouselComment carouselComment) throws Exception;

	public int getCommentCount(int carouselId) throws Exception;

	public List<Integer> getCarouselCommentIds(@Param("carouselId") int carouselId,@Param("page") Page page) throws Exception;
	
	public int deleteComment(int commentId) throws Exception;
}
