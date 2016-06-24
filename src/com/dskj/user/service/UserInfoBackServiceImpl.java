package com.dskj.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dskj.user.entity.UserInfoBack;
import com.dskj.user.mapper.UserInfoBackMapper;
import com.dskj.util.Page;

@Service
public class UserInfoBackServiceImpl implements UserInfoBackService {
    @Autowired
    private UserInfoBackMapper userInfoBackMapper;

    public void add(UserInfoBack userInfoBack) throws Exception {
        userInfoBackMapper.add(userInfoBack);
    }

    public List<UserInfoBack> getList(Page page) throws Exception {
        return userInfoBackMapper.list(page);
    }

    public int getInfoBackCount() throws Exception {
		return userInfoBackMapper.getInfoBackCount();
	}
}
