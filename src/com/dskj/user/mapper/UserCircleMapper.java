package com.dskj.user.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dskj.base.CacheBean;
import com.dskj.user.entity.UserCircle;

@Repository
public interface UserCircleMapper extends CacheBean {

    public void add(UserCircle userCircle) throws Exception;

    public void delete(int id) throws Exception;

    public List<UserCircle> getList(String userId) throws Exception;
}
