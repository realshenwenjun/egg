package com.dskj.community.controll;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dskj.base.Base;
import com.dskj.community.entity.Information;
import com.dskj.community.service.InformationService;
import com.dskj.util.Page;

@Controller
public class InformationControll extends Base {
	@Autowired
	private InformationService informationService;

	/*
	 * 增加一个资讯 information={"userId":"","title":"","context":"","imgUrls":[""]}
	 */
	@RequestMapping("/information/add")
	public void addInformation(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsoString = request.getParameter("information");
			logger.info(jsoString);
			List<String> imgUrls = jsonToList(readTree(jsoString, "imgUrls"),
					ArrayList.class, String.class);
			Integer infoId = informationService.addInformation(
					readTree(jsoString, "userId"),
					readTree(jsoString, "title"),
					readTree(jsoString, "context"), imgUrls);
			write(response, null, null, null, infoId);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 修改一个资讯 information={"id":1,"title":"","context":"","imgUrl":""}
	 */
	@RequestMapping("/information/update")
	public void updateInformation(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsoString = request.getParameter("information");
			logger.info(jsoString);
			informationService.updateInformation(
					readTreeAsInt(jsoString, "id"),
					readTree(jsoString, "title"),
					readTree(jsoString, "context"),
					readTree(jsoString, "imgUrl"));
			write(response, null, null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 删除一个资讯 information={"infoId":10}
	 */
	@RequestMapping("/information/delete")
	public void deleteInformation(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsoString = request.getParameter("information");
			logger.info(jsoString);
			informationService.deleteInformation(readTreeAsInt(jsoString,
					"infoId"));
			write(response, null, null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 获取最新资讯 information={"userId":"","pageNo":0,"pageSize":10}
	 */
	@RequestMapping("/information/list")
	public void getInformationList(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("information");
			logger.info(jsonString);
			Page page = new Page();
			page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
			page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
			List<Information> list = informationService.getInformationList(
					readTree(jsonString, "userId"), page);
			write(response, null, null, null, list);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 获取最新资讯数量 information={}
	 */
	@RequestMapping("/information/count")
	public void getInformationCount(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("information");
			logger.info(jsonString);
			Page page = new Page();
			write(response, null, null, null,
					informationService.getInformationCount());
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 查看资讯详情 information={"userId":"","infoId":1}
	 */
	@RequestMapping("/information/get")
	public void getInformation(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("information");
			logger.info(jsonString);
			Information information = informationService.getInformation(
					readTreeAsInt(jsonString, "infoId"),
					readTree(jsonString, "userId"));
			write(response, null, null, null, information);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 资讯点赞 information={"userId":"","infoId":1}
	 */
	@RequestMapping("/information/love/add")
	public void addInformationLove(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("information");
			logger.info(jsonString);
			informationService.addInformationLove(
					readTreeAsInt(jsonString, "infoId"),
					readTree(jsonString, "userId"));
			write(response, null, null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 资讯取消点赞 information={"userId":"","infoId":1}
	 */
	@RequestMapping("/information/love/delete")
	public void deleteInformationLove(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("information");
			logger.info(jsonString);
			informationService.deleteInformationLove(
					readTreeAsInt(jsonString, "infoId"),
					readTree(jsonString, "userId"));
			write(response, null, null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 收藏资讯 information={"userId":"","infoId":1}
	 */
	@RequestMapping("/information/collect/add")
	public void addInformationCollect(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("information");
			logger.info(jsonString);
			informationService.addInformationCollect(
					readTreeAsInt(jsonString, "infoId"),
					readTree(jsonString, "userId"));
			write(response, null, null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 取消收藏资讯 information={"userId":"","infoId":1}
	 */
	@RequestMapping("/information/collect/delete")
	public void deteleInformationCollect(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("information");
			logger.info(jsonString);
			informationService.deleteInformationCollect(
					readTreeAsInt(jsonString, "infoId"),
					readTree(jsonString, "userId"));
			write(response, null, null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 评论资讯 information={"userId":"","infoId":1,"context":""}
	 */
	@RequestMapping("/information/comment/add")
	public void addInformationComment(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("information");
			logger.info(jsonString);
			informationService.addInformationComment(
					readTreeAsInt(jsonString, "infoId"),
					readTree(jsonString, "userId"),
					readTree(jsonString, "context"));
			write(response, null, null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 删除评论资讯 information={"infoId":1,"commentId":1}
	 */
	@RequestMapping("/information/comment/delete")
	public void deleteInformationComment(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("information");
			logger.info(jsonString);
			informationService.deleteInformationComment(
					readTreeAsInt(jsonString, "infoId"),
					readTreeAsInt(jsonString, "commentId"));
			write(response, null, null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 获取评论列表 information={"infoId":1,"userId":"","pageNo":0,"pageSize":10}
	 */
	@RequestMapping("/information/comment/list")
	public void getInformationCommentList(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("information");
			logger.info(jsonString);
			Page page = new Page();
			page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
			page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
			Object o = informationService.getInformationComments(
					readTreeAsInt(jsonString, "infoId"),
					readTree(jsonString, "userId"), page);
			write(response, null, null, null, o);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}
}
