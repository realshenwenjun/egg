package com.dskj.census.service;

import java.util.Date;
import java.util.List;

import com.dskj.census.entity.TimingCensusUserSignDetail;
import com.dskj.census.entity.TimingCensusUserSignList;
import com.dskj.util.Page;

public interface TimingCensusService {
	public List<TimingCensusUserSignList> getTimingCensusUserSignList(String institutionId, Date date, Page page) throws Exception;

	public List<TimingCensusUserSignDetail> getTimingCensusUserSignDetail(String institutionId, String userId, Date startTime, Date endTime, Page page)
			throws Exception;
}
