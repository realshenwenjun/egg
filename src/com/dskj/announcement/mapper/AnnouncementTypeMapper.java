package com.dskj.announcement.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dskj.announcement.entity.AnnouncementType;
import com.dskj.base.CacheBean;

@Repository
public interface AnnouncementTypeMapper extends CacheBean{
	public void addType(AnnouncementType announcementType) throws Exception;

	public void updateType(AnnouncementType announcementType) throws Exception;

	public void deleteTye(AnnouncementType announcementType) throws Exception;

	public AnnouncementType getType(Integer id) throws Exception;
	
	public List<AnnouncementType> listType() throws Exception;
}
