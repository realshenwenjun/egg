package com.dskj.course.mapper;

import java.util.Date;
import java.util.List;

import com.dskj.course.entity2_0.ClassSignList;
import com.dskj.course.entity2_0.CourseClassStudent;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dskj.base.CacheBean;
import com.dskj.course.entity.ClassSign;
import com.dskj.course.entity.ClassSignUser;
import com.dskj.course.entity.CourseVO;
import com.dskj.course.entity.CourserClassTeacherList;
import com.dskj.course.entity2_0.CourseClassSign;
import com.dskj.util.Page;

@Repository
public interface ClassSignMapper extends CacheBean{
	public void addClassSign(List<ClassSign> classSigns) throws Exception;

	public void deleteClassSignByCourse(int id) throws Exception;

	public void deleteClassSignByClass(int id) throws Exception;

	public void deleteClassSign(String userId,int classId) throws Exception;

	public List<ClassSignUser> getUsersFromClass(int id) throws Exception;

	public List<CourseVO> getCourseListByUser(String userId) throws Exception;

	public List<ClassSignUser> getUnSignUsersByName(String name, int classId) throws Exception;
	
	public List<ClassSignUser> getMyUsersByName(String userName,String institutionId) throws Exception;
	
	public List<CourserClassTeacherList> getCourseClassTeacherList(String userId,String institutionId) throws Exception;
	
	public int getClassSignByUserIdAndClassId(String userId,int classId) throws Exception;

	public int getClassSignOrderByUserIdAndClassId(String userId,int classId) throws Exception;
	
	public List<Integer> getStudentClass(@Param("userId") String userId,@Param("page") Page page) throws Exception;
	
	public int getClassStudentCount(int classId) throws Exception;
	
	public void addClassSign2_0(CourseClassSign courseClassSign) throws Exception;

	public List<ClassSignList> getStudentClassSign(String userId,Date date) throws Exception;
	
	public List<CourseClassStudent> getCourseClassManageStudentList2_0(Integer classId) throws Exception;
	
	public List<CourseClassStudent> getCourseClassManageStudentSearch2_0(@Param("classId") Integer classId,@Param("key") String key) throws Exception;
	
	public List<CourseClassStudent> getCourseClassManageNotStudentSearch2_0(@Param("classId") Integer classId,@Param("key") String key,@Param("page") Page page) throws Exception;
	
	public List<ClassSignUser> getCourseTeacherStudentList2_0(@Param("userId") String userId,@Param("key") String key) throws Exception;
	
	public List<CourseClassSign> getCourseClassOrderManageList2_0(String institutionId,Date date) throws Exception;
	
}
