package com.dskj.message.entity;

import java.io.Serializable;

/**
 * Created by ASUS on 2016/9/14.
 */
public class PushNoticeToAndroid extends PushRequest implements Serializable {
    private String Action;
    private String AppKey;
    private String Target;
    private String TargetValue;
    private String Title;//发送的通知标题,最长20个字符，中文算1个字符
    private String Summary;
    private String AndroidExtParameters;//自定义的KV结构，供开发者扩展使用，针对Android设备。(目前android通知的提醒方式的设置在该参数里面:”_NOTIFY_TYPE_=1\2\3”,1：振动，2：声音，3:声音和振动)(注意 : 该参数要以json map的格式传入,否则会解析出错)

    public String getAction() {
        return Action;
    }

    public void setAction(String action) {
        Action = action;
    }

    public String getAppKey() {
        return AppKey;
    }

    public void setAppKey(String appKey) {
        AppKey = appKey;
    }

    public String getTarget() {
        return Target;
    }

    public void setTarget(String target) {
        Target = target;
    }

    public String getTargetValue() {
        return TargetValue;
    }

    public void setTargetValue(String targetValue) {
        TargetValue = targetValue;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getSummary() {
        return Summary;
    }

    public void setSummary(String summary) {
        Summary = summary;
    }

    public String getAndroidExtParameters() {
        return AndroidExtParameters;
    }

    public void setAndroidExtParameters(String androidExtParameters) {
        AndroidExtParameters = androidExtParameters;
    }
}
