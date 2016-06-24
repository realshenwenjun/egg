package com.dskj.course.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dskj.base.CacheBean;
import com.dskj.course.entity.WorkTime;

@Repository
public interface WorkTimeMapper extends CacheBean{
	public void addWorkTimes(List<WorkTime> workTimes) throws Exception;
	
	public List<WorkTime> getWorkTimes(String institutionId,int year,int month) throws Exception;
	
	public void updateWorkTime(WorkTime workTimes) throws Exception;
}
