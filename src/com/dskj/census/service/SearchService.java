package com.dskj.census.service;

import java.util.List;

import com.dskj.census.entity.SearchResult;
import com.dskj.util.Page;


public interface SearchService {
	
	public List<SearchResult> getSearch(String key,Integer type,String userId,Page page) throws Exception;
}
