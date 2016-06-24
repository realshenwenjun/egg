package com.dskj.course.controll;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dskj.base.Base;
import com.dskj.course.entity.CourseType;
import com.dskj.course.entity.CourseTypeOf;
import com.dskj.course.service.AdminCourseService;
/**
 * gather
 * @author Administrator
 *
 */
@Controller
public class AdminCourseControll extends Base {
	@Autowired
	private AdminCourseService adminCourseService;

	/*
	 * 管理员获取一个总课程分类 admin={"id":1}
	 */
	@RequestMapping("/admin/course/type/of/get")
	public void getCourseTypeOf(HttpServletRequest request, HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("admin");
			logger.info(jsonString);
			CourseTypeOf courseTypeOf = adminCourseService.getCourseTypeOf(readTreeAsInt(jsonString, "id"));
			write(response, null, null, null, courseTypeOf);
		} catch (Exception e) {
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 管理员增加一个总课程分类 admin={"name":"艺术"}
	 */
	@RequestMapping("/admin/course/type/of/add")
	public void addCourseTypeOf(HttpServletRequest request, HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("admin");
			logger.info(jsonString);
			CourseTypeOf courseTypeOf = new CourseTypeOf();
			courseTypeOf.setName(readTree(jsonString, "name"));
			if (adminCourseService.getCourseTypeOfByName(courseTypeOf.getName()) != null) {
				write(response, false, 900, "该类别已存在", null);
				return;
			}
			courseTypeOf.setCreateTime(new Date());
			adminCourseService.addCourseTypeOf(courseTypeOf);
			write(response, null, null, null, null);
		} catch (Exception e) {
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 管理员修改一个总课程分类 admin={"id":1,"name":"艺术"}
	 */
	@RequestMapping("/admin/course/type/of/update")
	public void updateCourseTypeOf(HttpServletRequest request, HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("admin");
			logger.info(jsonString);
			CourseTypeOf courseTypeOf = stringToObj(jsonString, CourseTypeOf.class);
			if (adminCourseService.getCourseTypeOfByName(courseTypeOf.getName()) != null) {
				write(response, false, 900, "该类别已存在", null);
				return;
			}
			adminCourseService.updateCourseTypeOf(courseTypeOf);
			write(response, null, null, null, null);
		} catch (Exception e) {
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 管理员删除一个总课程分类 admin={"id":1}
	 */
	@RequestMapping("/admin/course/type/of/delete")
	public void deleteCourseTypeOf(HttpServletRequest request, HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("admin");
			logger.info(jsonString);
			adminCourseService.deleteCourseTypeOf(readTreeAsInt(jsonString, "id"));
			write(response, null, null, null, null);
		} catch (Exception e) {
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 管理员获取总课程分类
	 */
	@RequestMapping("/admin/course/type/of/list")
	public void getCourseTypeOfList(HttpServletRequest request, HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("admin");
			logger.info(jsonString);
			Object object = adminCourseService.getCourseTypeOfList();
			write(response, null, null, null, object);
		} catch (Exception e) {
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 管理员获取一个课程分类 admin={"id":1}
	 */
	@RequestMapping("/admin/course/type/get")
	public void getCourseType(HttpServletRequest request, HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("admin");
			logger.info(jsonString);
			CourseType courseType = adminCourseService.getCourseType(readTreeAsInt(jsonString, "id"));
			write(response, null, null, null, courseType);
		} catch (Exception e) {
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 管理员增加一个课程分类 admin={"name":"","ofId":1,"cover":""}
	 */
	@RequestMapping("/admin/course/type/add")
	public void addCourseType(HttpServletRequest request, HttpServletResponse response) {
		CourseType courseType = null;
		try {
			String jsonString = request.getParameter("admin");
			logger.info(jsonString);
			courseType = stringToObj(jsonString, CourseType.class);
			courseType.setCreateTime(new Date());
			adminCourseService.addCourseType(courseType);
			write(response, null, null, null, courseType);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 管理员修改一个课程分类 admin={"id":1,"name":"","ofId":1,"cover":""}
	 */
	@RequestMapping("/admin/course/type/update")
	public void updateCourseType(HttpServletRequest request, HttpServletResponse response) {
		CourseType courseType = null;
		try {
			String jsonString = request.getParameter("admin");
			logger.info(jsonString);
			courseType = stringToObj(jsonString, CourseType.class);
			adminCourseService.updateCourseType(courseType);
			write(response, null, null, null, courseType.getCover());
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 管理员删除一个课程分类 admin={"id":1}
	 */
	@RequestMapping("/admin/course/type/delete")
	public void deleteCourseType(HttpServletRequest request, HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("admin");
			logger.info(jsonString);
			adminCourseService.deleteCourseType(readTreeAsInt(jsonString, "id"));
			write(response, null, null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 管理员获取所有课程分类
	 * admin={}
	 */
	@RequestMapping("/admin/course/type/list")
	public void getCourseTypeList(HttpServletRequest request, HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("admin");
			logger.info(jsonString);
			Object object = adminCourseService.getCourseTypeList(null);
			write(response, null, null, null, object);
		} catch (Exception e) {
			write(response, false, 911, e.getMessage(), null);
		}
	}
}
