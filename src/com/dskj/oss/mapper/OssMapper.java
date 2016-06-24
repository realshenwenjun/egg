package com.dskj.oss.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dskj.oss.entity.OssConfig;

@Repository
public interface OssMapper {
	public List<OssConfig> getOssConfig() throws Exception;
}
