package com.dskj.message.push;

import com.dskj.message.Mapper.MessageMapper;
import com.dskj.message.entity.MessageConfig;
import com.dskj.message.entity.PushNoticeToAndroid;
import com.dskj.message.entity.PushRequest;
import com.dskj.util.HMACSHA1;
import com.dskj.util.HttpUtil;
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
public class PushService implements InitializingBean {
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
        Map<String, String> m = pushRequest.getMap();
        String[] p = new String[m.size()];
        int i = 0;
        for (String key : m.keySet()) {
            p[i] = key + "=" + m.get(key);
            i++;
        }
        StringUtil.dictionarySort(p);//排序
        String url = "http://" + pushConfigs.get("aliyun_push_url") + "?";
        StringBuffer sb = new StringBuffer();
        for (int j = 0; j < p.length; j++) {
            sb.append(p[j]).append("&");
        }
        String param = URLEncoder.encode(sb.toString(), "UTF-8");
        param = param.replaceAll("%3D", "=").replaceAll("%26", "&");
        sb.append("Signature=" + getSign(param));
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
        String stringToSign = "GET&" + URLEncoder.encode("/", "UTF-8") + "&" + URLEncoder.encode(canonicalizedQueryString, "UTF-8");
        return Base64.encodeBase64String(HMACSHA1.getSignature(stringToSign, pushConfigs.get("aliyun_push_appsecret")).getBytes());
    }

    public String push(PushRequest pushRequest) throws Exception {
        return HttpUtil.get(buildUrl(pushRequest), null);
    }
}
