package com.dskj.message.controll;

import com.dskj.base.Base;
import com.dskj.message.entity.MyPushRequest;
import com.dskj.message.entity.MyPushResponse;
import com.dskj.message.mq.RabbitProducer;
import com.dskj.message.push.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MessageControll extends Base {
    @Autowired
    private PushService pushService;
    @Autowired
    private RabbitProducer rabbitProducer;

    /*
     * 发送消息和通知 message={"ticker":"","title":"","text":"","after_open":"","custom":"","display_type":"","type":"","device_tokens":"","alias_type":"","alias":"","description":"","expire_time":""}
     */
    @RequestMapping("/message/send")
    public void sendMessage(HttpServletRequest request,
                            HttpServletResponse response) throws Exception {
        String jsoString = request.getParameter("message");
        logger.info(jsoString);
//        String s =  pushService.push(pushRequest);
//        write(response, null, null, null, s);
//        MyPushResponse myPushResponse = pushService.getPushResponse(new MyPushRequest());
        Map<String,String> map = new HashMap<String, String>();
        map.put("id","1");
        map.put("name","test");
        rabbitProducer.sendDataToQueue("com.dskj.message.image.handle",map);
        write(response, null, null, null, null);
    }
}
