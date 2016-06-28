package com.dskj.course.service;

import java.util.List;

import com.dskj.course.entity.WorkTime;

public interface WorkTimeService {
	public void addWorkTimes(List<WorkTime> workTimes) throws Exception;
	
	public List<WorkTime> getWorkTimes(String institutionId,int year,int month) throws Exception;
	
	public void updateWorkTimes(List<WorkTime> workTimes) throws Exception;
}
