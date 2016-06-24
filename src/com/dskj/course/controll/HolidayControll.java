package com.dskj.course.controll;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dskj.base.Base;
import com.dskj.course.entity.ClassPlanLackList;
import com.dskj.course.entity.CourserClassTeacherList;
import com.dskj.course.entity.Lack;
import com.dskj.course.entity.ManageClassTeacherList;
import com.dskj.course.service.HolidayService;

@Controller
public class HolidayControll extends Base{
	@Autowired
	private HolidayService holidayService;
	/*26
	 * 学生和老师请假
	 * holiday={"classId":1,"planId":23,"userId":"","reason":""}
	 */
	@RequestMapping("/holiday/add")
	public void addLack(HttpServletRequest request, HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("holiday");
			logger.info(jsonString);
			Lack lack = stringToObj(jsonString, Lack.class);
			lack.setCreateTime(new Date());
			holidayService.addLack(lack);
			write(response, null, null, null, lack);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}
	/*26
	 * 学生和老师取消请假
	 * holiday={"lackId":1}
	 */
	@RequestMapping("/holiday/delete")
	public void deleteLack(HttpServletRequest request, HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("holiday");
			logger.info(jsonString);
			int a = holidayService.deleteLack(readTreeAsInt(jsonString, "lackId"));
			if(a == 0)
				write(response, null, null, null, null);
			else if(a == 1)
				write(response, false, 888, "不能取消已经上课的请假!", null);
			else if(a == 2)
				write(response, false, 888, "不能取消补课已经上课的请假!", null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}
	/*25不包括补课的
	 * 管理员获取学生正在上的课和班级
	 * holiday={"userId":"","institutionId":""}
	 */
	@RequestMapping("/holiday/course/class/teacher/list")
	public void getCourseClassTeacherList(HttpServletRequest request, HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("holiday");
			logger.info(jsonString);
			List<CourserClassTeacherList> classTeacherLists = holidayService.getCourseClassTeacherList(readTree(jsonString, "userId"), readTree(jsonString, "institutionId"));
			write(response, null, null, null, classTeacherLists);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}
	/*26不包括补课的
	 * 管理员获取学生一个开课的请假情况
	 * holiday={"userId":"","classId":1}
	 */
	@RequestMapping("/holiday/class/plan/lack/list")
	public void getClassPlanLackList(HttpServletRequest request, HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("holiday");
			logger.info(jsonString);
			List<ClassPlanLackList> classPlanLackLists = holidayService.getClassPlanLackList(readTree(jsonString, "userId"), readTreeAsInt(jsonString, "classId"));
			write(response, null, null, null, classPlanLackLists);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}
	/*27不包括补课的
	 * 管理员获取老师正在上的课和班级
	 * holiday={"institutionId":"","key":""}
	 */
	@RequestMapping("/holiday/manage/class/teacher/list")
	public void getManageClassTeacherList(HttpServletRequest request, HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("holiday");
			logger.info(jsonString);
			List<ManageClassTeacherList> classTeacherLists = holidayService.getManageClassTeacherList(readTree(jsonString, "institutionId"), readTree(jsonString, "key"));
			write(response, null, null, null, classTeacherLists);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}
	/*28不包括补课的
	 * 管理员获取老师一个开课的请假情况
	 * holiday={"userId":"","classId":1}
	 */
	@RequestMapping("/holiday/class/teacher/plan/lack/list")
	public void getClassTeacherPlanLackList(HttpServletRequest request, HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("holiday");
			logger.info(jsonString);
			List<ClassPlanLackList> classPlanLackLists = holidayService.getClassPlanLackList(readTree(jsonString, "userId"), readTreeAsInt(jsonString, "classId"));
			write(response, null, null, null, classPlanLackLists);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}
}
