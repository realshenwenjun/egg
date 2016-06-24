package com.dskj.course.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dskj.base.CacheBean;
import com.dskj.course.entity.Course;
import com.dskj.course.entity.CourseVO;
import com.dskj.util.Page;

@Repository
public interface CourseMapper extends CacheBean{
	public void addCourse(Course course) throws Exception;

	public void updateCourse(Course course) throws Exception;

	public Course getCourse(int id) throws Exception;

	public void deleteCourse(int id) throws Exception;

	public List<Course> getByName(@Param("name") String name,@Param("institutionId") String institutionId) throws Exception;

	public List<CourseVO> getCourseListByTypeOf(@Param("institutionId") String institutionId,@Param("id") int id, @Param("page") Page page) throws Exception;

	public List<CourseVO> getCourseListByType(@Param("institutionId") String institutionId, @Param("type") int type, @Param("page") Page page) throws Exception;

	public List<CourseVO> getCourseListByInstitution(@Param("insId") String insId, @Param("page") Page page) throws Exception;
	
	public List<CourseVO> getCourseVOByName(@Param("name") String name) throws Exception;
	
}
