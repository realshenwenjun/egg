package com.dskj.census.service;

import java.util.List;

import com.dskj.census.entity.UserCensusByChildInstitution;
import com.dskj.census.entity.UserCensusByCourseType;

public interface UserCensusService {
	List<UserCensusByCourseType> getUserCensusByCourseType(String institution) throws Exception;
	
	List<UserCensusByChildInstitution> getUserCensusByChildInstitution(String institution) throws Exception;
}
