package com.dskj.user.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dskj.base.Base;
import com.dskj.user.entity.ChatConfigEntity;
import com.dskj.user.entity.ChatToken;
import com.dskj.user.entity.ChatUser;
import com.dskj.user.mapper.ChatMapper;
import com.dskj.util.HttpUtil;
import com.google.gson.JsonObject;

@Service
public class ChatServiceImpl extends Base implements InitializingBean, ChatService {
    @Autowired
    private ChatMapper chatMapper;
    private Map<String, String> chatConfigs = new HashMap<String, String>();

    public void afterPropertiesSet() throws Exception {
        List<ChatConfigEntity> list = chatMapper.getChatConfig();
        for (ChatConfigEntity config : list) {
            chatConfigs.put(config.getKey(), config.getValue());
        }
        if (!Boolean.valueOf(chatConfigs.get("chat_open")))
            return;// 如果没有开启聊天室功能则直接返回
        logger.info("chat client init success.");
        getCheckAccessToken();
    }

    public String getCheckAccessToken() throws Exception {
        if ((System.currentTimeMillis() + 5 * 60 * 1000) > Long.valueOf(chatConfigs.get("chat_expires_in"))) {
            JsonObject json = new JsonObject();
            json.addProperty("grant_type", "client_credentials");
            json.addProperty("client_id", chatConfigs.get("chat_client_id"));
            json.addProperty("client_secret", chatConfigs.get("chat_client_secret"));
            Map<String, String> headers = new HashMap<String, String>();
            headers.put("Content-Type", "application/json");
            String jsonString = HttpUtil.post(chatConfigs.get("chat_domain") + "/" + chatConfigs.get("chat_org_name") + "/" + chatConfigs.get("chat_app_name")
                    + "/token", json.toString(), headers);
            ChatToken token = stringToObj(jsonString, ChatToken.class);
            token.setExpires_in(String.valueOf(Long.valueOf(token.getExpires_in()) * 1000 + System.currentTimeMillis()));
            chatMapper.updateToken(token);
            chatConfigs.put("chat_expires_in", token.getExpires_in());
            chatConfigs.put("chat_access_token", token.getAccess_token());
            logger.info("chat access_token refreshed.");
        }
        return chatConfigs.get("chat_access_token");
    }

    /**
     * 在这个app下创建一个新的用户,授权注册
     */
    public Object addUser(ChatUser chatUser) throws Exception {
        if (!Boolean.valueOf(chatConfigs.get("chat_open")))
            return "该功能未启用";
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "Bearer " + getCheckAccessToken());
        String result = HttpUtil.post(chatConfigs.get("chat_domain") + "/" + chatConfigs.get("chat_org_name") + "/" + chatConfigs.get("chat_app_name")
                + "/users", objToString(chatUser), headers);
        logger.info(result);
        try {
            String error = readTree(result, "error");
            if (error == null || "".equals(error))
                return chatUser;
            else
                return null;
        } catch (Exception e) {
            return chatUser;
        }
    }

    /**
     * 查看某个IM用户的好友信息
     */
    public Object getContactsUsers(String json) throws Exception {
        if (!Boolean.valueOf(chatConfigs.get("chat_open")))
            return "该功能未启用";
        ChatUser user = stringToObj(json, ChatUser.class);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "Bearer " + getCheckAccessToken());
        String result = HttpUtil.get(chatConfigs.get("chat_domain") + "/" + chatConfigs.get("chat_org_name") + "/" + chatConfigs.get("chat_app_name")
                + "/users/" + user.getUsername() + "/contacts/users", headers);
        logger.info(result);
        String data = readTree(result, "data");
        List<String> list = stringToObj(data, ArrayList.class);
        return list;
    }
}
