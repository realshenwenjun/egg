package com.dskj.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dskj.base.Base;
import com.dskj.course.entity.CourseType;
import com.dskj.course.entity.CourseTypeOf;
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
public class AdminCourseServiceImpl extends Base implements AdminCourseService {
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

	public CourseTypeOf getCourseTypeOf(int id) throws Exception {
		return adminCourseMapper.getCourseTypeOf(id);
	}

	public void addCourseTypeOf(CourseTypeOf courseTypeOf) throws Exception {
		adminCourseMapper.addCourseTypeOf(courseTypeOf);
		clearCache();
	}

	public void updateCourseTypeOf(CourseTypeOf courseTypeOf) throws Exception {
		adminCourseMapper.updateCourseTypeOf(courseTypeOf);
		clearCache();
	}

	public void deleteCourseTypeOf(int id) throws Exception {
		adminCourseMapper.deleteCourseTypeOf(id);
		clearCache();
	}

	public List<CourseTypeOf> getCourseTypeOfList() throws Exception {
		return adminCourseMapper.getCourseTypeOfList();
	}

	public CourseType getCourseType(int id) throws Exception {
		return adminCourseMapper.getCourseType(id);
	}

	public void addCourseType(CourseType courseType) throws Exception {
		adminCourseMapper.addCourseType(courseType);
		clearCache();
	}

	public void updateCourseType(CourseType courseType) throws Exception {
		adminCourseMapper.updateCourseType(courseType);
		clearCache();
	}

	public void deleteCourseType(int id) throws Exception {
		adminCourseMapper.deleteCourseType(id);
		clearCache();
	}

	public List<CourseType> getCourseTypeList(Integer ofId) throws Exception {
		return adminCourseMapper.getCourseTypeList(ofId);
	}

	public CourseTypeOf getCourseTypeOfByName(String name) throws Exception {
		return adminCourseMapper.getCourseTypeOfByName(name);
	}

	public CourseType getCourseTypeByName(String name) throws Exception {
		return adminCourseMapper.getCourseTypeByName(name);
	}

	public void clearCache() throws Exception {
		classMapper.clear();
		courseMapper.clear();
		classSignMapper.clear();
		gatherMapper.clear();
		lackMapper.clear();
		planMapper.clear();
		planSignMapper.clear();
		suppleMapper.clear();
	}
}
