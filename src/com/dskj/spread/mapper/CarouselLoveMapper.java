package com.dskj.spread.mapper;

import org.springframework.stereotype.Repository;

import com.dskj.base.CacheBean;
import com.dskj.spread.entity.CarouselLove;

@Repository
public interface CarouselLoveMapper extends CacheBean {

	public void add(CarouselLove carouselLove) throws Exception;

	public void deleteById(int carouselId,String userId) throws Exception;

	public int getLoveCount(int carouselId) throws Exception;
	
	public Integer getByCarouselIdAndUserId(int carouselId,String userId) throws Exception;

}
