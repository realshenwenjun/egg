package com.dskj.message.entity;

import com.dskj.util.DateUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ASUS on 2016/9/15.
 */
public abstract class PushRequest implements Serializable{
    public String Format = "JSON";
    public String RegionId = "cn-hangzhou";
    public String Version = "2015-08-27";
    public String AccessKeyId;
    public String AppKey;
    public String SignatureMethod = "HMAC-SHA1";
    public String SignatureVersion = "1.0";
    public String SignatureNonce = String.valueOf(System.currentTimeMillis());
    public String Timestamp = DateUtil.getIOS8601(new Date());


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

    public String getAppKey() {
        return AppKey;
    }

    public void setAppKey(String appKey) {
        AppKey = appKey;
    }
}
