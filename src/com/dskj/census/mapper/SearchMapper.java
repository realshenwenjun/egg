package com.dskj.census.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dskj.base.CacheBean;
import com.dskj.census.entity.SearchResult;
import com.dskj.util.Page;

@Repository
public interface SearchMapper extends CacheBean {
	
	public List<SearchResult> getSearch(@Param("key") String key,@Param("userId") String userId,@Param("page") Page page ) throws Exception;
	
	public List<SearchResult> getClassSearch(@Param("key") String key,@Param("userId") String userId,@Param("page") Page page ) throws Exception;
	
	public List<SearchResult> getInstitutionSearch(@Param("key") String key,@Param("userId") String userId,@Param("page") Page page ) throws Exception;
	
	public List<SearchResult> getActivitySearch(@Param("key") String key,@Param("userId") String userId,@Param("page") Page page ) throws Exception;
}
