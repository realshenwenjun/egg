package com.dskj.message.listener;

import java.io.Serializable;

/**
 * Created by ASUS on 2016/11/14.
 */
public interface IRabbitHandle extends Serializable {

    public void excute() throws Exception;
}
