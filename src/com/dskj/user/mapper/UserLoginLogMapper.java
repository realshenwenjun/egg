package com.dskj.user.mapper;

import org.springframework.stereotype.Repository;

import com.dskj.base.CacheBean;
import com.dskj.user.entity.UserLoginLog;

@Repository
public interface UserLoginLogMapper extends CacheBean {
    public void add(UserLoginLog userLoginLog) throws Exception;

    //查看用户总共登录多少天
    public int getUserLoginDay(String userId) throws Exception;
}
