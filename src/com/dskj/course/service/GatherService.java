package com.dskj.course.service;

import java.util.List;

import com.dskj.course.entity.ManageClassUserCountDate;
import com.dskj.course.entity.ManageCourseClassCount;
import com.dskj.course.entity.UserGatherCourseClassPlan;

public interface GatherService {
	public List<UserGatherCourseClassPlan> getGatherCourseClassPlans(String userId) throws Exception;
	
	public List<UserGatherCourseClassPlan> getTeacherGatherCourseClassPlans(String userId) throws Exception;
	
	public List<ManageCourseClassCount> getManageCourseClassCount(String institutionId) throws Exception;
	
	public List<ManageClassUserCountDate> getManageClassUserCountDate(int courseId) throws Exception;
}
