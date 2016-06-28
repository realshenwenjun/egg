package com.dskj.course.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dskj.base.Base;
import com.dskj.course.entity.ClassPlanLackList;
import com.dskj.course.entity.CourserClassTeacherList;
import com.dskj.course.entity.Lack;
import com.dskj.course.entity.ManageClassTeacherList;
import com.dskj.course.entity.Plan;
import com.dskj.course.entity.Supple;
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
public class HolidayServiceImpl extends Base implements HolidayService {
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

	public void addLack(Lack lack) throws Exception {
		lackMapper.addLack(lack);
		clearCache();
	}

	public List<CourserClassTeacherList> getCourseClassTeacherList(
			String userId, String institutionId) throws Exception {
		return classSignMapper.getCourseClassTeacherList(userId, institutionId);
	}

	public List<ClassPlanLackList> getClassPlanLackList(String userId,
			int classId) throws Exception {
		return lackMapper.getClassPlanLackList(userId, classId);
	}

	public int deleteLack(int id) throws Exception {
		Lack lack = lackMapper.getById(id);
		if (lack == null)
			return 0;// 请假不存在
		Supple supple = suppleMapper.getByPlanAndUser(lack.getPlanId(),
				lack.getUserId());
		Plan planLack = planMapper.getPlanById(lack.getPlanId());
		Date now = new Date();
		if (planLack.getDate().getTime() < DateUtil.parseDate(
				DateUtil.formatDate(now, DateUtil.normalDateFormat)).getTime()
				|| (DateUtil.formatDate(planLack.getDate(),
						DateUtil.normalDateFormat).equals(
						DateUtil.formatDate(now, DateUtil.normalDateFormat)) && DateUtil
						.parseDate(
								DateUtil.formatDate(now,
										DateUtil.normalDateFormat)
										+ " "
										+ planLack.getStartTime(),
								DateUtil.normalTimeFormat).after(now)))
			return 1;// 请假的课已经上了
		if (supple != null) {
			Plan planSupple = planMapper.getPlanById(supple.getSupplePlanId());
			if (planSupple.getDate().getTime() < DateUtil.parseDate(
					DateUtil.formatDate(now, DateUtil.normalDateFormat))
					.getTime()
					|| (DateUtil.formatDate(planSupple.getDate(),
							DateUtil.normalDateFormat)
							.equals(DateUtil.formatDate(now,
									DateUtil.normalDateFormat)) && DateUtil
							.parseDate(
									DateUtil.formatDate(now,
											DateUtil.normalDateFormat)
											+ " "
											+ planSupple.getStartTime(),
									DateUtil.normalTimeFormat).after(now)))
				return 2;
		}
		lackMapper.deleteLack(id);
		// 同时补课记录
		if (supple != null)
			suppleMapper.deleteById(supple.getId());
		clearCache();
		return 0;
	}

	public List<ManageClassTeacherList> getManageClassTeacherList(
			String institutionId, String key) throws Exception {
		return classMapper.getCourseClassTeacherList(institutionId, key);
	}
	public void clearCache() throws Exception {
		adminCourseMapper.clear();
		courseMapper.clear();
		classSignMapper.clear();
		gatherMapper.clear();
		classMapper.clear();
		planMapper.clear();
		planSignMapper.clear();
		suppleMapper.clear();
	}
}
