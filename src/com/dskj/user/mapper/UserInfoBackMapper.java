package com.dskj.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dskj.user.entity.UserInfoBack;
import com.dskj.util.Page;

@Repository
public interface UserInfoBackMapper {

    public void add(UserInfoBack userInfoBack) throws Exception;

    public List<UserInfoBack> list(@Param("page") Page page) throws Exception;
    
    public int getInfoBackCount() throws Exception;
}
