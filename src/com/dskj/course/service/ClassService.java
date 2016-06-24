package com.dskj.course.service;

import java.util.List;

import com.dskj.course.entity.Clazz;
import com.dskj.course.entity.CourserClassTeacherList;
import com.dskj.course.entity.ManageCourseCount;
import com.dskj.course.entity.PassClass;
import com.dskj.util.Page;

public interface ClassService {
	public void addClass(Clazz clazz) throws Exception;

	public void updateClass(Clazz clazz) throws Exception;

	public int deleteClass(int id) throws Exception;

	public List<ManageCourseCount> getManageCourseCount(int courseTypeId, String institutionId) throws Exception;

	public List<Clazz> getClassByCourse(int courseId) throws Exception;

	public List<Clazz> getByName(String name, int courseId, String institutionId) throws Exception;
	
	public List<CourserClassTeacherList> getClassByCourseId(int courseId)
			throws Exception;
	
	public List<PassClass> getPassClass(int courseId,Page page) throws Exception;
}
