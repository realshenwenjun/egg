package com.dskj.course.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dskj.base.CacheBean;
import com.dskj.course.entity.ClassPlanLackList;
import com.dskj.course.entity.CourserClassTeacherList;
import com.dskj.course.entity.Supple;
import com.dskj.course.entity.SuppleDetail;

@Repository
public interface SuppleMapper extends CacheBean{
	public void addSupple(Supple supple) throws Exception;
	
	public void deleteSuppleByClass(int classId) throws Exception;
	
	public void deleteSuppleByPlan(int planId) throws Exception;
	
	public List<ClassPlanLackList> getClassPlanLackList(String userId,int classId) throws Exception;
	
	public int getSuppleByPlanId(int planId) throws Exception;
	
	public SuppleDetail getSuppleDetail(int id) throws Exception;
	
	public Supple getByPlanAndUser(int planId,String userId) throws Exception;
	
	public void deleteById(int id) throws Exception;
	
	public List<CourserClassTeacherList> getSuppleClassList(int classId,int courseId) throws Exception;
}
