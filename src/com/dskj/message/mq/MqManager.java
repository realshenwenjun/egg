package com.dskj.message.mq;

import com.dskj.message.Mapper.MessageMapper;
import com.dskj.message.entity.MessageConfig;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenbo on 2016/3/31.
 */
@Service("mqManager")
public class MqManager implements InitializingBean{
    @Autowired
    private MessageMapper messageMapper;

    private Map<String, String> mqConfigs = new HashMap<String, String>();

    private List<MqDs> mqList = new ArrayList<MqDs>();

    private Class<?> mqInstance = MyLinkedBlockingQueue.class;

    public MqManager() {
    }

    public MqManager(Class<?> c) {
        if (MqDs.class.isAssignableFrom(c))
            mqInstance = c;
    }

    public void afterPropertiesSet() throws Exception {
        List<MessageConfig> messageConfigs = messageMapper.getConfig();
        if (messageConfigs == null)
            throw new Exception("Mq config init fail.");
        for (MessageConfig config : messageConfigs) {
            mqConfigs.put(config.getKey(), config.getValue());
        }
        Integer mqCount = Integer.valueOf(mqConfigs.get("mq_count"));
        if (mqCount != null){
            for (int i = 0;i < mqCount;i++){
                MqDs mqDs = (MqDs) mqInstance.newInstance();
                mqDs.setName(String.valueOf(i));
                mqDs.setAppkey(mqConfigs.get("mq_appkey"));
                mqDs.setUrl(mqConfigs.get("mq_url"));
                mqDs.setAppMasterSecret(mqConfigs.get("mq_app_master_secret"));
                mqDs.setMessageMapper(messageMapper);
                mqList.add(mqDs);
            }
        }
    }

    public List<MqDs> getMqList() {
        return mqList;
    }
}
