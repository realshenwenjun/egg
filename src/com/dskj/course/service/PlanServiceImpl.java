package com.dskj.course.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dskj.base.Base;
import com.dskj.course.entity.MoreCourseList;
import com.dskj.course.entity.Plan;
import com.dskj.course.entity.PlanByClass;
import com.dskj.course.entity.PlanWeek;
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
import com.dskj.util.Page;

@Service
public class PlanServiceImpl extends Base implements PlanService {
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

	public void addPlanAtServer(String plan) throws Exception {
		Integer classId = readTreeAsInt(plan, "classId");
		int times = readTreeAsInt(plan, "times");// 次数
		long date = readTreeAsLong(plan, "date");// 开始时间
		int weekth = DateUtil.getWeekOfDate(new Date(date));
		List<PlanWeek> planWeeks = jsonToList(readTree(plan, "plans"), ArrayList.class, PlanWeek.class);
		List<Plan> plans = new ArrayList<Plan>();
		for (int i = 0; i < times / planWeeks.size(); i++) {
			for (int j = 0; j < planWeeks.size(); j++) {
				Plan each = new Plan();
				each.setAddress(planWeeks.get(j).getAddress());
				each.setClassId(classId);
				each.setUserId(null);
				each.setCreateTime(new Date());
				each.setDate(new Date((planWeeks.get(j).getWeek() - weekth + i * 7) * 24 * 60 * 60 * 1000l + date));
				each.setEndTime(planWeeks.get(j).getEndTime());
				each.setStartTime(planWeeks.get(j).getStartTime());
				plans.add(each);
			}
		}
		planMapper.addPlans(plans);
		clearCache();
	}

	public void addPlanAtClient(String json) throws Exception {
		int classId = readTreeAsInt(json, "classId");
		List<Plan> plans = jsonToList(readTree(json, "plans"), ArrayList.class, Plan.class);
		for (Plan plan : plans) {
			plan.setClassId(classId);
			plan.setCreateTime(new Date());
		}
		planMapper.addPlans(plans);
		clearCache();
	}

	public List<PlanByClass> getPlanByClass(int classId) throws Exception {
		return planMapper.getPlanByClass(classId);
	}

	public void updatePlans(List<Plan> plans) throws Exception {
		for (Plan p : plans) {
			planMapper.updatePlan(p);
		}
		clearCache();
	}

	public int deleteById(int id) throws Exception {
		Plan plan = planMapper.getPlanById(id);
		// 判断此节课上过没有
		if (DateUtil.parseDate(DateUtil.formatDate(plan.getDate(), DateUtil.normalDateFormat) + " " + plan.getStartTime(), DateUtil.normalTimeFormat).before(
				new Date())) {
			return 1;
		}
		// 判断有没有生成请假记录
		if (lackMapper.getLackByPlanId(id) != 0) {
			return 2;
		}
		// 判断有没有生成补课记录
		if (suppleMapper.getSuppleByPlanId(id) != 0) {
			return 3;
		}
		planMapper.deleteById(id);
		clearCache();
		return 0;
	}

	public List<MoreCourseList> getMoreCourseList(String userId,String institutionId, Page page) throws Exception {
		if("".equals(institutionId))
			institutionId = null;
		return planMapper.getMoreCourseList(userId,institutionId, page);
	}

	public void addPlanAtServerEasy(String plan) throws Exception {
		Integer classId = readTreeAsInt(plan, "classId");
		int weeks = readTreeAsInt(plan, "weeks");// 次数
		long date = readTreeAsLong(plan, "date");// 开始时间
		String startTime = readTree(plan, "startTime");
		String endTime = readTree(plan, "endTime");
		String address = readTree(plan, "address");
		String userId = readTree(plan, "userId");
		List<Plan> plans = new ArrayList<Plan>();
		for (int i = 0; i < weeks; i++) {
			Plan each = new Plan();
			each.setAddress(address);
			each.setClassId(classId);
			each.setUserId(userId);
			each.setCreateTime(new Date());
			each.setDate(new Date((i * 7) * 24 * 60 * 60 * 1000l + date));
			each.setEndTime(endTime);
			each.setStartTime(startTime);
			plans.add(each);
		}
		planMapper.addPlans(plans);
		clearCache();
	}
	
	public void clearCache() throws Exception {
		adminCourseMapper.clear();
		courseMapper.clear();
		classSignMapper.clear();
		gatherMapper.clear();
		lackMapper.clear();
		classMapper.clear();
		planSignMapper.clear();
		suppleMapper.clear();
	}

	public List<MoreCourseList> getCollectCourseList(String institutionId,
			Page page) throws Exception {
		return planMapper.getCollectCourseList(institutionId, page);
	}
}
