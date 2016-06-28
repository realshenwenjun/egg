package com.dskj.course.mapper;

import java.util.List;

import com.dskj.course.entity2_0.CourseClassType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dskj.base.CacheBean;
import com.dskj.course.entity.CourseType;
import com.dskj.course.entity.CourseTypeOf;
import com.dskj.course.entity2_0.CourseClassTypeOf;

@Repository
public interface AdminCourseMapper extends CacheBean{
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

	public List<CourseType> getCourseTypeList(@Param("ofId") Integer ofId) throws Exception;

	public CourseType getCourseTypeByName(String name) throws Exception;
	
	public List<CourseClassTypeOf> getCourseClassType() throws Exception;

	public CourseClassType getCourseTypeSearch2_0(@Param("key") String key) throws Exception;
}
