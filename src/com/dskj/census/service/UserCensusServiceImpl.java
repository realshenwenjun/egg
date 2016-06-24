package com.dskj.census.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dskj.base.Base;
import com.dskj.census.entity.UserCensusByChildInstitution;
import com.dskj.census.entity.UserCensusByCourseType;
import com.dskj.census.mapper.UserCensusMapper;

@Service
public class UserCensusServiceImpl extends Base implements UserCensusService {
	@Autowired
	private UserCensusMapper userCensusMapper;

	public List<UserCensusByCourseType> getUserCensusByCourseType(String institution) throws Exception {
		List<Integer> courseTypeList = userCensusMapper.getCourseTypeList(institution);

		List<UserCensusByCourseType> list = new ArrayList<UserCensusByCourseType>();
		for (Integer i : courseTypeList) {
			UserCensusByCourseType userCensusByCourseType = userCensusMapper.getUserCensusByOneCourseType(institution, i);
			list.add(userCensusByCourseType);
		}
		UserCensusByCourseType other = userCensusMapper.getUserCensusOther(institution);
		list.add(other);
		return list;
	}

	public List<UserCensusByChildInstitution> getUserCensusByChildInstitution(String institution) throws Exception {
		return userCensusMapper.getUserCensusByChildInstitution(institution);
	}

}
