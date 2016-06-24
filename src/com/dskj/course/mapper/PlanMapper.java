package com.dskj.course.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dskj.base.CacheBean;
import com.dskj.course.entity.MoreCourseList;
import com.dskj.course.entity.Plan;
import com.dskj.course.entity.PlanByClass;
import com.dskj.util.Page;

@Repository
public interface PlanMapper extends CacheBean{
	public void addPlans(List<Plan> plans) throws Exception;
	
	public void updatePlan(Plan plan) throws Exception;

	public List<PlanByClass> getPlanByClass(int classId) throws Exception;

	public void deletePlanByCourse(int id) throws Exception;

	public void deletePlanByClass(int id) throws Exception;
	
	public void deleteById(int id) throws Exception;
	
	public void addPlan(Plan plan) throws Exception;
	
	public Plan getPlanById(int id) throws Exception;
	
	public List<MoreCourseList> getMoreCourseList(@Param("userId") String userId,@Param("institutionId") String institutionId,@Param("page") Page page) throws Exception;
	
	public List<MoreCourseList> getCollectCourseList(@Param("institutionId") String institutionId,@Param("page") Page page) throws Exception;
	
}
