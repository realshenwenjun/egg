package com.dskj.course.service;

import java.util.Date;
import java.util.List;

import com.dskj.course.entity.Clazz;
import com.dskj.course.entity.Course;
import com.dskj.course.entity.CourseVO;
import com.dskj.course.entity.PlanSign;
import com.dskj.course.entity2_0.ClassFans;
import com.dskj.course.entity2_0.ClassLove;
import com.dskj.course.entity2_0.CourseClass;
import com.dskj.course.entity2_0.CourseClassDetail;
import com.dskj.course.entity2_0.CourseClassInfo;
import com.dskj.course.entity2_0.CourseClassList;
import com.dskj.course.entity2_0.CourseClassSign;
import com.dskj.course.entity2_0.CourseClassType;
import com.dskj.course.entity2_0.CourseClassTypeOf;
import com.dskj.util.Page;

public interface CourseService {
	public void addCourse(Course course) throws Exception;
	
	public void updateCourse(Course course) throws Exception;
	
	public Course getCourse(int id) throws Exception;
	
	public void deleteCourse(int id) throws Exception;
	
	public List<Course> getByName(String name,String institutionId) throws Exception;
	
	public List<CourseVO> getCourseListByTypeOf(String institutionId,int id ,Page page) throws Exception;
	
	public List<CourseVO> getCourseListByType(String institutionId,int type, Page page) throws Exception;
	
	public List<CourseVO> getCourseListByInstitution(String insId, Page page) throws Exception;
	
	public List<Clazz> getClassByCourse(int courseId) throws Exception;
	
	public List<CourseVO> getCourseVOByName(String name) throws Exception;
	
	public void addCourseClass2_0(CourseClass courseClass,List<String> imgUrls) throws Exception;
	
	public CourseClassDetail getCourseClassDetail2_0(int classId) throws Exception;
	
	public void updateCourseClass2_0(CourseClass courseClass,List<String> imgUrls) throws Exception;
	
	public void deleteCourseClass2_0(int classId) throws Exception;
	
	public List<CourseClassList> getCourseClassList2_0(String institutionId,Date date,Page page) throws Exception;
	
	public List<CourseClassList> getCourseClassTeacherList2_0(String userId,Page page) throws Exception;
	
	public List<CourseClassList> getCourseClassStudentList2_0(String userId,Page page) throws Exception;
	
	public CourseClassInfo getCourseClassInfo(int classId,String userId) throws Exception;
	
	public void addClassComment(int classId,String userId,String context) throws Exception;
	
	public void deleteClassComment(int classId,int commentId) throws Exception;
	
	public Object getCourseClassCommentList(int classId,String userId,Page page) throws Exception;
	
	public void addClassLove(ClassLove classLove) throws Exception;
	
	public void deleteClassLove(int loveId) throws Exception;
	
	public void addClassFans(ClassFans classFans) throws Exception;
	
	public void deleteClassFans(int fansId) throws Exception;
	
	public void addCourseClassSign2_0(CourseClassSign courseClassSign) throws Exception;
	
	public List<CourseClassTypeOf> getCourseClassType() throws Exception;
	
	public List<CourseClassList> getCourseClassListByType2_0(Integer regionId, int courseId,Page page) throws Exception;
	
	public CourseClassType getCourseTypeSearch2_0(String key) throws Exception;

	public Object getCourseClassSignList2_0(String userId,Date date) throws Exception;

	public void addCourseClassPlanSign2_0(PlanSign planSign) throws Exception;
	
	public Object getCourseClassManageList2_0(String userId,Date date) throws Exception;
	
	public Object getCourseClassManageStudentList2_0(Integer classId) throws Exception;
	
	public Object getCourseClassManageStudentSearch2_0(Integer classId,String key) throws Exception;
	
	public Object getCourseClassManageNotStudentSearch2_0(Integer classId,String key,Page page) throws Exception;
	
	public void addCourseClassManageStudent(Integer classId,List<String> userId) throws Exception;
	
	public void deleteCourseClassManageStudent(Integer classId,List<String> userId) throws Exception;

	public Object getCourseClassTeacherPlanList2_0(String userId,Date date) throws Exception;
	
	public Object getCourseTeacherStudentList2_0(String userId,String key) throws Exception;
	
	public Object getCourseClassSignInfo2_0(String userId,Date date) throws Exception;
	
	public Object getCourseClassStudentSignList2_0(Integer classId,Date date) throws Exception;
	
	public Object getCourseClassStudentUnSignList2_0(Integer classId,Date date) throws Exception;
	
	public Object getCourseClassOrderManageList2_0(String institutionId,Date date) throws Exception;
}
