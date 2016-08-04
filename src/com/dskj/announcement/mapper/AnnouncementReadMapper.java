package com.dskj.announcement.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dskj.announcement.entity.AnnouncementRead;
import com.dskj.base.CacheBean;

@Repository
public interface AnnouncementReadMapper extends CacheBean{
	public void doRead(AnnouncementRead announcementRead) throws Exception;
	
	public void deleteRead(List<Integer> announcementIds) throws Exception;
	
	public AnnouncementRead getRead(AnnouncementRead announcementRead) throws Exception;

	public void deleteByInstitutionId(String institutionId) throws Exception;
	
}
