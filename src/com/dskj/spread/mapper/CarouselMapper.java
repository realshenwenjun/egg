package com.dskj.spread.mapper;

import java.util.List;

import com.dskj.spread.entity.CarouselDetail;
import org.springframework.stereotype.Repository;

import com.dskj.base.CacheBean;
import com.dskj.spread.entity.Carousel;

@Repository
public interface CarouselMapper extends CacheBean{
	
	public void add(Carousel carousel) throws Exception;
	
	public void deleteById(int id) throws Exception;
	
	public List<Carousel> getList() throws Exception;
	
	public Carousel getById(int id) throws Exception;

	public CarouselDetail getDetailById(int id) throws Exception;

	public void update(Carousel carousel) throws Exception;

}
