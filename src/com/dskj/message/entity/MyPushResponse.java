package com.dskj.message.entity;

import java.io.Serializable;

/**
 * Created by ASUS on 2016/11/4.
 */
public class MyPushResponse implements Serializable {
    private String requestId;
    private String responseId;
    private String message;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getResponseId() {
        return responseId;
    }

    public void setResponseId(String responseId) {
        this.responseId = responseId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
