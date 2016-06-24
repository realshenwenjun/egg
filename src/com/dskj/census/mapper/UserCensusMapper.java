package com.dskj.census.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dskj.base.CacheBean;
import com.dskj.census.entity.UserCensusByChildInstitution;
import com.dskj.census.entity.UserCensusByCourseType;

@Repository
public interface UserCensusMapper extends CacheBean{
	
	List<Integer> getCourseTypeList(String institution) throws Exception;
	
	UserCensusByCourseType getUserCensusByOneCourseType(String institution, int courseTypeId) throws Exception;
	
	
	UserCensusByCourseType getUserCensusOther(String institution) throws Exception;
	
	List<UserCensusByChildInstitution> getUserCensusByChildInstitution(String institution) throws Exception;
}
