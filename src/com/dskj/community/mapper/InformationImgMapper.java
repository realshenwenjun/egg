package com.dskj.community.mapper;

import com.dskj.base.CacheBean;
import com.dskj.community.entity.Information;
import com.dskj.community.entity.InformationImg;
import com.dskj.util.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InformationImgMapper extends CacheBean {

	public void add(@Param("informationImgs") List<InformationImg> informationImgs) throws Exception;

	public void delete(int infoId) throws Exception;
}
