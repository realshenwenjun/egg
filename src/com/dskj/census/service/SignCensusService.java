package com.dskj.census.service;

import java.util.Date;
import java.util.List;

import com.dskj.census.entity.SignCensusUserSignDetail;
import com.dskj.census.entity.SignCensusUserSignList;
import com.dskj.util.Page;

public interface SignCensusService {
	public List<SignCensusUserSignList> getSignCensusUserSignList(String institutionId,Date startTime,Date endTime,Page page) throws Exception;
	
	public List<SignCensusUserSignDetail> getSignCensusUserSignDetail(String institutionId,String userId,Date startTime,Date endTime,Page page) throws Exception;
}
