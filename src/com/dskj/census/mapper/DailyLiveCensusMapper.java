package com.dskj.census.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dskj.base.CacheBean;
import com.dskj.census.entity.DailyLiveCensusDateList;

@Repository
public interface DailyLiveCensusMapper extends CacheBean {
	public List<DailyLiveCensusDateList> getDailyLiveCensusDateList(
			@Param("date") Date date) throws Exception;

	public int getOneDailyLiveCensusDateList(@Param("date") String date)
			throws Exception;

	public List<DailyLiveCensusDateList> getDailyLiveCensusUserList(
			@Param("date") Date date) throws Exception;

}
