package com.dskj.announcement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dskj.announcement.entity.Announcement;
import com.dskj.announcement.entity.AnnouncementRead;
import com.dskj.announcement.entity.AnnouncementType;
import com.dskj.announcement.entity.AnnouncementVO;
import com.dskj.announcement.mapper.AnnouncementMapper;
import com.dskj.announcement.mapper.AnnouncementReadMapper;
import com.dskj.announcement.mapper.AnnouncementTypeMapper;
import com.dskj.base.Base;
import com.dskj.util.Page;

@Service
public class AnnouncementServiceImpl extends Base implements
		AnnouncementService {
	@Autowired
	private AnnouncementMapper announcementMapper;
	@Autowired
	private AnnouncementTypeMapper announcementTypeMapper;
	@Autowired
	private AnnouncementReadMapper announcementReadMapper;

	public void add(Announcement announcement) throws Exception {
		announcementMapper.add(announcement);
	}

	public void update(Announcement announcement) throws Exception {
		announcementMapper.update(announcement);
	}

	public void delete(List<Integer> ids) throws Exception {
		announcementReadMapper.deleteRead(ids);
		announcementMapper.delete(ids);
	}

	public Announcement get(Integer id) throws Exception {
		return announcementMapper.get(id);
	}

	public void addType(AnnouncementType announcementType) throws Exception {
		announcementTypeMapper.addType(announcementType);
	}

	public void updateType(AnnouncementType announcementType) throws Exception {
		announcementTypeMapper.updateType(announcementType);
	}

	public void deleteTye(AnnouncementType announcementType) throws Exception {
		announcementTypeMapper.deleteTye(announcementType);
	}

	public AnnouncementType getType(Integer id) throws Exception {
		return announcementTypeMapper.getType(id);
	}

	public List<AnnouncementType> listType() throws Exception {
		return announcementTypeMapper.listType();
	}

	public void addRead(AnnouncementRead announcementRead) throws Exception {
		announcementReadMapper.doRead(announcementRead);
		announcementMapper.clear();// 更新缓存
	}

	public AnnouncementRead getRead(AnnouncementRead announcementRead)
			throws Exception {
		return announcementReadMapper.getRead(announcementRead);
	}

	public List<AnnouncementVO> getList(String userId, Page page)
			throws Exception {
		Integer type = announcementMapper.getUserType(userId);
		if (type == null)
			return new ArrayList<AnnouncementVO>();
		else if (type == 0 || type == 1)
			return announcementMapper.list(userId, page);
		if (type == 3 && announcementMapper.getCurrentInstitutionClassSignCount(userId) == 0)
			return announcementMapper.sysList(userId, page);
		return announcementMapper.list(userId, page);
	}

	public List<AnnouncementVO> getListByTitle(String userId, String title,
			Page page) throws Exception {
		return announcementMapper.listByTitle(userId, title, page);
	}

	public int getAnnouncementCount() throws Exception {
		return announcementMapper.getAnnouncementCount();
	}

	public List<Announcement> getPlatformsAnnouncementList(Page page)
			throws Exception {
		return announcementMapper.getPlatformsAnnouncementList(page);
	}

	public Announcement getAnnouncement(int announcementId) throws Exception {
		return announcementMapper.get(announcementId);
	}

	public int getAnnouncementNewCount(String userId) throws Exception {
		return announcementMapper.getAnnouncementAllCount(userId) - announcementMapper.getAnnouncementReadedCount(userId);
	}

}
