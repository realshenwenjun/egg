package com.dskj.message.mq;

import com.dskj.message.Mapper.MessageMapper;

/**
 * Created by chenbo on 2016/4/1.
 */
public interface MqDs {

    public String getName() throws Exception;

    public void setName(String name) throws Exception;

    public void setUrl(String url) throws Exception;

    public void setAppMasterSecret(String appMasterSecret) throws Exception;

    public void setAppkey(String appkey) throws Exception;

    public void put(Object o) throws Exception;

    public Object poll() throws Exception;

    public void send() throws Exception;

    public void setMessageMapper(MessageMapper messageMapper);
}
