package com.dskj.course.mapper;

import java.util.Date;
import java.util.List;

import com.dskj.course.entity2_0.TeacherSign;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dskj.base.CacheBean;
import com.dskj.course.entity.ClassSignUser;
import com.dskj.course.entity.ManageUserCourseClassSignPlan;
import com.dskj.course.entity.ManageUserListByPlan;
import com.dskj.course.entity.ManageUserPlanSignByDay;
import com.dskj.course.entity.PlanListByDay;
import com.dskj.course.entity.PlanSign;
import com.dskj.course.entity.TeacherUserListByPlan;
import com.dskj.course.entity.TeacherUserPlanSignByDay;
import com.dskj.course.entity.UserPlanListByDay;
import com.dskj.course.entity2_0.TeacherClassPlan;

@Repository
public interface PlanSignMapper extends CacheBean{
	public List<PlanListByDay> getPlanListByDay(String userId,Date date) throws Exception;
	
	public List<UserPlanListByDay> getUserPanByDay(String userId,int classId) throws Exception;
	
	public void addPlanSign(PlanSign planSign) throws Exception;
	
	public List<TeacherUserPlanSignByDay> getTeacherUserPanSignByDay(int classId) throws Exception;
	
	public List<TeacherUserListByPlan> getTeacherUserListByPlan(int classId,int planId) throws Exception;
	
	public List<ManageUserPlanSignByDay> getManageUserPanSignByDayBefore(String institutionId,Date date) throws Exception;
	
	public List<ManageUserPlanSignByDay> getManageUserPanSignByDayAfter(String institutionId,Date date) throws Exception;
	
	public List<ManageUserListByPlan> getManageUserListByPlan(int planId) throws Exception;
	
	public List<ManageUserCourseClassSignPlan> getManageUserCourseClassSignPlan(String institutionId,String userId,Date startDate,Date endDate) throws Exception;
	
	public List<UserPlanListByDay> getManageUserPlanSignList(String userId,int classId,Date startDate,Date endDate) throws Exception;
	
	public List<TeacherSign> getTeacherTodayPlanSignList(@Param("institutionId") String institutionId,@Param("userId") String userId,@Param("date") Date date) throws Exception;
	
	public int getClassSignCount(String userId,int classId) throws Exception;
	
	public List<UserPlanListByDay> getSuppleUserPanByDay(String userId,int classId) throws Exception;
	
	public String getCurrentInstitutionId(String userId) throws Exception;

	public PlanSign getByUserIdAndClassIdAndDate(String userId,Integer classId,Date date) throws Exception;
	
	public List<TeacherClassPlan> getCourseClassSignInfo2_0(String userId,Date date) throws Exception;
	
	public List<ClassSignUser> getCourseClassStudentSignList2_0(Integer classId,Date date) throws Exception;
	
	public List<ClassSignUser> getCourseClassStudentUnSignList2_0(Integer classId,Date date) throws Exception;
	
}
