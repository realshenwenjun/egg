package com.dskj.spread.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dskj.base.Base;
import com.dskj.comment.entity.Comment;
import com.dskj.comment.mapper.CommentMapper;
import com.dskj.spread.entity.Carousel;
import com.dskj.spread.entity.CarouselCollect;
import com.dskj.spread.entity.CarouselComment;
import com.dskj.spread.entity.CarouselDetail;
import com.dskj.spread.entity.CarouselLove;
import com.dskj.spread.mapper.CarouselCollectMapper;
import com.dskj.spread.mapper.CarouselCommentMapper;
import com.dskj.spread.mapper.CarouselLoveMapper;
import com.dskj.spread.mapper.CarouselMapper;
import com.dskj.util.Page;

@Service
public class CarouselServiceImpl extends Base implements CarouselService {
	@Autowired
	private CarouselMapper carouselMapper;
	@Autowired
	private CarouselLoveMapper carouselLoveMapper;
	@Autowired
	private CarouselCommentMapper carouselCommentMapper;
	@Autowired
	private CommentMapper commentMapper;
	@Autowired
	private CarouselCollectMapper carouselCollectMapper;

	public void add(Carousel carousel) throws Exception {
		carouselMapper.add(carousel);
	}

	public void deleteById(int id) throws Exception {
		carouselMapper.deleteById(id);
	}

	public List<Carousel> getList() throws Exception {
		return carouselMapper.getList();
	}

	public Carousel getById(int id) throws Exception {
		return carouselMapper.getById(id);
	}

	public void addCarouselLove(CarouselLove carouselLove) throws Exception {
		carouselLoveMapper.add(carouselLove);
	}

	public void deleteCarouselLove(int carouselId, String userId)
			throws Exception {
		carouselLoveMapper.deleteById(carouselId, userId);
	}

	/**
	 * 对轮播图评论
	 */
	public void addCarouselCommet(int carouselId, String userId, String context)
			throws Exception {
		Comment comment = new Comment();
		comment.setContext(context);
		comment.setCreateTime(new Date());
		comment.setIsOriginal(false);
		comment.setUserId(userId);
		commentMapper.add(comment);
		CarouselComment carouselComment = new CarouselComment();
		carouselComment.setCarouselId(carouselId);
		carouselComment.setCommentId(comment.getId());
		carouselComment.setCreateTime(new Date());
		carouselCommentMapper.add(carouselComment);
	}

	public CarouselDetail getDetailById(int id, String userId) throws Exception {
		CarouselDetail carouselDetail = carouselMapper.getDetailById(id);
		carouselDetail.setLoveCount(carouselLoveMapper.getLoveCount(id));
		carouselDetail.setCommentCount(carouselCommentMapper
				.getCommentCount(id));
		carouselDetail.setLoveId(carouselLoveMapper.getByCarouselIdAndUserId(
				id, userId));
		carouselDetail.setCollectId(carouselCollectMapper
				.getByCarouselIdAndUserId(id, userId));
		return carouselDetail;
	}

	public Object getCarouselComments(int carouselId, String userId, Page page)
			throws Exception {
		List<Integer> commentIds = carouselCommentMapper.getCarouselCommentIds(
				carouselId, page);
		if (commentIds != null && commentIds.size() != 0) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("list", commentIds);
			map.put("userId", userId);
			Object o = commentMapper.getCommentsByIds(map);
			return o;
		}
		return null;
	}

	public void addCarouselCollect(CarouselCollect carouselCollect)
			throws Exception {
		carouselCollectMapper.add(carouselCollect);
	}

	public void deleteCarouselCollect(int carouselId, String userId)
			throws Exception {
		carouselCollectMapper.deleteById(carouselId, userId);
	}

	public void updateCarousel(Carousel carousel) throws Exception {
		carouselMapper.update(carousel);
	}
}
