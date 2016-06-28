package com.dskj.spread.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dskj.base.CacheBean;
import com.dskj.spread.entity.Propagate;
import com.dskj.util.Page;

@Repository
public interface PropaMapper extends CacheBean{
	
	public void add(Propagate propagate) throws Exception;
	
	public void update(Propagate propagate) throws Exception;
	
	public List<Propagate> getList(@Param("institutionId") String institutionId,@Param("page") Page page) throws Exception;
	
	public void deleteById(int id) throws Exception;
	
	public Propagate get(int id) throws Exception;

}
