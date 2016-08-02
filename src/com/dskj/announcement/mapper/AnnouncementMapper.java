package com.dskj.announcement.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dskj.announcement.entity.Announcement;
import com.dskj.announcement.entity.AnnouncementVO;
import com.dskj.base.CacheBean;
import com.dskj.util.Page;

@Repository
public interface AnnouncementMapper extends CacheBean{
	public void add(Announcement announcement) throws Exception;

	public void update(Announcement announcement) throws Exception;

	public void delete(List<Integer> ids) throws Exception;

	public Announcement get(Integer id) throws Exception;
	
	public List<AnnouncementVO> list(@Param("userId") String userId,@Param("page") Page page) throws Exception;
	
	public List<AnnouncementVO> listByTitle(@Param("userId") String userId, @Param("title") String title,@Param("page") Page page) throws Exception;
	
	public int getUserType(String userId) throws Exception;
	/*
	 * 查询没报班
	 */
	public int getCurrentInstitutionClassSignCount(String userId) throws Exception;
	/*
	 * 只返回平台公告
	 */
	public List<AnnouncementVO> sysList(@Param("userId") String userId,@Param("page") Page page) throws Exception;
	
	public int getAnnouncementCount() throws Exception;
	
	public List<Announcement> getPlatformsAnnouncementList(Page page) throws Exception;

	public int getAnnouncementAllCount(String userId) throws Exception;
	
	public int getAnnouncementReadedCount(String userId) throws Exception;

	public void deleteByInstitutionId(String institutionId) throws Exception;
	
}
