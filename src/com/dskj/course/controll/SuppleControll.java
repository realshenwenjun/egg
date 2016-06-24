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
import com.dskj.course.entity.Supple;
import com.dskj.course.entity.SuppleDetail;
import com.dskj.course.service.SuppleService;

@Controller
public class SuppleControll extends Base {
	@Autowired
	private SuppleService suppleService;

	/*
	 * 29 学生补课
	 * supple={"classId":1,"planId":23,"userId":"","suppleClassId":2,"supplePlanId"
	 * }
	 */
	@RequestMapping("/supple/add")
	public void addSupple(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("supple");
			logger.info(jsonString);
			Supple supple = stringToObj(jsonString, Supple.class);
			supple.setCreateTime(new Date());
			suppleService.addSupple(supple);
			write(response, null, null, null, supple);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 29 管理员获取老师一个开课的补课列表 supple={"teacherId":"","classId":1}
	 */
	@RequestMapping("/supple/class/plan/lack/list")
	public void getClassPlanLackList(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("supple");
			logger.info(jsonString);
			List<ClassPlanLackList> classPlanLackLists = suppleService
					.getClassPlanLackList(readTree(jsonString, "teacherId"),
							readTreeAsInt(jsonString, "classId"));
			write(response, null, null, null, classPlanLackLists);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 30不包括补课的 管理员获取学生一个开课的请假情况 supple={"userId":"","classId":1}
	 */
	@RequestMapping("/supple/only/plan/lack/list")
	public void getClassPlanOnlyLackList(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("supple");
			logger.info(jsonString);
			List<ClassPlanLackList> classPlanLackLists = suppleService
					.getClassPlanOnlyLackList(readTree(jsonString, "userId"),
							readTreeAsInt(jsonString, "classId"));
			write(response, null, null, null, classPlanLackLists);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}
	/*
	 * 补课相关课程：
	 * 应排除掉请假学生上的课
     * supple={"classId":1,"courseId":1}
	 */
	@RequestMapping("/supple/class/list")
	public void getClassByCourse(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("supple");
			logger.info(jsonString);
			List<CourserClassTeacherList> clazzs = suppleService.getSuppleClassList(readTreeAsInt(jsonString, "classId"), readTreeAsInt(jsonString, "courseId"));
			write(response, null, null, null, clazzs);
		} catch (Exception e) {
			write(response, false, 911, e.getMessage(), null);
		}
	}
	/*
	 * 老师补课-增加具体安排同时生成补课记录 为班级添加课程表 - 客户端生成(适用于无规则的批量添加)
	 * supple={"classId":1,"planId"
	 * :23,"userId":"","plans":[{"date":1450195200000,"startTime"
	 * :"13:00:00","endTime":"15:00:00","userId":"3iji3","address":""}]}
	 */
	@RequestMapping("/supple/teacher/add")
	public void addPlanAtClient(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("supple");
			logger.info(jsonString);
			suppleService.addTeacherSupple(jsonString);
			write(response, null, null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 学生请假列表里查看补课详情 supple={"id":1}
	 */
	@RequestMapping("/supple/detail/get")
	public void getSuppleDetail(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("supple");
			logger.info(jsonString);
			SuppleDetail detail = suppleService.getSuppleDetail(readTreeAsInt(
					jsonString, "id"));
			write(response, null, null, null, detail);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}
}
