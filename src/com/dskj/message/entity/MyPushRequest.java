package com.dskj.message.entity;

import com.dskj.util.DateUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ASUS on 2016/9/15.
 */
public class MyPushRequest implements Serializable {
    /*************************************************************公共参数***************************************/
    private String Format = "JSON";
    private String RegionId = "cn-hangzhou";
    private String Version = "2015-08-27";
    private String AccessKeyId;
    private String SignatureMethod = "HMAC-SHA1";
    private String SignatureVersion = "1.0";
    private String SignatureNonce = String.valueOf(System.currentTimeMillis());
    private String Timestamp = DateUtil.getIOS8601(new Date());
    /********************************************************基础参数*********************************************/
    private Long AppKey;
    private String Action;

    /*****************************************************推送目标************************************************/
    /*
        device：推送给设备
    account：推送给指定帐号
    alias：推送给指定别名
    tag：推送给指定Tag
    all：推送给全部设备
     */
    private String Target;
    /*
    根据Target来设定，多个值使用逗号分隔，最多支持100个。

    Target=device，值如deviceid111,deviceid1111
    Target=account，值如account111,account222
    Target=alias，值如alias111,alias222
    Target=tag，支持单Tag和多Tag，格式请参考标签格式
    Target=all，值为all
     */
    private String TargetValue;
    /*
    设备类型，取值范围为：

    0：iOS设备
    1：Andriod设备
    3：全部类型设备
     */
    private Integer DeviceType;
    /******************************************推送配置***********************************/
    /*
     0：表示消息，默认值
     1：表示通知
     */
    private Integer Type;
    /*
    Android消息标题,Android通知标题,iOS消息标题，最长20个字符，中文为1个字符
     */
    private String Title;
    /*
    Android消息内容,Android通知内容,iOS消息内容
     */
    private String Body;
    /*
    iOS通知内容
     */
    private String Summary;

    /********************************************下述配置仅作用于iOS通知任务*****************************************/
    private String iOSMusic;
    private String iOSBadge;
    private String iOSTitle;
    private String iOSSubtitle;
    private Boolean iOSMutableContent;
    private String iOSNotificationCategory;
    private String iOSExtParameters;
    private String ApnsEnv;
    /************************************************下述配置仅作用于iOS消息*************************************************************/
    private Boolean Remind;
    /***********************************************下述配置仅作用于Android通知任务**************************************/

    private String AndroidMusic;
    private String AndroidOpenType;
    private String AndroidActivity;
    private String XiaomiActivity;
    private String AndroidOpenUrl;
    private String AndroidExtParameters;
    /*********************************************推送控制(push control)***********************************************************/
    private String PushTime;
    private Boolean StoreOffline;
    private String ExpireTime;
    /**********************************************推送跟踪(trace)**************************************************/
    private String BatchNumber;
    /****************************************************************************************************************/
    private Integer timeOut;

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }

    public String getRegionId() {
        return RegionId;
    }

    public void setRegionId(String regionId) {
        RegionId = regionId;
    }

    public String getVersion() {
        return Version;
    }

    public void setVersion(String version) {
        Version = version;
    }

    public String getAccessKeyId() {
        return AccessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        AccessKeyId = accessKeyId;
    }

    public String getSignatureMethod() {
        return SignatureMethod;
    }

    public void setSignatureMethod(String signatureMethod) {
        SignatureMethod = signatureMethod;
    }

    public String getSignatureVersion() {
        return SignatureVersion;
    }

    public void setSignatureVersion(String signatureVersion) {
        SignatureVersion = signatureVersion;
    }

    public String getSignatureNonce() {
        return SignatureNonce;
    }

    public void setSignatureNonce(String signatureNonce) {
        SignatureNonce = signatureNonce;
    }

    public String getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(String timestamp) {
        Timestamp = timestamp;
    }

    public Long getAppKey() {
        return AppKey;
    }

    public void setAppKey(Long appKey) {
        AppKey = appKey;
    }

    public String getAction() {
        return Action;
    }

    public void setAction(String action) {
        Action = action;
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

    public Integer getDeviceType() {
        return DeviceType;
    }

    public void setDeviceType(Integer deviceType) {
        DeviceType = deviceType;
    }

    public Integer getType() {
        return Type;
    }

    public void setType(Integer type) {
        Type = type;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getBody() {
        return Body;
    }

    public void setBody(String body) {
        Body = body;
    }

    public String getSummary() {
        return Summary;
    }

    public void setSummary(String summary) {
        Summary = summary;
    }

    public String getiOSMusic() {
        return iOSMusic;
    }

    public void setiOSMusic(String iOSMusic) {
        this.iOSMusic = iOSMusic;
    }

    public String getiOSBadge() {
        return iOSBadge;
    }

    public void setiOSBadge(String iOSBadge) {
        this.iOSBadge = iOSBadge;
    }

    public String getiOSTitle() {
        return iOSTitle;
    }

    public void setiOSTitle(String iOSTitle) {
        this.iOSTitle = iOSTitle;
    }

    public String getiOSSubtitle() {
        return iOSSubtitle;
    }

    public void setiOSSubtitle(String iOSSubtitle) {
        this.iOSSubtitle = iOSSubtitle;
    }

    public Boolean getiOSMutableContent() {
        return iOSMutableContent;
    }

    public void setiOSMutableContent(Boolean iOSMutableContent) {
        this.iOSMutableContent = iOSMutableContent;
    }

    public String getiOSNotificationCategory() {
        return iOSNotificationCategory;
    }

    public void setiOSNotificationCategory(String iOSNotificationCategory) {
        this.iOSNotificationCategory = iOSNotificationCategory;
    }

    public String getiOSExtParameters() {
        return iOSExtParameters;
    }

    public void setiOSExtParameters(String iOSExtParameters) {
        this.iOSExtParameters = iOSExtParameters;
    }

    public String getApnsEnv() {
        return ApnsEnv;
    }

    public void setApnsEnv(String apnsEnv) {
        ApnsEnv = apnsEnv;
    }

    public Boolean getRemind() {
        return Remind;
    }

    public void setRemind(Boolean remind) {
        Remind = remind;
    }

    public String getAndroidMusic() {
        return AndroidMusic;
    }

    public void setAndroidMusic(String androidMusic) {
        AndroidMusic = androidMusic;
    }

    public String getAndroidOpenType() {
        return AndroidOpenType;
    }

    public void setAndroidOpenType(String androidOpenType) {
        AndroidOpenType = androidOpenType;
    }

    public String getAndroidActivity() {
        return AndroidActivity;
    }

    public void setAndroidActivity(String androidActivity) {
        AndroidActivity = androidActivity;
    }

    public String getXiaomiActivity() {
        return XiaomiActivity;
    }

    public void setXiaomiActivity(String xiaomiActivity) {
        XiaomiActivity = xiaomiActivity;
    }

    public String getAndroidOpenUrl() {
        return AndroidOpenUrl;
    }

    public void setAndroidOpenUrl(String androidOpenUrl) {
        AndroidOpenUrl = androidOpenUrl;
    }

    public String getAndroidExtParameters() {
        return AndroidExtParameters;
    }

    public void setAndroidExtParameters(String androidExtParameters) {
        AndroidExtParameters = androidExtParameters;
    }

    public String getPushTime() {
        return PushTime;
    }

    public void setPushTime(String pushTime) {
        PushTime = pushTime;
    }

    public Boolean getStoreOffline() {
        return StoreOffline;
    }

    public void setStoreOffline(Boolean storeOffline) {
        StoreOffline = storeOffline;
    }

    public String getExpireTime() {
        return ExpireTime;
    }

    public void setExpireTime(String expireTime) {
        ExpireTime = expireTime;
    }

    public String getBatchNumber() {
        return BatchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        BatchNumber = batchNumber;
    }

    public Integer getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Integer timeOut) {
        this.timeOut = timeOut;
    }
}
