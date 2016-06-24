package com.dskj.census.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dskj.base.Base;
import com.dskj.census.entity.DailyLiveCensusDateList;
import com.dskj.census.mapper.DailyLiveCensusMapper;

@Service
public class DailyLiveCensusServiceImpl extends Base implements
		DailyLiveCensusService {
	@Autowired
	private DailyLiveCensusMapper dailyLiveCensusMapper;

	public List<DailyLiveCensusDateList> getDailyLiveCensusDateList(Date date)
			throws Exception {
		List<DailyLiveCensusDateList> list = dailyLiveCensusMapper
				.getDailyLiveCensusDateList(date);
		for (DailyLiveCensusDateList dailyLiveCensusDateList : list) {
			dailyLiveCensusDateList.setCount(dailyLiveCensusMapper
					.getOneDailyLiveCensusDateList(dailyLiveCensusDateList
							.getDate()));
		}
		return list;
	}

	public List<DailyLiveCensusDateList> getDailyLiveCensusUserList(Date date)
			throws Exception {
		return dailyLiveCensusMapper.getDailyLiveCensusUserList(date);
	}
}
