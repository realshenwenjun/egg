package com.dskj.user.service;

import java.util.List;

import com.dskj.user.entity.UserInfoBack;
import com.dskj.util.Page;

public interface UserInfoBackService {

    public void add(UserInfoBack userInfoBack) throws Exception;

    public List<UserInfoBack> getList(Page page) throws Exception;
    
    public int getInfoBackCount() throws Exception;
}
