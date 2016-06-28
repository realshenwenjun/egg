package com.dskj.census.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dskj.base.Base;
import com.dskj.census.entity.SearchResult;
import com.dskj.census.mapper.SearchMapper;
import com.dskj.util.Page;

@Service
public class SearchServiceImpl extends Base implements SearchService{
	@Autowired
	private SearchMapper searchMapper;

	public List<SearchResult> getSearch(String key,Integer type, String userId, Page page)
			throws Exception {
		if(type == 1)
			return searchMapper.getInstitutionSearch(key, userId, page);
		else if(type == 2)
			return searchMapper.getClassSearch(key, userId, page);
		else if(type == 3)
			return searchMapper.getActivitySearch(key, userId, page);
		return searchMapper.getSearch(key, userId, page);
	}

}
