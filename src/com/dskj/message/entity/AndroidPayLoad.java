package com.dskj.message.entity;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by chenbo on 2016/4/22.
 */
public class AndroidPayLoad implements Serializable {
    private static final long serialVersionUID = 929914160887331571L;

    private String display_type;
    private AndroidBody body;
    private Map<String ,String > extra;

    public String getDisplay_type() {
        return display_type;
    }

    public void setDisplay_type(String display_type) {
        this.display_type = display_type;
    }

    public AndroidBody getBody() {
        return body;
    }

    public void setBody(AndroidBody body) {
        this.body = body;
    }

    public Map<String, String> getExtra() {
        return extra;
    }

    public void setExtra(Map<String, String> extra) {
        this.extra = extra;
    }
}
