package com.dskj.census.service;

import java.util.Date;
import java.util.List;

import com.dskj.census.entity.DailyLiveCensusDateList;

public interface DailyLiveCensusService {
	public List<DailyLiveCensusDateList> getDailyLiveCensusDateList(Date date) throws Exception;
	
	public List<DailyLiveCensusDateList> getDailyLiveCensusUserList(Date date) throws Exception;

}
