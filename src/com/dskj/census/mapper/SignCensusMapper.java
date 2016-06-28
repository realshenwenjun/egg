package com.dskj.census.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dskj.base.CacheBean;
import com.dskj.census.entity.SignCensusUserSignDetail;
import com.dskj.census.entity.SignCensusUserSignList;
import com.dskj.util.Page;

@Repository
public interface SignCensusMapper extends CacheBean{
	public List<SignCensusUserSignList> getSignCensusUserSignList(@Param("institutionId") String institutionId,@Param("startTime") Date startTime,@Param("endTime") Date endTime,@Param("page") Page page) throws Exception;
	public List<SignCensusUserSignDetail> getSignCensusUserSignDetail(@Param("institutionId") String institutionId,@Param("userId") String userId,@Param("startTime") Date startTime,@Param("endTime") Date endTime,@Param("page") Page page) throws Exception;
	
}
