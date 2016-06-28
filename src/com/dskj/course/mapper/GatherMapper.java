package com.dskj.course.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dskj.base.CacheBean;
import com.dskj.course.entity.ManageClassUserCountDate;
import com.dskj.course.entity.ManageCourseClassCount;
import com.dskj.course.entity.UserGatherCourseClassPlan;

@Repository
public interface GatherMapper extends CacheBean{
	public List<UserGatherCourseClassPlan> getGatherCourseClassPlans(String userId) throws Exception;

	public List<UserGatherCourseClassPlan> getTeacherGatherCourseClassPlans(String userId) throws Exception;
	
	public List<ManageCourseClassCount> getManageCourseClassCount(String institutionId) throws Exception;
	
	public List<ManageClassUserCountDate> getManageClassUserCountDate(int courseId) throws Exception;
}
