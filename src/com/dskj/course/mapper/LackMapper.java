package com.dskj.course.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dskj.base.CacheBean;
import com.dskj.course.entity.ClassPlanLackList;
import com.dskj.course.entity.Lack;

@Repository
public interface LackMapper extends CacheBean{
	public void addLack(Lack lack) throws Exception;

	public List<ClassPlanLackList> getClassPlanLackList(String userId,int classId) throws Exception;
	
	public void deleteLack(int id) throws Exception;
	
	public void deleteByClass(int classId) throws Exception;
	
	public void deleteByPlan(int id) throws Exception;
	
	public List<ClassPlanLackList> getClassPlanOnlyLackList(String userId,int classId) throws Exception;
	
	public int getLackByPlanId(int planId) throws Exception;
	
	public Lack getById(int id) throws Exception;
}
