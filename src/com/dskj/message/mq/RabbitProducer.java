package com.dskj.message.mq;

import com.dskj.base.Base;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ASUS on 2016/11/14.
 */
@Service("rabbitProducer")
public class RabbitProducer extends Base {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendDataToQueue(String queueKey, Object object) throws Exception {
        amqpTemplate.convertAndSend(queueKey, object);
    }
}
