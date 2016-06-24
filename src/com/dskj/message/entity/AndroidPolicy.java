package com.dskj.message.entity;

import java.io.Serializable;

/**
 * Created by chenbo on 2016/4/22.
 */
public class AndroidPolicy implements Serializable {
    private static final long serialVersionUID = -7887931688440486922L;

    private String start_time;
    private String expire_time;
    private String max_send_num;
    private String out_biz_no;

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getExpire_time() {
        return expire_time;
    }

    public void setExpire_time(String expire_time) {
        this.expire_time = expire_time;
    }

    public String getMax_send_num() {
        return max_send_num;
    }

    public void setMax_send_num(String max_send_num) {
        this.max_send_num = max_send_num;
    }

    public String getOut_biz_no() {
        return out_biz_no;
    }

    public void setOut_biz_no(String out_biz_no) {
        this.out_biz_no = out_biz_no;
    }
}
