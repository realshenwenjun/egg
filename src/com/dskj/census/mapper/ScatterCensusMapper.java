package com.dskj.census.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dskj.base.CacheBean;
import com.dskj.census.entity.ScatterCensusList;
import com.dskj.util.Page;

@Repository
public interface ScatterCensusMapper extends CacheBean{
	public List<ScatterCensusList> getScatterCensusCourseUserList(Page page) throws Exception;
	
	public List<ScatterCensusList> getScatterCensusInstitutionList(@Param("parentId") Integer parentId) throws Exception;
	
	public List<ScatterCensusList> getScatterCensusUserList(@Param("parentId") Integer parentId) throws Exception;
}
