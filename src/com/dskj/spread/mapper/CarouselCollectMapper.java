package com.dskj.spread.mapper;

import org.springframework.stereotype.Repository;

import com.dskj.base.CacheBean;
import com.dskj.spread.entity.CarouselCollect;

@Repository
public interface CarouselCollectMapper extends CacheBean {

	public void add(CarouselCollect carouselCollect) throws Exception;

	public void deleteById(int carouselId, String userId) throws Exception;

	public Integer getByCarouselIdAndUserId(int carouselId, String userId)
			throws Exception;

}
