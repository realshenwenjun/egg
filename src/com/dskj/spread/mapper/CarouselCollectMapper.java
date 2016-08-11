package com.dskj.spread.mapper;

import com.dskj.base.CacheBean;
import com.dskj.spread.entity.CarouselCollect;
import com.dskj.user.entity2_0.MyCollect;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarouselCollectMapper extends CacheBean {

	public void add(CarouselCollect carouselCollect) throws Exception;

	public void deleteById(int carouselId, String userId) throws Exception;

	public Integer getByCarouselIdAndUserId(int carouselId, String userId)
			throws Exception;

	public List<MyCollect> getCarouselCollectList2_0(String userId) throws Exception;

}
