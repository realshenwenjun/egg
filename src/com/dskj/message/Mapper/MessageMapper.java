package com.dskj.message.Mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dskj.message.entity.MessageConfig;

@Repository
public interface MessageMapper {
	public List<MessageConfig> getConfig() throws Exception;
	
	public void addCommentMessage(String userId,int commentId,String parentUserId,int parentCommentId) throws Exception;
}
