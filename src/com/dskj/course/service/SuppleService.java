package com.dskj.course.service;

import java.util.List;

import com.dskj.course.entity.ClassPlanLackList;
import com.dskj.course.entity.CourserClassTeacherList;
import com.dskj.course.entity.Supple;
import com.dskj.course.entity.SuppleDetail;

public interface SuppleService {
	public void addSupple(Supple supple) throws Exception;
	
	public List<ClassPlanLackList> getClassPlanLackList(String userId,int classId) throws Exception;
	
	public List<ClassPlanLackList> getClassPlanOnlyLackList(String userId,int classId) throws Exception;
	
	public void addTeacherSupple(String jsonString) throws Exception;
	
	public SuppleDetail getSuppleDetail(int id) throws Exception;
	
	public List<CourserClassTeacherList> getSuppleClassList(int classId,int courseId) throws Exception;
}
