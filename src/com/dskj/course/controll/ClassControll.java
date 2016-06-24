package com.dskj.course.controll;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dskj.base.Base;
import com.dskj.course.entity.Clazz;
import com.dskj.course.entity.CourserClassTeacherList;
import com.dskj.course.entity.ManageCourseCount;
import com.dskj.course.entity.PassClass;
import com.dskj.course.exception.DeleteException;
import com.dskj.course.service.ClassService;
import com.dskj.util.Page;

@Controller
public class ClassControll extends Base {
	@Autowired
	private ClassService classService;

	/*
	 * 5 增加一个班级 class={"institutionId":"","courseId":1,"userId":"","name":""}
	 */
	@RequestMapping("/class/add")
	public void addClass(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("class");
			logger.info(jsonString);
			Clazz clazz = stringToObj(jsonString, Clazz.class);
			List<Clazz> clazzs = classService.getByName(clazz.getName(),
					clazz.getCourseId(), clazz.getInstitutionId());
			if (clazzs != null && clazzs.size() != 0) {
				write(response, false, 900, "该名称已被使用", null);
				return;
			}
			clazz.setCreateTime(new Date());
			classService.addClass(clazz);
			write(response, null, null, null, clazz);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 5 修改一个班级 class={"id":1,"userId":"","name":""}
	 */
	@RequestMapping("/class/update")
	public void updateClass(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("class");
			logger.info(jsonString);
			Clazz clazz = stringToObj(jsonString, Clazz.class);
			classService.updateClass(clazz);
			write(response, null, null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 删除一个班级 class={"id":1}
	 */
	@RequestMapping("/class/delete")
	public void deleteClass(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("class");
			logger.info(jsonString);
			int i = 0;
			try {
				i = classService.deleteClass(readTreeAsInt(jsonString, "id"));
				write(response, null, null, null, null);
			} catch (Exception e) {
				if (e instanceof DeleteException) {
					i = ((DeleteException) e).getI();
					switch (i) {
					case 1:
						write(response, false, 801, "本次课已上，不能删除！", null);
						break;
					case 2:
						write(response, false, 802, "本次课已有人请假，不能删除！", null);
						break;
					case 3:
						write(response, false, 803, "本次课已有人补课，不能删除！", null);
						break;
					default:
						break;
					}
				}else{
					throw e;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 2 管理员开课管理-按类别的课程的开课列表 按类别课程开课列表
	 * class={"courseTypeId":1,"institutionId":""}
	 */
	@RequestMapping("/class/manage/course/count")
	public void getManageCourseCount(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("class");
			logger.info(jsonString);
			List<ManageCourseCount> detail = classService.getManageCourseCount(
					readTreeAsInt(jsonString, "courseTypeId"),
					readTree(jsonString, "institutionId"));
			write(response, null, null, null, detail);
		} catch (Exception e) {
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 查询机构课程下面的班级 -补课时显示出与这个学生所上课程相同的所有开班 class={"courseId":1}
	 */
	@RequestMapping("/class/under/course")
	public void getClassByCourse(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("class");
			logger.info(jsonString);
			List<CourserClassTeacherList> clazzs = classService.getClassByCourseId(readTreeAsInt(
					jsonString, "courseId"));
			write(response, null, null, null, clazzs);
		} catch (Exception e) {
			write(response, false, 911, e.getMessage(), null);
		}
	}
	/*
	 * 查询机构课程过往开班 
	 * class={"courseId":1,"pageNo":0,"pageSize":10}
	 */
	@RequestMapping("/class/pass/list")
	public void getPassClass(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("class");
			logger.info(jsonString);
			Page page = new Page();
			page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
			page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
			List<PassClass> clazzs = classService.getPassClass(readTreeAsInt(jsonString, "courseId"), page);
			write(response, null, null, null, clazzs);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	// /*
	// * 开课详情
	// * class={"courseId":1,"pageNo":0,"pageSize":10}
	// */
	// @RequestMapping("/class/detail")
	// public void getClassDetail(HttpServletRequest request,
	// HttpServletResponse response) {
	// try {
	// String jsonString = request.getParameter("class");
	// logger.info(jsonString);
	// Page page = new Page();
	// page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
	// page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
	// List<PassClass> clazzs =
	// classService.getPassClass(readTreeAsInt(jsonString, "courseId"), page);
	// write(response, null, null, null, clazzs);
	// } catch (Exception e) {
	// e.printStackTrace();
	// write(response, false, 911, e.getMessage(), null);
	// }
	// }
}
