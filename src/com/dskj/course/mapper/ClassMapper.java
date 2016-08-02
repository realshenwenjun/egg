package com.dskj.course.mapper;

import java.util.Date;
import java.util.List;

import com.dskj.course.entity2_0.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dskj.base.CacheBean;
import com.dskj.course.entity.Clazz;
import com.dskj.course.entity.CourserClassTeacherList;
import com.dskj.course.entity.ManageClassTeacherList;
import com.dskj.course.entity.ManageCourseCount;
import com.dskj.course.entity.PassClass;
import com.dskj.util.Page;

@Repository
public interface ClassMapper extends CacheBean{

	public void addClass(Clazz clazz) throws Exception;

	public void updateClass(Clazz clazz) throws Exception;

	public void deleteClass(int id) throws Exception;

	public List<Clazz> getClassByCourse(int courseId)
			throws Exception;
	public List<ManageCourseCount> getManageCourseCount(int courseTypeId,String institutionId) throws Exception;
	
	public void deleteClassByCourse(int id) throws Exception;
	
	public List<ManageClassTeacherList> getCourseClassTeacherList(String institutionId,String key) throws Exception;
	
	public List<Clazz> getByName(String name,int courseId,String institutionId) throws Exception;
	
	public List<CourserClassTeacherList> getClassByCourseId(int courseId)
			throws Exception;
	
	public List<PassClass> getPassClass(@Param("courseId") int courseId,@Param("page") Page page) throws Exception;
	
	public void addCourseClass2_0(CourseClass courseClass) throws Exception;
	
	public void addCourseClassImg2_0(@Param("urls") List<CourseClassImg> urls) throws Exception;
	
	public CourseClassDetail getCourseClassDetail2_0(int classId) throws Exception;
	
	public void deleteCourseClass2_0(int classId) throws Exception;
	
	public void deleteCourseClassImg2_0(int classId) throws Exception;
	
	public List<CourseClassList> getCourseClassList2_0(@Param("institutionId") String institutionId,@Param("date") Date date,@Param("page") Page page) throws Exception;
	
	public List<CourseClassList> getCourseClassTeacherList2_0(@Param("userId") String userId,@Param("page") Page page) throws Exception;
	
	public List<CourseClassList> getCourseClassStudentList2_0(@Param("classIds") List<Integer> classIds) throws Exception;
	
	public CourseClassInfo getCourseClassInfo(int classId) throws Exception;
	
	public List<CourseClassList> getCourseClassListByType2_0(@Param("regionId") Integer regionId, @Param("courseId") int courseId,@Param("page") Page page) throws Exception;
	
	public List<CourseClassManageList> getCourseClassManageList2_0(String userId,Date date) throws Exception;

	public List<TeacherClassPlan> getCourseClassTeacherPlanList2_0(String userId,Date date) throws Exception;

	public void deleteByInstitutionId(String institutionId) throws Exception;
	
}
