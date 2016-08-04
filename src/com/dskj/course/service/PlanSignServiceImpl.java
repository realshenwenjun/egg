package com.dskj.course.service;

import java.util.*;

import com.dskj.course.entity2_0.TeacherSign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.dskj.course.mapper.AdminCourseMapper;
import com.dskj.course.mapper.ClassMapper;
import com.dskj.course.mapper.ClassSignMapper;
import com.dskj.course.mapper.CourseMapper;
import com.dskj.course.mapper.GatherMapper;
import com.dskj.course.mapper.LackMapper;
import com.dskj.course.mapper.PlanMapper;
import com.dskj.course.mapper.PlanSignMapper;
import com.dskj.course.mapper.SuppleMapper;
import com.dskj.util.DateUtil;

@Service
public class PlanSignServiceImpl extends Base implements PlanSignService {
	@Autowired
	private AdminCourseMapper adminCourseMapper;
	@Autowired
	private ClassMapper classMapper;
	@Autowired
	private CourseMapper courseMapper;
	@Autowired
	private ClassSignMapper classSignMapper;
	@Autowired
	private GatherMapper gatherMapper;
	@Autowired
	private LackMapper lackMapper;
	@Autowired
	private PlanMapper planMapper;
	@Autowired
	private PlanSignMapper planSignMapper;
	@Autowired
	private SuppleMapper suppleMapper;

	public List<UserPlanListByDay> getUserPanByDay(String userId, int classId) throws Exception {
		int c = planSignMapper.getClassSignCount(userId, classId);
		if (c != 0)
			return planSignMapper.getUserPanByDay(userId, classId);
		else
			return planSignMapper.getSuppleUserPanByDay(userId, classId);
	}

	public void addPlanSign(PlanSign planSign) throws Exception {
		planSignMapper.addPlanSign(planSign);
	}

	public List<TeacherUserPlanSignByDay> getTeacherUserPanSignByDay(int classId) throws Exception {
		return planSignMapper.getTeacherUserPanSignByDay(classId);
	}

	public List<TeacherUserListByPlan> getTeacherUserListByPlan(int classId, int planId) throws Exception {
		return planSignMapper.getTeacherUserListByPlan(classId, planId);
	}

	public List<ManageUserPlanSignByDay> getManageUserPanSignByDay(String institutionId, Date date, String noon) throws Exception {
		if ("before".equals(noon))
			return planSignMapper.getManageUserPanSignByDayBefore(institutionId, date);
		else
			return planSignMapper.getManageUserPanSignByDayAfter(institutionId, date);
	}

	public List<ManageUserListByPlan> getManageUserListByPlan(int planId) throws Exception {
		return planSignMapper.getManageUserListByPlan(planId);
	}

	public List<PlanListByDay> getPlanListByDay(String userId, Date date) throws Exception {
		return planSignMapper.getPlanListByDay(userId, date);
	}

	public List<ManageUserCourseClassSignPlan> getManageUserCourseClassSignPlan(String institutionId, String userId, Date startDate, Date endDate)
			throws Exception {
		return planSignMapper.getManageUserCourseClassSignPlan(institutionId, userId, startDate, endDate);
	}

	public List<UserPlanListByDay> getManageUserPlanSignList(String userId, int classId, Date startDate, Date endDate) throws Exception {
		return planSignMapper.getManageUserPlanSignList(userId, classId, startDate, endDate);
	}

	public List<ManageCensusPlanSignByDay> getManageCensusPanSignByDay(String institutionId, Date date) throws Exception {
		List<ManageUserPlanSignByDay> before = planSignMapper.getManageUserPanSignByDayBefore(institutionId, date);
		List<ManageUserPlanSignByDay> after = planSignMapper.getManageUserPanSignByDayAfter(institutionId, date);
		ManageCensusPlanSignByDay beforeC = new ManageCensusPlanSignByDay();
		ManageCensusPlanSignByDay afterC = new ManageCensusPlanSignByDay();
		for (ManageUserPlanSignByDay m : before) {
			if (m.getPlanSignCount() != 0)
				beforeC.setSignPlanCount(beforeC.getSignPlanCount() + 1);
			beforeC.setSignCount(beforeC.getSignCount() + m.getPlanSignCount());
			beforeC.setUserCount(beforeC.getUserCount() + m.getUserCount());
		}
		beforeC.setPlanCount(before.size());
		for (ManageUserPlanSignByDay m : after) {
			if (m.getPlanSignCount() != 0)
				afterC.setSignPlanCount(afterC.getSignPlanCount() + 1);

			afterC.setSignCount(afterC.getSignCount() + m.getPlanSignCount());
			afterC.setUserCount(afterC.getUserCount() + m.getUserCount());
		}
		afterC.setPlanCount(after.size());
		List<ManageCensusPlanSignByDay> list = new ArrayList<ManageCensusPlanSignByDay>();
		list.add(beforeC);
		list.add(afterC);
		return list;
	}

	public Object getTeacherTodayPlanSignList(String userId, Date date) throws Exception {
//		Map<String,Object> cache = new HashMap<String, Object>();
		List<TeacherSign> list = planSignMapper.getTeacherTodayPlanSignList(userId, date);
//		List<TeacherSign> o = new ArrayList<TeacherSign>();
//		if (list != null && list.size() != 0){
//			for (TeacherSign teacherSign : list){
//				String key = getTeacherSignKey(teacherSign.getInstitutionId(), teacherSign.getCreateTime());
//				if (cache.get(key) == null){
//					cache.put(key, "");
//					if (key.contains("BEFORE"))
//						teacherSign.setType("before");
//					else
//						teacherSign.setType("after");
//					o.add(teacherSign);
//				}
//			}
//		}
		return list;
	}

	public void clearCache() throws Exception {
		adminCourseMapper.clear();
		courseMapper.clear();
		classSignMapper.clear();
		gatherMapper.clear();
		lackMapper.clear();
		planMapper.clear();
		classMapper.clear();
		suppleMapper.clear();
	}
	
	private String getTeacherSignKey(String institutionId,Date createTime){
		String dateTime = DateUtil.formatDate(createTime,DateUtil.normalTimeFormat);
		String HH = dateTime.substring(11, 13);
		if (Integer.valueOf(HH) <= 12)
			return institutionId + "BEFORE";
		else
			return institutionId + "AFTER";
	}
}
