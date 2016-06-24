package com.dskj.census.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dskj.base.Base;
import com.dskj.census.entity.TimingCensusUserSignDetail;
import com.dskj.census.entity.TimingCensusUserSignList;
import com.dskj.census.mapper.TimingCensusMapper;
import com.dskj.util.Page;

@Service
public class TimingCensusServiceImpl extends Base implements TimingCensusService {
	@Autowired
	private TimingCensusMapper timingCensusMapper;

	public List<TimingCensusUserSignList> getTimingCensusUserSignList(String institutionId, Date date, Page page) throws Exception {
		return timingCensusMapper.getTimingCensusUserSignList(institutionId, date, page);
	}

	public List<TimingCensusUserSignDetail> getTimingCensusUserSignDetail(String institutionId, String userId, Date startTime, Date endTime, Page page)
			throws Exception {
		return timingCensusMapper.getTimingCensusUserSignDetail(institutionId,userId, startTime, endTime, page);
	}

}
