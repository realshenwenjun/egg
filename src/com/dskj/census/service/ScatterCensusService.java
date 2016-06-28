package com.dskj.census.service;

import java.util.List;

import com.dskj.census.entity.ScatterCensusList;
import com.dskj.util.Page;

public interface ScatterCensusService {
	public List<ScatterCensusList> getScatterCensusCourseUserList(Page page) throws Exception;
	
	public List<ScatterCensusList> getScatterCensusInstitutionList(Integer parentId) throws Exception;
	
	public List<ScatterCensusList> getScatterCensusUserList(Integer parentId) throws Exception;
}
