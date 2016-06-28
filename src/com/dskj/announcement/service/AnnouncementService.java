package com.dskj.announcement.service;

import java.util.List;

import com.dskj.announcement.entity.Announcement;
import com.dskj.announcement.entity.AnnouncementRead;
import com.dskj.announcement.entity.AnnouncementType;
import com.dskj.announcement.entity.AnnouncementVO;
import com.dskj.util.Page;

public interface AnnouncementService {
	public void add(Announcement announcement) throws Exception;

	public void update(Announcement announcement) throws Exception;

	public void delete(List<Integer> ids) throws Exception;

	public Announcement get(Integer id) throws Exception;
	
	public void addType(AnnouncementType announcementType) throws Exception;

	public void updateType(AnnouncementType announcementType) throws Exception;

	public void deleteTye(AnnouncementType announcementType) throws Exception;

	public AnnouncementType getType(Integer id) throws Exception;
	
	public List<AnnouncementType> listType() throws Exception;
	
	public AnnouncementRead getRead(AnnouncementRead announcementRead) throws Exception;
	
	public void addRead(AnnouncementRead announcementRead) throws Exception;
	
	public List<AnnouncementVO> getList(String userId,Page page) throws Exception;
	
	public List<AnnouncementVO> getListByTitle(String userId, String title,Page page) throws Exception;
	
	public int getAnnouncementCount() throws Exception;
	
	public List<Announcement> getPlatformsAnnouncementList(Page page) throws Exception;
	
	public Announcement getAnnouncement(int announcementId) throws Exception;

	public int getAnnouncementNewCount(String userId) throws Exception;
	
}
