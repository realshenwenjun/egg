package com.dskj.message.entity;

import com.dskj.util.DateUtil;

import java.beans.IntrospectionException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ASUS on 2016/9/15.
 */
public abstract class PushRequest {
    public String Format = "JSON";
    public String RegionId = "cn-hangzhou";
    public String Version = "2015-08-27";
    public String AccessKeyId;
    public String SignatureMethod = "HMAC-SHA1";
    public String SignatureVersion = "1.0";
    public String SignatureNonce = String.valueOf(System.currentTimeMillis());
    public String Timestamp = DateUtil.getIOS8601(new Date());

    public Map<String, String> getMap() throws IllegalAccessException, IntrospectionException, InvocationTargetException {
        return java2Map(this);
    }

    /**
     * JavaBean对象转化成Map对象
     *
     * @return
     * @author jqlin
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static Map java2Map(Object o) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        Map<String, Object> map = new HashMap<String, Object>();
        Field[] fields = null;
        fields = o.getClass().getFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String proName = field.getName();
            Object proValue = field.get(o);
            map.put(proName.toUpperCase(), proValue);
        }
        return map;
    }

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
}
