package com.dskj.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dskj.base.Base;
import com.dskj.course.entity.ManageClassUserCountDate;
import com.dskj.course.entity.ManageCourseClassCount;
import com.dskj.course.entity.UserGatherCourseClassPlan;
import com.dskj.course.mapper.GatherMapper;

@Service
public class GatherServiceImpl extends Base implements GatherService {
	@Autowired
	private GatherMapper gatherMapper;

	public List<UserGatherCourseClassPlan> getGatherCourseClassPlans(String userId) throws Exception {
		return gatherMapper.getGatherCourseClassPlans(userId);
	}

	public List<UserGatherCourseClassPlan> getTeacherGatherCourseClassPlans(String userId) throws Exception {
		return gatherMapper.getTeacherGatherCourseClassPlans(userId);
	}

	public List<ManageCourseClassCount> getManageCourseClassCount(String institutionId) throws Exception {
		return gatherMapper.getManageCourseClassCount(institutionId);
	}

	public List<ManageClassUserCountDate> getManageClassUserCountDate(int courseId) throws Exception {
		return gatherMapper.getManageClassUserCountDate(courseId);
	}
}
