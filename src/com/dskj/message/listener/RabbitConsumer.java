package com.dskj.message.listener;

import com.dskj.base.Base;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

/**
 * Created by ASUS on 2016/11/14.
 */
@Service
public class RabbitConsumer extends Base implements MessageListener {
    @Override
    public void onMessage(Message message) {
        try {
            logger.info("consumer" + message.toString());
            ByteArrayInputStream byteInt = new ByteArrayInputStream(message.getBody());

            ObjectInputStream objInt = new ObjectInputStream(byteInt);
            IRabbitHandle handle = (IRabbitHandle) objInt.readObject();
            handle.excute();
        } catch (Exception e) {
            logger.error(e);
        }
    }
}
