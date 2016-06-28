package com.dskj.course.controll;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dskj.base.Base;
import com.dskj.course.entity.ManageClassUserCountDate;
import com.dskj.course.entity.ManageCourseClassCount;
import com.dskj.course.entity.UserGatherCourseClassPlan;
import com.dskj.course.service.GatherService;

/*
 * 此类请求没有缓存
 */
@Controller
public class GatherControll extends Base {
	@Autowired
	private GatherService gatherService;

	/*
	 * 16兼容学生补课
	 * 课程-总界面 学生查看自己课程安排明细 gather={"id":"7NK2LrkJ"}
	 */
	@RequestMapping("/gather/course/detail")
	public void getGatherCourseClassPlans(HttpServletRequest request, HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("gather");
			logger.info(jsonString);
			List<UserGatherCourseClassPlan> detail = gatherService.getGatherCourseClassPlans(readTree(jsonString, "id"));
			write(response, null, null, null, detail);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 16 兼容老师请假和补课,不包括学生补课
	 * 课程-总界面 教师查看自己课程安排明细 gather={"id":"esEXFUO2"}
	 */
	@RequestMapping("/gather/teacher/course/detail")
	public void getTeacherGatherCourseClassPlans(HttpServletRequest request, HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("gather");
			logger.info(jsonString);
			List<UserGatherCourseClassPlan> detail = gatherService.getTeacherGatherCourseClassPlans(readTree(jsonString, "id"));
			write(response, null, null, null, detail);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 1
	 * 管理员开课管理-类别、课程数量和班级数量 gather={"institutionId":""}
	 */
	@RequestMapping("/gather/manage/course/class/count")
	public void getManageCourseClassCount(HttpServletRequest request, HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("gather");
			logger.info(jsonString);
			List<ManageCourseClassCount> detail = gatherService.getManageCourseClassCount(readTree(jsonString, "institutionId"));
			write(response, null, null, null, detail);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 3
	 * 管理员开课管理-具体课程的开课列表 班级、教师、课次、开班日期 gather={"courseId":1}
	 */
	@RequestMapping("/gather/manage/class/user/count/date")
	public void getManageClassUserCountDate(HttpServletRequest request, HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("gather");
			logger.info(jsonString);
			List<ManageClassUserCountDate> detail = gatherService.getManageClassUserCountDate(readTreeAsInt(jsonString, "courseId"));
			write(response, null, null, null, detail);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}
}
