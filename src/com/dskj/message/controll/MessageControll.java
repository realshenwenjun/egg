package com.dskj.message.controll;

import com.dskj.base.Base;
import com.dskj.message.mq.MqManager;
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
    private MqManager mqManager;

    /*
     * 发送消息和通知 message={"ticker":"","title":"","text":"","after_open":"","custom":"","display_type":"","type":"","device_tokens":"","alias_type":"","alias":"","description":"","expire_time":""}
     */
    @RequestMapping("/message/send")
    public void sendMessage(HttpServletRequest request,
                            HttpServletResponse response) throws Exception {
        String jsoString = request.getParameter("message");
        logger.info(jsoString);
        Map<String, String> map = stringToObj(jsoString, HashMap.class);
        mqManager.getMqList().get(0).put(map);
        write(response, null, null, null, null);
    }
}
