package com.dskj.message.listener;

import com.dskj.base.Base;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Service;

/**
 * Created by ASUS on 2016/11/14.
 */
@Service
public class RabbitConsumer extends Base implements MessageListener {
    @Override
    public void onMessage(Message message) {
        logger.info("consumer" + message.toString());
    }
}
