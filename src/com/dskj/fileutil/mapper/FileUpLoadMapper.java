package com.dskj.fileutil.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dskj.fileutil.entity.FileUploadConfig;

@Repository
public interface FileUpLoadMapper {
	public List<FileUploadConfig> getFileUploadConfig() throws Exception;
}
