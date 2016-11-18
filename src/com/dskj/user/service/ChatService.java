package com.dskj.user.service;

import com.dskj.user.entity.ChatUser;

public interface ChatService {
    public String getCheckAccessToken() throws Exception;

    public Object addUser(ChatUser chatUser) throws Exception;

    public boolean deleteUser(String username) throws Exception;
}
