package com.dskj.community.controll;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dskj.base.Base;
import com.dskj.community.entity.Circle;
import com.dskj.community.entity.Post;
import com.dskj.community.entity.PostCollect;
import com.dskj.community.entity.PostDetails;
import com.dskj.community.entity.PostImg;
import com.dskj.community.entity.PostLove;
import com.dskj.community.entity.PostVoide;
import com.dskj.community.entity.Topic;
import com.dskj.community.service.CommunityService;
import com.dskj.util.Page;

@Controller
public class CommunityControll extends Base {
	@Autowired
	private CommunityService communityService;

	/*
	 * 增加一个圈子 community={"name":"","imgUrl":""}
	 */
	@RequestMapping("/community/circle/add")
	public void addCircle(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsoString = request.getParameter("community");
			logger.info(jsoString);
			Circle circle = stringToObj(jsoString, Circle.class);
			circle.setCreateTime(new Date());
			communityService.addCircle(circle);
			write(response, null, null, null, circle);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 修改一个圈子 community={"id":1,"name":"","imgUrl":""}
	 */
	@RequestMapping("/community/circle/update")
	public void updateCircle(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsoString = request.getParameter("community");
			logger.info(jsoString);
			Circle circle = stringToObj(jsoString, Circle.class);
			communityService.updateCircle(circle);
			write(response, null, null, null, circle);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 删除一个圈子 community={"id":1}
	 */
	@RequestMapping("/community/circle/delete")
	public void deleteCircle(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsoString = request.getParameter("community");
			logger.info(jsoString);
			communityService.deleteCircle(readTreeAsInt(jsoString, "id"));
			write(response, null, null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 查询圈子列表 community={}
	 */
	@RequestMapping("/community/circle/list")
	public void getCircleList(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsoString = request.getParameter("community");
			logger.info(jsoString);
			List<Circle> circles = communityService.getCircleList();
			write(response, null, null, null, circles);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 增加一个帖子
	 * community={"userId":"","circleId":1,"context":"","type":"","topicId"
	 * :"","imgUrls":
	 * ["www.aaa.com","www.bbb.com"],"voideUrls":["www.ccc.com","www.ccc.com"]}
	 */
	@RequestMapping("/community/post/add")
	public void addPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("community");
			logger.info(jsonString);
			Post post = new Post();
			post.setCreateTime(new Date());
			post.setCircleId(readTreeAsInt(jsonString, "circleId"));
			post.setContext(readTree(jsonString, "context"));
			post.setTopicId(readTreeAsInt(jsonString, "topicId"));
			post.setType(readTreeAsInt(jsonString, "type"));
			post.setUserId(readTree(jsonString, "userId"));
			Date createDate = new Date();
			List<PostImg> postImgs1 = new ArrayList<PostImg>();
			List<PostVoide> postVoides1 = new ArrayList<PostVoide>();

			String imgUrls = readTree(jsonString, "imgUrls");
			String voideUrls = readTree(jsonString, "voideUrls");
			if (imgUrls != null) {
				List<String> postImgs = jsonToList(imgUrls, ArrayList.class,
						String.class);
				if (postImgs != null) {
					for (String postImg : postImgs) {
						PostImg postImg1 = new PostImg();
						postImg1.setCreateTime(createDate);
						postImg1.setUrl(postImg);
						postImgs1.add(postImg1);
					}
				}
			}
			if (voideUrls != null) {
				List<String> postVoides = jsonToList(voideUrls,
						ArrayList.class, String.class);
				if (postVoides != null) {
					for (String postVoide : postVoides) {
						PostVoide postVoide1 = new PostVoide();
						postVoide1.setUrl(postVoide);
						postVoide1.setCreateTime(createDate);
						postVoides1.add(postVoide1);
					}
				}
			}

			communityService.addPost(post, postImgs1, postVoides1);
			write(response, null, null, null, post);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 删除一个帖子community={"id":1}
	 */
	@RequestMapping("/community/post/delete")
	public void deletePost(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsoString = request.getParameter("community");
			logger.info(jsoString);
			communityService.deletePost(readTreeAsInt(jsoString, "id"));
			write(response, null, null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 点赞一个帖子community={"postId":1,"userId":""}
	 */
	@RequestMapping("/community/post/love/add")
	public void addPostLove(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsoString = request.getParameter("community");
			logger.info(jsoString);
			PostLove postLove = stringToObj(jsoString, PostLove.class);
			postLove.setCreateTime(new Date());
			communityService.addPostLove(postLove);
			write(response, null, null, null, postLove);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 取消点赞一个帖子community={"postLoveId":1}
	 */
	@RequestMapping("/community/post/love/delete")
	public void deletePostLove(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsoString = request.getParameter("community");
			logger.info(jsoString);
			communityService.deletePostLove(readTreeAsInt(jsoString,
					"postLoveId"));
			write(response, null, null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 收藏一个帖子community={"postId":1,"userId":""}
	 */
	@RequestMapping("/community/post/collect/add")
	public void addPostCollect(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsoString = request.getParameter("community");
			logger.info(jsoString);
			PostCollect postCollect = stringToObj(jsoString, PostCollect.class);
			postCollect.setCreateTime(new Date());
			communityService.addPostCollect(postCollect);
			write(response, null, null, null, postCollect);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 取消收藏一个帖子community={"postCollectId":1}
	 */
	@RequestMapping("/community/post/collect/delete")
	public void deletePostCollect(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsoString = request.getParameter("community");
			logger.info(jsoString);
			communityService.deletePostCollect(readTreeAsInt(jsoString,
					"postCollectId"));
			write(response, null, null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 圈子里帖子列表 community={"circleId":1,"userId":"","pageNo":0,"pageSize":10}
	 */
	@RequestMapping("/community/post/circle/list")
	public void getPostCircleList(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("community");
			logger.info(jsonString);
			Page page = new Page();
			page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
			page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
			// 圈子id
			Integer circleId = readTreeAsInt(jsonString, "circleId");
			// 用户id
			String userId = readTree(jsonString, "userId");
			List<PostDetails> postDetailsList = communityService
					.getCirclePostList(userId, circleId, page);
			write(response, null, null, null, postDetailsList);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 热门的帖子列表 community={"userId":"","pageNo":0,"pageSize":10}
	 */
	@RequestMapping("/community/post/activity/list")
	public void getPostActivityList(HttpServletRequest request,
			HttpServletResponse response) {
		try {

			String jsonString = request.getParameter("community");
			logger.info(jsonString);
			Page page = new Page();
			page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
			page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
			// 用户id
			String userId = readTree(jsonString, "userId");
			List<PostDetails> postDetailsList = communityService
					.getActivityPostList(userId, page);
			write(response, null, null, null, postDetailsList);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 机构动态列表
	 * community={"institutionId":"","userId":"","pageNo":0,"pageSize":10}
	 */
	@RequestMapping("/community/institution/post/list")
	public void getInstitutionPostList(HttpServletRequest request,
			HttpServletResponse response) {
		try {

			String jsonString = request.getParameter("community");
			logger.info(jsonString);
			Page page = new Page();
			page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
			page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
			Object o = communityService.getInstitutionPostList(
					readTree(jsonString, "institutionId"),
					readTree(jsonString, "userId"), page);
			write(response, null, null, null, o);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}
	/*
	 * 机构圈子列表
	 * community={"institutionId":"","userId":"","pageNo":0,"pageSize":10}
	 */
	@RequestMapping("/community/institution/circle/post/list")
	public void getInstitutionCirclePostList(HttpServletRequest request,
			HttpServletResponse response) {
		try {

			String jsonString = request.getParameter("community");
			logger.info(jsonString);
			Page page = new Page();
			page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
			page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
			Object o = communityService.getInstitutionCirclePostList(
					readTree(jsonString, "institutionId"),
					readTree(jsonString, "userId"), page);
			write(response, null, null, null, o);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}
	/*
	 * 个人最新动态
	 * community={"visitorId":"","userId":"","pageNo":0,"pageSize":10}
	 */
	@RequestMapping("/community/user/post/list")
	public void getUserPostList(HttpServletRequest request,
			HttpServletResponse response) {
		try {

			String jsonString = request.getParameter("community");
			logger.info(jsonString);
			Page page = new Page();
			page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
			page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
			Object o = communityService.getUserPostList(
					readTree(jsonString, "visitorId"),
					readTree(jsonString, "userId"), page);
			write(response, null, null, null, o);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}
	/*
	 * 个人圈子动态
	 * community={"visitorId":"","userId":"","pageNo":0,"pageSize":10}
	 */
	@RequestMapping("/community/user/circle/post/list")
	public void getUserCirclePostList(HttpServletRequest request,
								HttpServletResponse response) {
		try {

			String jsonString = request.getParameter("community");
			logger.info(jsonString);
			Page page = new Page();
			page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
			page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
			Object o = communityService.getUserCirclePostList(
					readTree(jsonString, "visitorId"),
					readTree(jsonString, "userId"), page);
			write(response, null, null, null, o);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 帖子详情 community={"userId":"","postId":0}
	 */
	@RequestMapping("/community/post/detail")
	public void getPostDetail(HttpServletRequest request,
			HttpServletResponse response) {
		try {

			String jsonString = request.getParameter("community");
			logger.info(jsonString);

			// 帖子id
			Integer postId = readTreeAsInt(jsonString, "postId");
			// 用户id
			String userId = readTree(jsonString, "userId");
			PostDetails postDetails = communityService.getPostDetail(userId,
					postId);
			write(response, null, null, null, postDetails);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 帖子增加评论 community={"userId":"","postId":0,"context":""}
	 */
	@RequestMapping("/community/post/comment/add")
	public void addPostComment(HttpServletRequest request,
			HttpServletResponse response) {
		try {

			String jsonString = request.getParameter("community");
			logger.info(jsonString);
			communityService.addPostComment(readTree(jsonString, "userId"),
					readTreeAsInt(jsonString, "postId"),
					readTree(jsonString, "context"));
			write(response, null, null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 获取帖子评论列表 community={"userId":"","postId":1,"pageNo":0,"pageSize":10}
	 */
	@RequestMapping("/community/post/comment/list")
	public void getPostCommentList(HttpServletRequest request,
			HttpServletResponse response) {
		try {

			String jsonString = request.getParameter("community");
			logger.info(jsonString);
			Page page = new Page();
			page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
			page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
			Object o = communityService.getPostComments(
					readTreeAsInt(jsonString, "postId"),
					readTree(jsonString, "userId"), page);
			write(response, null, null, null, o);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 修改一个
	 * 话题community={"id":1,"userId":"","title":"","context":"","imgUrl":"","type"
	 * :""}
	 */
	@RequestMapping("/community/topic/update")
	public void updateTopic(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsoString = request.getParameter("community");
			logger.info(jsoString);
			Topic topic = stringToObj(jsoString, Topic.class);
			communityService.updateTopic(topic);
			write(response, null, null, null, topic);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 查询话题列表 community={"pageNo":0,"pageSize":10}
	 */
	@RequestMapping("/community/topic/list")
	public void getTopicList(HttpServletRequest request,
			HttpServletResponse response) {
		try {

			String jsonString = request.getParameter("community");
			logger.info(jsonString);
			Page page = stringToObj(jsonString, Page.class);
			List<Topic> topics = communityService.getTopicList(page);

			write(response, null, null, null, topics);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 增加一个话题
	 * community={"userId":"","circleId":10,"title":"","context":"","imgUrl"
	 * :"","type":1} type:1,2,3
	 */
	@RequestMapping("/community/topic/add")
	public void getTopic(HttpServletRequest request,
			HttpServletResponse response) {
		try {

			String jsonString = request.getParameter("community");
			logger.info(jsonString);
			Topic topic = stringToObj(jsonString, Topic.class);
			topic.setCreateTime(new Date());
			communityService.addTopic(topic);
			write(response, null, null, null, topic);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 删除一个话题 community={"topicId":1} type:1,2,3
	 */
	@RequestMapping("/community/topic/delete")
	public void deleteTopic(HttpServletRequest request,
			HttpServletResponse response) {
		try {

			String jsonString = request.getParameter("community");
			logger.info(jsonString);
			Topic topic = stringToObj(jsonString, Topic.class);
			topic.setCreateTime(new Date());
			communityService.addTopic(topic);
			write(response, null, null, null, topic);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}
}
