package com.dskj.course.controll;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dskj.base.Base;
import com.dskj.course.entity.ClassSignUser;
import com.dskj.course.service.ClassSignService;

@Controller
public class ClassSignControll extends Base{
	@Autowired
	private ClassSignService classSignService;
	/*
	 * 17
	 * 为班级添加学生
	 * csign={"classId":1,"institutionId":"","users":["",""]}
	 */
	@RequestMapping("/csign/add/user")
	public void addUserToClass(HttpServletRequest request, HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("csign");
			logger.info(jsonString);
			classSignService.addUserToClass(jsonString);
			write(response, null, null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}
	/*
	 * 18
	 * 删除班级中某个学生
	 * csign={"userId":"","classId":1}
	 */
	@RequestMapping("/csign/delete/user")
	public void deleteUserFromClass(HttpServletRequest request, HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("csign");
			logger.info(jsonString);
			classSignService.deleteClassSign(readTree(jsonString, "userId"),readTreeAsInt(jsonString, "classId"));
			write(response, null, null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}
	/*18
	 * 课程-上课情况-具体开课-学生选课
	 * 教师查看班级中学生
	 * csign={"classId":1}
	 */
	@RequestMapping("/csign/get/user")
	public void getUsersFromClass(HttpServletRequest request, HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("csign");
			logger.info(jsonString);
			List<ClassSignUser> signUsers = classSignService.getUsersFromClass(readTreeAsInt(jsonString, "classId"));
			write(response, null, null, null, signUsers);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}
	/*
	 * 17
	 * 课程-上课情况-具体开课-学生选课-增加学生
	 * 教师按名称或手机号搜索未报名的学生
	 * csign={"key":"张三","classId":1}
	 */
	@RequestMapping("/csign/get/unsign/user")
	public void getUnSignUsersByName(HttpServletRequest request, HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("csign");
			logger.info(jsonString);
			List<ClassSignUser> signUsers = classSignService.getUnSignUsersByName(readTree(jsonString, "name"), readTreeAsInt(jsonString, "classId"));
			write(response, null, null, null, signUsers);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}
	/*
	 * 10
	 * 搜索学生，查看学生上课情况
	 * csign={"key":"","institutionId":1}
	 */
	@RequestMapping("/csign/get/my/user/by/name")
	public void getMyUsersByName(HttpServletRequest request, HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("csign");
			logger.info(jsonString);
			List<ClassSignUser> signUsers = classSignService.getMyUsersByName(readTree(jsonString, "name"), readTree(jsonString, "institutionId"));
			write(response, null, null, null, signUsers);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}
}
