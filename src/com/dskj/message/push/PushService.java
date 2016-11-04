package com.dskj.message.push;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.push.model.v20150827.PushRequest;
import com.aliyuncs.push.model.v20150827.PushResponse;
import com.dskj.base.Base;
import com.dskj.message.Mapper.MessageMapper;
import com.dskj.message.entity.MessageConfig;
import com.dskj.message.entity.MyPushRequest;
import com.dskj.message.entity.MyPushResponse;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    private DefaultAcsClient client;

    @Override
    public void afterPropertiesSet() throws Exception {
        List<MessageConfig> messageConfigs = messageMapper.getPushConfig();
        if (messageConfigs == null)
            throw new Exception("Push config init fail.");
        for (MessageConfig config : messageConfigs) {
            pushConfigs.put(config.getKey(), config.getValue());
        }
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", pushConfigs.get("aliyun_push_accessid"), pushConfigs.get("aliyun_push_accesssecret"));
        client = new DefaultAcsClient(profile);
    }
//
//    private String buildUrl(MyPushRequest myPushRequest) throws Exception {
//        myPushRequest.setAccessKeyId(pushConfigs.get("aliyun_push_accessid"));
//        myPushRequest.setAppKey(Long.parseLong(pushConfigs.get("aliyun_push_appkey")));
//        Map<String, String> m = Java2Map.java2Map(myPushRequest);
//        String[] p = new String[m.size()];
//        int i = 0;
//        for (String key : m.keySet()) {
//            p[i] = key;
//            i++;
//        }
//        //a)
//        p = StringUtil.dictionarySort(p);
//
//        String url = "http://" + pushConfigs.get("aliyun_push_url") + "?";
//        StringBuffer sb = new StringBuffer();
//        // b) c) d)
//        for (int j = 0; j < p.length; j++) {
//            if (m.get(p[j]) != null && !"".equals(m.get(p[j])))
//                sb.append(URLCodeUtil.encode(p[j]) + "=" + URLCodeUtil.encode(m.get(p[j])) + "&");
//        }
//        String s = sb.toString();
//        sb.append("Signature=" + URLCodeUtil.encode(getSign(s.substring(0, s.length() - 1))));
//        return url + sb.toString();
//    }
//
//    private String getSign(String canonicalizedQueryString) throws Exception {
//        String stringToSign = "GET&" + URLCodeUtil.encode("/") + "&" + URLCodeUtil.encode(canonicalizedQueryString);
//        return Base64Helper.encode(HMACSHA1.HmacSHA1Encrypt(stringToSign, pushConfigs.get("aliyun_push_accesssecret") + "&"));
//    }

//    //rest api
//    public MyPushResponse push(MyPushRequest myPushRequest) throws Exception {
//        String s = buildUrl(myPushRequest);
//        String r = HttpUtil.get(s, null);
//        r = r.substring(1, r.length() - 1);
//        MyPushResponse myPushResponse = stringToObj(r, MyPushResponse.class);
//        return myPushResponse;
//    }

    //sdk
    public MyPushResponse getPushResponse(MyPushRequest myPushRequest) throws Exception {
        PushRequest pushRequest = new PushRequest();
        // 推送目标
        pushRequest.setAppKey(Long.valueOf(pushConfigs.get("aliyun_push_appkey")));
        pushRequest.setTarget(myPushRequest.getTarget()); //推送目标: device:推送给设备; account:推送给指定帐号,tag:推送给自定义标签; all: 推送给全部
        pushRequest.setTargetValue(myPushRequest.getTargetValue()); //根据Target来设定，如Target=device, 则对应的值为 设备id1,设备id2. 多个值使用逗号分隔.(帐号与设备有一次最多100个的限制)
        pushRequest.setDeviceType(myPushRequest.getDeviceType()); // 设备类型deviceType 取值范围为:0~3. iOS设备: 0; Android设备: 1; 全部: 3, 这是默认值.
        // 推送配置
        pushRequest.setType(myPushRequest.getType()); // 0:表示消息(默认为0), 1:表示通知
        pushRequest.setTitle(myPushRequest.getTitle()); // 消息的标题
        pushRequest.setBody(myPushRequest.getBody()); // 消息的内容
        pushRequest.setSummary(myPushRequest.getSummary()); // 通知的摘要
        // 推送配置: iOS
        pushRequest.setiOSBadge(myPushRequest.getiOSBadge()); // iOS应用图标右上角角标
        pushRequest.setiOSMusic(myPushRequest.getiOSMusic()); // iOS通知声音
        pushRequest.setiOSExtParameters(myPushRequest.getiOSExtParameters()); //自定义的kv结构,开发者扩展用 针对iOS设备
        pushRequest.setApnsEnv(myPushRequest.getApnsEnv());
        pushRequest.setRemind(myPushRequest.getRemind());
        // pushRequest.setRemind(true); // 当APP不在线时候，是否通过通知提醒
        // 推送配置: Android
        pushRequest.setAndroidOpenType(myPushRequest.getAndroidOpenType()); // 点击通知后动作,1:打开应用 2: 打开应用Activity 3:打开 url
        pushRequest.setAndroidOpenUrl(myPushRequest.getAndroidOpenUrl()); // Android收到推送后打开对应的url,仅仅当androidOpenType=3有效
        pushRequest.setAndroidExtParameters(myPushRequest.getAndroidExtParameters()); // 设定android类型设备通知的扩展属性
        pushRequest.setAndroidActivity(myPushRequest.getAndroidActivity());
        pushRequest.setXiaomiActivity(myPushRequest.getXiaomiActivity());
        pushRequest.setAndroidMusic(myPushRequest.getAndroidMusic());
        // 推送控制
//        final Date pushDate = new Date(System.currentTimeMillis() + 3600 * 1000); // 一小时后发送, 也可以设置成你指定固定时间
//        final String pushTime = ParameterHelper.getISO8601Time(pushDate);
        pushRequest.setPushTime(myPushRequest.getPushTime()); // 延后推送。可选，如果不设置表示立即推送
        pushRequest.setStoreOffline(myPushRequest.getStoreOffline()); // 离线消息是否保存,若保存, 在推送时候，用户即使不在线，下一次上线则会收到
//        final String expireTime = ParameterHelper.getISO8601Time(new Date(System.currentTimeMillis() + 12 * 3600 * 1000)); // 12小时后消息失效, 不会再发送
        pushRequest.setExpireTime(myPushRequest.getExpireTime());
        pushRequest.setBatchNumber(myPushRequest.getBatchNumber()); // 批次编号,用于活动效果统计. 设置成业务可以记录的字符串
        pushRequest.setTimeOut(myPushRequest.getTimeOut());
        pushRequest.setBatchNumber(myPushRequest.getBatchNumber());
        PushResponse pushResponse = null;
        try {
            pushResponse = client.getAcsResponse(pushRequest);
            logger.info("RequestId: " + pushResponse.getRequestId());
            logger.info("ResponseId: %s, message: %s: " + pushResponse.getRequestId() + "," + pushResponse.getMessage());
        } catch (Exception e) {
            logger.error(e);
        }
        return geMyPushResponse(pushResponse);
    }

    private MyPushResponse geMyPushResponse(PushResponse pushResponse) throws Exception {
        MyPushResponse myPushResponse = new MyPushResponse();
        myPushResponse.setMessage(pushResponse.getMessage());
        myPushResponse.setRequestId(pushResponse.getRequestId());
        myPushResponse.setResponseId(pushResponse.getResponseId());
        return myPushResponse;
    }
}
