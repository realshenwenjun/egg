package com.dskj.census.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dskj.base.Base;
import com.dskj.census.entity.ScatterCensusList;
import com.dskj.census.mapper.ScatterCensusMapper;
import com.dskj.util.Page;

@Service
public class ScatterCensusServiceImpl extends Base implements ScatterCensusService{
	@Autowired
	private ScatterCensusMapper courseScatterCensusMapper;
	
	public List<ScatterCensusList> getScatterCensusCourseUserList(Page page) throws Exception {
		return courseScatterCensusMapper.getScatterCensusCourseUserList(page);
	}

	public List<ScatterCensusList> getScatterCensusInstitutionList(Integer parentId) throws Exception {
		if("".equals(parentId) || parentId == 0)
			parentId = null;
		return courseScatterCensusMapper.getScatterCensusInstitutionList(parentId);
	}

	public List<ScatterCensusList> getScatterCensusUserList(Integer parentId) throws Exception {
		if("".equals(parentId) || parentId == 0)
			parentId = null;
		return courseScatterCensusMapper.getScatterCensusUserList(parentId);
	}

}
