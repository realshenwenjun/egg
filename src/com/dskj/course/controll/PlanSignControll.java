package com.dskj.course.controll;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dskj.base.Base;
import com.dskj.course.entity.ManageCensusPlanSignByDay;
import com.dskj.course.entity.ManageUserCourseClassSignPlan;
import com.dskj.course.entity.ManageUserListByPlan;
import com.dskj.course.entity.ManageUserPlanSignByDay;
import com.dskj.course.entity.PlanListByDay;
import com.dskj.course.entity.PlanSign;
import com.dskj.course.entity.TeacherUserListByPlan;
import com.dskj.course.entity.TeacherUserPlanSignByDay;
import com.dskj.course.entity.UserPlanListByDay;
import com.dskj.course.service.PlanSignService;

@Controller
public class PlanSignControll extends Base {
	@Autowired
	private PlanSignService planSignService;

	/*
	 * 22 签到 查看学生某一天的课程表用于签到 psign={"userId":"7NK2LrkJ","date":1448100684568}
	 */
	@RequestMapping("/psign/plan/list/by/day")
	public void getPlanListByDay(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("psign");
			logger.info(jsonString);
			Date date = new Date(readTreeAsLong(jsonString, "date"));
			List<PlanListByDay> plans = planSignService.getPlanListByDay(
					readTree(jsonString, "userId"), date);
			write(response, null, null, null, plans);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 19兼容学生请假和老师请假 课程-上课情况-具体开课-学生 查看学生自己所报某一个班级的签到情况
	 * psign={"userId":"7NK2LrkJ","classId":1}
	 */
	@RequestMapping("/psign/sign/list/by/day")
	public void getUserPanByDay(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("psign");
			logger.info(jsonString);
			List<UserPlanListByDay> plans = planSignService.getUserPanByDay(
					readTree(jsonString, "userId"),
					readTreeAsInt(jsonString, "classId"));
			write(response, null, null, null, plans);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 22 学生签到
	 * psign={"classId":1,"classPlanId":19,"userId":"7NK2LrkJ","address":""}
	 */
	@RequestMapping("/psign/sign/do")
	public void addPlanSign(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("psign");
			logger.info(jsonString);
			PlanSign planSign = stringToObj(jsonString, PlanSign.class);

			planSign.setCreateTime(new Date());
			planSignService.addPlanSign(planSign);
			write(response, null, null, null, planSign);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 22 老师签到 psign={"userId":"7NK2LrkJ","address":"","institutionId":""}
	 */
	@RequestMapping("/psign/teacher/sign/do")
	public void addTeacherPlanSign(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("psign");
			logger.info(jsonString);
			PlanSign planSign = stringToObj(jsonString, PlanSign.class);
			planSign.setCreateTime(new Date());
			planSignService.addPlanSign(planSign);
//			/**刷新考勤统计缓存***/
//			String host = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/sys/cache/clear?cache=com.dskj.census.mapper.TimingCensusMapper";
//			HttpUtil.get(host, null);
			write(response, null, null, null, planSign);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 20兼容老师请假、学生请假和学生补课 教师查看自己所报某一个班级的签到情况 psign={"classId":1}
	 */
	@RequestMapping("/psign/list/techer/by/day")
	public void getTeacherUserPanSignByDay(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("psign");
			logger.info(jsonString);
			List<TeacherUserPlanSignByDay> plans = planSignService
					.getTeacherUserPanSignByDay(readTreeAsInt(jsonString,
							"classId"));
			write(response, null, null, null, plans);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 21兼容学生请假和补课 课程-上课情况-教师-某次课-具体签到情况 教师查看某天课程的签到具体学生情况
	 * psign={"classId":1,"planId":23}
	 */
	@RequestMapping("/psign/user/list/techer/by/plan")
	public void getTeacherUserListByPlan(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("psign");
			logger.info(jsonString);
			List<TeacherUserListByPlan> plans = planSignService
					.getTeacherUserListByPlan(
							readTreeAsInt(jsonString, "classId"),
							readTreeAsInt(jsonString, "planId"));
			write(response, null, null, null, plans);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 13 课程-上课情况-管理员-上下午上课-开课列表 管理员查看某天所有课程的签到情况
	 * psign={"institutionId":"6Fk31iKT","date":1448100684568}
	 */
	@RequestMapping("/psign/census/manage/by/day")
	public void getManageCensusPanSignByDay(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("psign");
			logger.info(jsonString);
			List<ManageCensusPlanSignByDay> census = planSignService
					.getManageCensusPanSignByDay(
							readTree(jsonString, "institutionId"), new Date(
									readTreeAsLong(jsonString, "date")));
			write(response, null, null, null, census);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 14 课程-上课情况-管理员-上下午上课-开课列表 管理员查看某天所有课程的签到情况
	 * psign={"institutionId":"6Fk31iKT","date":1448100684568,"noon":"before"}
	 * userId:教师id
	 */
	@RequestMapping("/psign/list/manage/by/day")
	public void getManageUserPanSignByDay(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("psign");
			logger.info(jsonString);
			List<ManageUserPlanSignByDay> plans = planSignService
					.getManageUserPanSignByDay(
							readTree(jsonString, "institutionId"), new Date(
									readTreeAsLong(jsonString, "date")),
							readTree(jsonString, "noon"));
			write(response, null, null, null, plans);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 15 课程-上课情况-管理员-上下午上课-具体签到情况 管理员查看某课程表的签到具体学生情况 psign={"planId":23}
	 */
	@RequestMapping("/psign/user/list/manage/by/plan")
	public void getManageUserListByPlan(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("psign");
			logger.info(jsonString);
			List<ManageUserListByPlan> plans = planSignService
					.getManageUserListByPlan(readTreeAsInt(jsonString, "planId"));
			write(response, null, null, null, plans);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 11 课程-上课情况-管理员-上下午上课-具体签到情况 管理员通过搜索学生查看学生时间段的签到情况
	 * psign={"institutionId":"","userId"
	 * :"7NK2LrkJ","startDate":17222222110,"endDate":17222222110}
	 */
	@RequestMapping("/psign/manage/user/course/class/sign/plan")
	public void getManageUserCourseClassSignPlan(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("psign");
			logger.info(jsonString);
			List<ManageUserCourseClassSignPlan> plans = planSignService
					.getManageUserCourseClassSignPlan(
							readTree(jsonString, "institutionId"),
							readTree(jsonString, "userId"), new Date(
									readTreeAsLong(jsonString, "startDate")),
							new Date(readTreeAsLong(jsonString, "endDate")));
			write(response, null, null, null, plans);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 12 课程-上课情况-管理员-上下午上课-具体签到情况 管理员通过搜索学生查看学生时间段内课时的签到具体情况
	 * psign={"userId":"7NK2LrkJ"
	 * ,"classId":1,"startDate":17222222110,"endDate":17222222110}
	 */
	@RequestMapping("/psign/manage/user/plan/sign/list")
	public void getManageUserPlanSignList(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("psign");
			logger.info(jsonString);
			List<UserPlanListByDay> plans = planSignService
					.getManageUserPlanSignList(readTree(jsonString, "userId"),
							readTreeAsInt(jsonString, "classId"), new Date(
									readTreeAsLong(jsonString, "startDate")),
							new Date(readTreeAsLong(jsonString, "endDate")));
			write(response, null, null, null, plans);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 老师获取今日签到记录psign={"institutionId":"","userId":"","date":1213323200000}
	 */
	@RequestMapping("/psign/teacher/plan/today/sign/list")
	public void getTeacherTodayPlanSignList(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("psign");
			logger.info(jsonString);
			Date date = null;
			Long dateTime = readTreeAsLong(jsonString,"date");
			if (dateTime == null || dateTime == 0)
				date = new Date();
			else
				date = new Date(dateTime);
			Object list = planSignService
					.getTeacherTodayPlanSignList(readTree(jsonString, "institutionId"),readTree(jsonString, "userId"),date);
			write(response, null, null, null, list);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}
}
