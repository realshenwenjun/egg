package com.dskj.user.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dskj.base.CacheBean;
import com.dskj.user.entity.UserFans;
import com.dskj.user.entity2_0.MyFans;

@Repository
public interface UserFansMapper extends CacheBean {

    public void add(UserFans userFans) throws Exception;

    public int getBeenUserFans(String beenUserId) throws Exception;

    public Integer getUserFansId(String userId, String beenUserId) throws Exception;

    public void delete(Integer id) throws Exception;
    
    public List<MyFans> getUserFansList2_0(String userId) throws Exception;
}
