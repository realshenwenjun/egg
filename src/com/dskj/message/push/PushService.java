package com.dskj.message.push;

import com.aliyuncs.utils.Base64Helper;
import com.dskj.base.Base;
import com.dskj.message.Mapper.MessageMapper;
import com.dskj.message.entity.MessageConfig;
import com.dskj.message.entity.PushNoticeToAndroid;
import com.dskj.util.HMACSHA1;
import com.dskj.util.HttpUtil;
import com.dskj.util.Java2Map;
import com.dskj.util.StringUtil;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
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

    private String buildUrl(PushNoticeToAndroid pushRequest) throws Exception {
        ((PushNoticeToAndroid) pushRequest).setAccessKeyId(pushConfigs.get("aliyun_push_accessid"));
        ((PushNoticeToAndroid) pushRequest).setAppKey(pushConfigs.get("aliyun_push_appkey"));
        Map<String, String> m = Java2Map.java2Map(pushRequest);
        String[] p = new String[m.size()];
        int i = 0;
        for (String key : m.keySet()) {
            p[i] = key;
            i++;
        }
        //排序
        p = StringUtil.dictionarySort(p);

        String url = "http://" + pushConfigs.get("aliyun_push_url") + "?";
        StringBuffer sb = new StringBuffer();
        // 对每个请求参数的名称和值进行编码,对编码后的参数名称和值使用英文等号（=）进行连接
        for (int j = 0; j < p.length; j++) {
            if (m.get(p[j]) != null && !"".equals(m.get(p[j])))
                sb.append(URLEncoder.encode(p[j], "UTF-8") + "=" + URLEncoder.encode(m.get(p[j]), "UTF-8") + "&");
        }
        String s = sb.toString();
        logger.info(s.substring(0, s.length() - 1));
        sb.append("Signature=" + URLEncoder.encode(getSign(s.substring(0, s.length() - 1)), "UTF-8"));
        return url + sb.toString();
    }

    public static void main(String[] args) throws Exception {
        PushNoticeToAndroid pushNoticeToAndroid = new PushNoticeToAndroid();
        pushNoticeToAndroid.setAction("PushNoticeToAndroid");
        pushNoticeToAndroid.setAndroidExtParameters("23267207");
        pushNoticeToAndroid.setTarget("all");
        pushNoticeToAndroid.setTargetValue("all");
        pushNoticeToAndroid.setTitle("测试");
        pushNoticeToAndroid.setSummary("sssssss");
        pushNoticeToAndroid.setAccessKeyId("1111111111");
        System.out.println(new PushService().buildUrl(pushNoticeToAndroid));
    }

    private String getSign(String canonicalizedQueryString) throws Exception {
        String stringToSign = "GET&" + URLEncoder.encode("/", "UTF-8") + "&" + canonicalizedQueryString.replaceAll("=","%3D").replace("&","%26");
        logger.info("stringToSign: " + stringToSign);
        logger.info(HMACSHA1.getSignature(stringToSign, pushConfigs.get("aliyun_push_appsecret") + "&"));
        return Base64Helper.encode(HMACSHA1.getSignature(stringToSign, pushConfigs.get("aliyun_push_appsecret") + "&").getBytes());
    }

    public String push(PushNoticeToAndroid pushRequest) throws Exception {
        String s = buildUrl(pushRequest);
        logger.info(s);
        return HttpUtil.get(s, null);
    }
}
