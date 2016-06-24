package com.dskj.message.listener;

import com.dskj.message.mq.MqDs;

/**
 * Created by chenbo on 2016/4/1.
 */
public class MyListener implements Runnable {

    private MqDs mqDs;

    public MyListener(MqDs mqDs) {
        this.mqDs = mqDs;
    }

    public void run() {
        try{
            mqDs.send();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
