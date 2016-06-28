package com.dskj.census.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dskj.base.Base;
import com.dskj.census.entity.SignCensusUserSignDetail;
import com.dskj.census.entity.SignCensusUserSignList;
import com.dskj.census.mapper.SignCensusMapper;
import com.dskj.util.Page;

@Service
public class SignCensusServiceImpl extends Base implements SignCensusService{
	@Autowired
	private SignCensusMapper signCensusMapper;

	public List<SignCensusUserSignList> getSignCensusUserSignList(String institutionId, Date startTime, Date endTime, Page page) throws Exception {
		return signCensusMapper.getSignCensusUserSignList(institutionId, startTime, endTime, page);
	}

	public List<SignCensusUserSignDetail> getSignCensusUserSignDetail(String institutionId, String userId, Date startTime, Date endTime, Page page)
			throws Exception {
		return signCensusMapper.getSignCensusUserSignDetail(institutionId, userId, startTime, endTime, page);
	}

}
