package com.dskj.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dskj.base.Base;
import com.dskj.course.entity.WorkTime;
import com.dskj.course.mapper.WorkTimeMapper;
@Service
public class WorkTimeServiceImpl extends Base implements WorkTimeService {
	@Autowired
	private WorkTimeMapper workTimeMapper;

	public void addWorkTimes(List<WorkTime> workTimes) throws Exception {
		workTimeMapper.addWorkTimes(workTimes);
	}

	public List<WorkTime> getWorkTimes(String institutionId,int year, int month)
			throws Exception {
		return workTimeMapper.getWorkTimes(institutionId,year, month);
	}

	public void updateWorkTimes(List<WorkTime> workTimes) throws Exception {
		for (WorkTime time : workTimes) {
			workTimeMapper.updateWorkTime(time);
		}
	}
}
