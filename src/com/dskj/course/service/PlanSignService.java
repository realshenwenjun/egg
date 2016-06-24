package com.dskj.course.service;

import java.util.Date;
import java.util.List;

import com.dskj.course.entity.ManageCensusPlanSignByDay;
import com.dskj.course.entity.ManageUserCourseClassSignPlan;
import com.dskj.course.entity.ManageUserListByPlan;
import com.dskj.course.entity.ManageUserPlanSignByDay;
import com.dskj.course.entity.PlanListByDay;
import com.dskj.course.entity.PlanSign;
import com.dskj.course.entity.TeacherUserListByPlan;
import com.dskj.course.entity.TeacherUserPlanSignByDay;
import com.dskj.course.entity.UserPlanListByDay;

public interface PlanSignService {
	public List<PlanListByDay> getPlanListByDay(String userId, Date date) throws Exception;

	public List<UserPlanListByDay> getUserPanByDay(String userId, int classId) throws Exception;

	public void addPlanSign(PlanSign planSign) throws Exception;

	public List<TeacherUserPlanSignByDay> getTeacherUserPanSignByDay(int classId) throws Exception;

	public List<TeacherUserListByPlan> getTeacherUserListByPlan(int classId, int planId) throws Exception;

	public List<ManageUserPlanSignByDay> getManageUserPanSignByDay(String institutionId, Date date, String noon) throws Exception;

	public List<ManageCensusPlanSignByDay> getManageCensusPanSignByDay(String institutionId, Date date) throws Exception;

	public List<ManageUserListByPlan> getManageUserListByPlan(int planId) throws Exception;

	public List<ManageUserCourseClassSignPlan> getManageUserCourseClassSignPlan(String institutionId, String userId, Date startDate, Date endDate)
			throws Exception;

	public List<UserPlanListByDay> getManageUserPlanSignList(String userId, int classId, Date startDate, Date endDate) throws Exception;

	public Object getTeacherTodayPlanSignList(String userId, Date date) throws Exception;
}
