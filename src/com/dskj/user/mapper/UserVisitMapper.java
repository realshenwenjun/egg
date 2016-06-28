package com.dskj.user.mapper;

import com.dskj.base.CacheBean;
import com.dskj.user.entity.UserVisit;
import org.springframework.stereotype.Repository;

@Repository
public interface UserVisitMapper extends CacheBean {

    public void add(UserVisit userVisit) throws Exception;

    public int getUserVisitCount(String userId, String beenUserId) throws Exception;
}
