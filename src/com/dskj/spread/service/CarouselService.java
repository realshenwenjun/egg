package com.dskj.spread.service;

import java.util.List;

import com.dskj.spread.entity.Carousel;
import com.dskj.spread.entity.CarouselCollect;
import com.dskj.spread.entity.CarouselDetail;
import com.dskj.spread.entity.CarouselLove;
import com.dskj.util.Page;

public interface CarouselService {
	public void add(Carousel carousel) throws Exception;

	public void deleteById(int id) throws Exception;

	public List<Carousel> getList() throws Exception;

	public Carousel getById(int id) throws Exception;

	public void addCarouselLove(CarouselLove carouselLove) throws Exception;

	public void deleteCarouselLove(int carouselId, String userId)
			throws Exception;

	public void addCarouselCommet(int carouselId, String userId, String context)
			throws Exception;

	public CarouselDetail getDetailById(int id, String userId) throws Exception;

	public Object getCarouselComments(int carouselId, String userId, Page page)
			throws Exception;

	public void addCarouselCollect(CarouselCollect carouselCollect)
			throws Exception;

	public void deleteCarouselCollect(int carouselId, String userId)
			throws Exception;

	public void updateCarousel(Carousel carousel) throws Exception;
}
