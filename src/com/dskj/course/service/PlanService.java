package com.dskj.course.service;

import java.util.List;

import com.dskj.course.entity.MoreCourseList;
import com.dskj.course.entity.Plan;
import com.dskj.course.entity.PlanByClass;
import com.dskj.util.Page;

public interface PlanService {
	public void addPlanAtServer(String plan) throws Exception;
	
	public void addPlanAtClient(String json) throws Exception;
	
	public void updatePlans(List<Plan> plans) throws Exception;
	
	public List<PlanByClass> getPlanByClass(int classId) throws Exception;
	
	public int deleteById(int id) throws Exception;
	
	public List<MoreCourseList> getMoreCourseList(String userId,String institutionId,Page page) throws Exception;
	
	public void addPlanAtServerEasy(String plan) throws Exception;
	
	public List<MoreCourseList> getCollectCourseList(String institutionId,Page page) throws Exception;
}
