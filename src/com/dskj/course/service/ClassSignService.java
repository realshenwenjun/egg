package com.dskj.course.service;

import java.util.List;

import com.dskj.course.entity.ClassSignUser;
import com.dskj.course.entity.CourseVO;

public interface ClassSignService {
	public void addUserToClass(String json) throws Exception;
	
	public void deleteClassSign(String userId,int classId) throws Exception;
	
	public List<ClassSignUser> getUsersFromClass(int id) throws Exception;
	
	public List<CourseVO> getCourseListByUser(String userId) throws Exception;
	
	public List<ClassSignUser> getUnSignUsersByName(String name,int classId) throws Exception;
	
	public List<ClassSignUser> getMyUsersByName(String userName,String institutionId) throws Exception;
	
}
