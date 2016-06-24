package com.dskj.course.service;

import java.util.List;

import com.dskj.course.entity.ClassPlanLackList;
import com.dskj.course.entity.CourserClassTeacherList;
import com.dskj.course.entity.Lack;
import com.dskj.course.entity.ManageClassTeacherList;

public interface HolidayService {
	public void addLack(Lack lack) throws Exception;
	
	public List<CourserClassTeacherList> getCourseClassTeacherList(String userId,String institutionId) throws Exception;
	
	public List<ClassPlanLackList> getClassPlanLackList(String userId,int classId) throws Exception;
	
	public int deleteLack(int id) throws Exception;
	
	public List<ManageClassTeacherList> getManageClassTeacherList(String institutionId,String key) throws Exception;
}
