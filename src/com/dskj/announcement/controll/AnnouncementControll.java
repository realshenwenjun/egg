package com.dskj.announcement.controll;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dskj.announcement.entity.Announcement;
import com.dskj.announcement.entity.AnnouncementRead;
import com.dskj.announcement.entity.AnnouncementVO;
import com.dskj.announcement.service.AnnouncementService;
import com.dskj.base.Base;
import com.dskj.util.Page;

@Controller
public class AnnouncementControll extends Base {
	@Autowired
	private AnnouncementService announcementService;

	/*
	 * 管理员增加一个公告
	 * announcement={"title":"","content":"","typeId":1,"belong":0,"institutionId"
	 * :"","userId":"","annoImage":""}
	 */
	@RequestMapping("/announcement/add")
	public void addAnnouncement(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("announcement");
			logger.info(jsonString);
			Announcement announcement = stringToObj(jsonString,
					Announcement.class);
			announcement.setCreateTime(new Date());
			if (announcement.getUserId() == null
					|| "".equals(announcement.getUserId()))
				write(response, false, 500, "参数不完整", null);
			else {
				announcementService.add(announcement);
				write(response, null, null, null, announcement);
			}
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 管理员修改一个公告
	 * announcement={"id":1,"title":"","content":"","typeId":1,"belong"
	 * :0,"institutionId":"","userId":"","annoImage":""}
	 */
	@RequestMapping("/announcement/update")
	public void updateAnnouncement(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("announcement");
			logger.info(jsonString);
			Announcement announcement = stringToObj(jsonString,
					Announcement.class);
			announcementService.update(announcement);
			write(response, null, null, null, null);
		} catch (Exception e) {
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 上传公告图片 announcement={"id":22,"annoImage":""}
	 */
	@RequestMapping("/announcement/image")
	public void uploadAnnoImage(HttpServletRequest request,
			HttpServletResponse response) {
		String tempFile = null;
		try {
			String jsonString = request.getParameter("announcement");
			logger.info(jsonString);
			tempFile = readTree(jsonString, "annoImage");
			int id = readTreeAsInt(jsonString, "id");
			Announcement announcement = announcementService.get(id);
			announcement.setAnnoImage(tempFile);
			announcementService.update(announcement);
			write(response, null, null, "修改成功", announcement.getAnnoImage());
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 管理员删除一个公告 announcement={"ids":[1,2]}
	 */
	@RequestMapping("/announcement/delete")
	public void daleteAnnouncement(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("announcement");
			logger.info(jsonString);
			List<Integer> ids = jsonToList(readTree(jsonString, "ids"),
					ArrayList.class, Integer.class);
			announcementService.delete(ids);
			write(response, null, null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	// /*
	// * 管理员删除一个公告图片 announcement={"id":1,"annoImage":""}
	// */
	// @RequestMapping("/announcement/image/delete")
	// public void daleteAnnouncementImage(HttpServletRequest request,
	// HttpServletResponse response) {
	// try {
	// String jsonString = request.getParameter("announcement");
	// logger.info(jsonString);
	// String imageToDel = readTree(jsonString, "annoImage");
	// Announcement announcement =
	// announcementService.get(readTreeAsInt(jsonString, "id"));
	// String annoImages = announcement.getAnnoImage();
	// String image = ",";
	// String[] annoString = annoImages.split(",");
	// for (String annoImage : annoString) {
	// if (!annoImage.equals(imageToDel)) {
	// image = image + annoImage + ",";
	// }
	// }
	// image = image.substring(1, image.length() - 1);
	// announcement.setAnnoImage(image);
	// announcementService.update(announcement);
	// fileUpload.dropImg(request.getSession().getServletContext().getRealPath(""),
	// imageToDel);
	// write(response, null, null, null, null);
	// } catch (Exception e) {
	// e.printStackTrace();
	// write(response, false, 911, e.getMessage(), null);
	// }
	// }

	/*
	 * 用户获取所有公告 announcement={"userId":"","pageNo":0,"pageSize":10}
	 */
	@RequestMapping("/announcement/list")
	public void getAnnouncementSystemList(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("announcement");
			logger.info(jsonString);
			Page page = stringToObj(jsonString, Page.class);
			List<AnnouncementVO> list = announcementService.getList(
					readTree(jsonString, "userId"), page);
			write(response, null, null, null, list);
		} catch (Exception e) {
			write(response, false, 911, e.getMessage(), null);
		}
	}
	/*
	 * 用户获取未读公告数量 announcement={"userId":""}
	 */
	@RequestMapping("/announcement/new/count")
	public void getAnnouncementNewCount(HttpServletRequest request,
										  HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("announcement");
			logger.info(jsonString);
			write(response, null, null, null, announcementService.getAnnouncementNewCount(readTree(jsonString, "userId")));
		} catch (Exception e) {
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 用户搜索公告 announcement={"userId":"","title":"","pageNo":0,"pageSize":10}
	 */
	@RequestMapping("/announcement/list/search")
	public void getListByTitle(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("announcement");
			logger.info(jsonString);
			Page page = stringToObj(jsonString, Page.class);
			List<AnnouncementVO> list = announcementService.getListByTitle(
					readTree(jsonString, "userId"),
					readTree(jsonString, "title"), page);
			write(response, null, null, null, list);
		} catch (Exception e) {
			write(response, false, 911, e.getMessage(), null);
		}
	}


	/*
	 * 其他人读公告 announcement={"announcementId":1,"userId":"","institutionId":""}
	 */
	@RequestMapping("/announcement/read")
	public void addAnnouncementRead(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("announcement");
			logger.info(jsonString);
			AnnouncementRead announcementRead = stringToObj(jsonString,
					AnnouncementRead.class);
			AnnouncementRead read = announcementService
					.getRead(announcementRead);
			if (read != null) {
				write(response, null, null, null, read);
				return;
			}
			announcementRead.setCreateTime(new Date());
			announcementService.addRead(announcementRead);
			write(response, null, null, null, announcementRead);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}
	/*
	 * 平台管理员获取公告数announcement={"pageNo":0,"pageSize":10}
	 */
	@RequestMapping("/announcement/platfoems/list")
	public void getPlatformsAnnouncementList(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("announcement");
			logger.info(jsonString);
			Page page = stringToObj(jsonString, Page.class);
			Object o = announcementService.getPlatformsAnnouncementList(page);
			write(response, null, null, null, o);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}
	/*
	 * 平台管理员获取公告数量
	 */
	@RequestMapping("/announcement/count")
	public void getAnnouncementCount(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("announcement");
			logger.info(jsonString);
			write(response, null, null, null, announcementService.getAnnouncementCount());
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}
	/*
	 * 公告详情announcement={"id":1}
	 */
	@RequestMapping("/announcement/get")
	public void getAnnouncement(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("announcement");
			logger.info(jsonString);
			write(response, null, null, null, announcementService.getAnnouncement(readTreeAsInt(jsonString, "id")));
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}
}
