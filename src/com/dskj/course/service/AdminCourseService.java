package com.dskj.course.service;

import java.util.List;

import com.dskj.course.entity.CourseType;
import com.dskj.course.entity.CourseTypeOf;

public interface AdminCourseService {
	public CourseTypeOf getCourseTypeOf(int id) throws Exception;
	
	public void addCourseTypeOf(CourseTypeOf courseTypeOf) throws Exception;
	
	public void updateCourseTypeOf(CourseTypeOf courseTypeOf) throws Exception;
	
	public void deleteCourseTypeOf(int id) throws Exception;
	
	public List<CourseTypeOf> getCourseTypeOfList() throws Exception;
	
	public CourseTypeOf getCourseTypeOfByName(String name) throws Exception;
	
	public CourseType getCourseType(int id) throws Exception;
	
	public void addCourseType(CourseType courseType) throws Exception;
	
	public void updateCourseType(CourseType courseType) throws Exception;
	
	public void deleteCourseType(int id) throws Exception;
	
	public List<CourseType> getCourseTypeList(Integer ofId) throws Exception;
	
	public CourseType getCourseTypeByName(String name) throws Exception;
}
