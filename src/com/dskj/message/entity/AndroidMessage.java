package com.dskj.message.entity;

import java.io.Serializable;

/**
 * Created by chenbo on 2016/4/22.
 */
public class AndroidMessage implements Serializable {
    private static final long serialVersionUID = 7275696549908091279L;

    private String appkey;
    private String timestamp;
    private String type;
    private String device_tokens;
    private String alias_type;
    private String alias;
    private String file_id;
    private AndroidPayLoad payload;
    private AndroidPolicy policy;
    private String production_mode;
    private String description;
    private String thirdparty_id;

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDevice_tokens() {
        return device_tokens;
    }

    public void setDevice_tokens(String device_tokens) {
        this.device_tokens = device_tokens;
    }

    public String getAlias_type() {
        return alias_type;
    }

    public void setAlias_type(String alias_type) {
        this.alias_type = alias_type;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getFile_id() {
        return file_id;
    }

    public void setFile_id(String file_id) {
        this.file_id = file_id;
    }

    public AndroidPayLoad getPayload() {
        return payload;
    }

    public void setPayload(AndroidPayLoad payload) {
        this.payload = payload;
    }

    public AndroidPolicy getPolicy() {
        return policy;
    }

    public void setPolicy(AndroidPolicy policy) {
        this.policy = policy;
    }

    public String getProduction_mode() {
        return production_mode;
    }

    public void setProduction_mode(String production_mode) {
        this.production_mode = production_mode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThirdparty_id() {
        return thirdparty_id;
    }

    public void setThirdparty_id(String thirdparty_id) {
        this.thirdparty_id = thirdparty_id;
    }
}
