package com.dskj.community.mapper;

import com.dskj.base.CacheBean;
import com.dskj.community.entity.InformationLove;
import org.springframework.stereotype.Repository;

@Repository
public interface InformationLoveMapper extends CacheBean {

	public void add(InformationLove informationLove) throws Exception;

	public void delete(int infoId,String userId) throws Exception;
}

