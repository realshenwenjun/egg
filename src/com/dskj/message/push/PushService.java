package com.dskj.message.push;

import com.aliyuncs.utils.Base64Helper;
import com.dskj.base.Base;
import com.dskj.message.Mapper.MessageMapper;
import com.dskj.message.entity.MessageConfig;
import com.dskj.message.entity.PushNoticeToAndroid;
import com.dskj.message.entity.PushRequest;
import com.dskj.util.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ASUS on 2016/9/13.
 */
@Service
public class PushService extends Base implements InitializingBean {
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

    private String buildUrl(PushRequest pushRequest) throws Exception {
        pushRequest.setAccessKeyId(pushConfigs.get("aliyun_push_accessid"));
        pushRequest.setAppKey(pushConfigs.get("aliyun_push_appkey"));
        Map<String, String> m = Java2Map.java2Map(pushRequest);
        String[] p = new String[m.size()];
        int i = 0;
        for (String key : m.keySet()) {
            p[i] = key;
            i++;
        }
        //a)
        p = StringUtil.dictionarySort(p);

        String url = "http://" + pushConfigs.get("aliyun_push_url") + "?";
        StringBuffer sb = new StringBuffer();
        // b) c) d)
        for (int j = 0; j < p.length; j++) {
            if (m.get(p[j]) != null && !"".equals(m.get(p[j])))
                sb.append(URLCodeUtil.encode(p[j]) + "=" + URLCodeUtil.encode(m.get(p[j])) + "&");
        }
        String s = sb.toString();
        sb.append("Signature=" + URLCodeUtil.encode(getSign(s.substring(0, s.length() - 1))));
        return url + sb.toString();
    }

    private String getSign(String canonicalizedQueryString) throws Exception {
        String stringToSign = "GET&" + URLCodeUtil.encode("/") + "&" + URLCodeUtil.encode(canonicalizedQueryString);
        return Base64Helper.encode(HMACSHA1.HmacSHA1Encrypt(stringToSign, pushConfigs.get("aliyun_push_accesssecret") + "&"));
    }

    public String push(PushRequest pushRequest) throws Exception {
        String s = buildUrl(pushRequest);
        return HttpUtil.get(s, null);
    }
}
