package com.dskj.message.push;

import com.dskj.message.Mapper.MessageMapper;
import com.dskj.message.entity.MessageConfig;
import com.dskj.util.DateUtil;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ASUS on 2016/9/13.
 */
@Service
public class PushService implements InitializingBean{
    @Autowired
    private MessageMapper messageMapper;

    private Map<String, String> pushConfigs = new HashMap<String, String>();

    @Override
    public void afterPropertiesSet() throws Exception {
        List<MessageConfig> messageConfigs = messageMapper.getPushConfig();
        if (messageConfigs == null)
            throw new Exception("Push config init fail.");
        for (MessageConfig config : messageConfigs) {
            pushConfigs.put(config.getKey(), config.getValue());
        }
    }
    private String buildUrl() throws Exception{
        StringBuffer sb = new StringBuffer("http://");
        sb.append(pushConfigs.get("aliyun_push_url")).append("?")
                .append("Format=JSON").append("&")
                .append("RegionId=cn-hangzhou").append("&")
                .append("Version=2015-08-27").append("&")
                .append("AccessKeyId=").append(pushConfigs.get("aliyun_push_appid")).append("&")
                .append("SignatureMethod=HMAC-SHA1").append("&")
                .append("SignatureVersion=1.0").append("&")
                .append("SignatureNonce=").append(System.currentTimeMillis()).append("&")
                .append("Timestamp=").append(DateUtil.getIOS8601(new Date())).append("&")
                .append("Signature=");
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new PushService().buildUrl());
    }
}
