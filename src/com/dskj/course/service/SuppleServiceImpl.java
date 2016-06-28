package com.dskj.course.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dskj.base.Base;
import com.dskj.course.entity.ClassPlanLackList;
import com.dskj.course.entity.CourserClassTeacherList;
import com.dskj.course.entity.Plan;
import com.dskj.course.entity.Supple;
import com.dskj.course.entity.SuppleDetail;
import com.dskj.course.mapper.AdminCourseMapper;
import com.dskj.course.mapper.ClassMapper;
import com.dskj.course.mapper.ClassSignMapper;
import com.dskj.course.mapper.CourseMapper;
import com.dskj.course.mapper.GatherMapper;
import com.dskj.course.mapper.LackMapper;
import com.dskj.course.mapper.PlanMapper;
import com.dskj.course.mapper.PlanSignMapper;
import com.dskj.course.mapper.SuppleMapper;

@Service
public class SuppleServiceImpl extends Base implements SuppleService {
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

	public void addSupple(Supple supple) throws Exception {
		Supple supple2 = suppleMapper.getByPlanAndUser(supple.getPlanId(), supple.getUserId());
		if (supple2 != null)
			throw new Exception();
		suppleMapper.addSupple(supple);
		clearCache();
	}

	public List<ClassPlanLackList> getClassPlanLackList(String userId, int classId) throws Exception {
		return suppleMapper.getClassPlanLackList(userId, classId);
	}

	public List<ClassPlanLackList> getClassPlanOnlyLackList(String userId, int classId) throws Exception {
		return lackMapper.getClassPlanOnlyLackList(userId, classId);
	}

	public void addTeacherSupple(String jsonString) throws Exception {
		int classId = readTreeAsInt(jsonString, "classId");
		int planId = readTreeAsInt(jsonString, "planId");
		String userId = readTree(jsonString, "userId");
		List<Plan> plans = jsonToList(readTree(jsonString, "plans"), ArrayList.class, Plan.class);
		for (Plan plan : plans) {
			Supple supple = suppleMapper.getByPlanAndUser(planId, userId);
			if (supple == null) {
				supple = new Supple();
				plan.setClassId(classId);
				plan.setCreateTime(new Date());
				planMapper.addPlan(plan);

				supple.setClassId(classId);
				supple.setCreateTime(new Date());
				supple.setPlanId(planId);
				supple.setSuppleClassId(classId);
				supple.setSupplePlanId(plan.getId());
				supple.setUserId(userId);
				suppleMapper.addSupple(supple);
			}
		}
		clearCache();
	}

	public SuppleDetail getSuppleDetail(int id) throws Exception {
		return suppleMapper.getSuppleDetail(id);
	}

	public void clearCache() throws Exception {
		adminCourseMapper.clear();
		courseMapper.clear();
		classSignMapper.clear();
		gatherMapper.clear();
		lackMapper.clear();
		planMapper.clear();
		planSignMapper.clear();
		classMapper.clear();
	}

	public List<CourserClassTeacherList> getSuppleClassList(int classId,
			int courseId) throws Exception {
		return suppleMapper.getSuppleClassList(classId, courseId);
	}
}
