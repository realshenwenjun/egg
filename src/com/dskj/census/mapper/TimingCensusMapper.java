package com.dskj.census.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dskj.base.CacheBean;
import com.dskj.census.entity.TimingCensusUserSignDetail;
import com.dskj.census.entity.TimingCensusUserSignList;
import com.dskj.util.Page;

@Repository
public interface TimingCensusMapper extends CacheBean{
	
	public List<TimingCensusUserSignList> getTimingCensusUserSignList(@Param("institutionId") String institutionId,@Param("date") Date date,@Param("page") Page page) throws Exception;
	
	public List<TimingCensusUserSignDetail> getTimingCensusUserSignDetail(@Param("institutionId") String institutionId, @Param("userId") String userId,@Param("startTime") Date startTime,@Param("endTime") Date endTime,@Param("page") Page page) throws Exception;
}
