package com.dskj.user.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dskj.user.entity.ChatConfigEntity;
import com.dskj.user.entity.ChatToken;

@Repository
public interface ChatMapper {
    public List<ChatConfigEntity> getChatConfig() throws Exception;

    public void updateToken(ChatToken chatToken) throws Exception;
}
