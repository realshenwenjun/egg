package com.dskj.message.mq;

import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

import com.dskj.base.Base;
import com.dskj.message.Mapper.MessageMapper;
import com.dskj.message.listener.MyListener;

/**
 * Created by chenbo on 2016/4/1.
 */
public class MyLinkedBlockingQueue extends Base implements MqDs {
	private MessageMapper messageMapper;
	private String name;
	private String url;
	private String appkey;
	private String appMasterSecret;
	private LinkedBlockingQueue<Object> linkedBlockingQueue;

	public MyLinkedBlockingQueue() {
		linkedBlockingQueue = new LinkedBlockingQueue<Object>();
	}

	public MyLinkedBlockingQueue(Integer count) {
		if (count != null)
			linkedBlockingQueue = new LinkedBlockingQueue<Object>(count);
		else
			linkedBlockingQueue = new LinkedBlockingQueue<Object>();
	}

	public String getName() throws Exception {
		return name;
	}

	public void setName(String name) throws Exception {
		this.name = name;
	}

	public void setUrl(String url) throws Exception {
		this.url = url;
	}

	public void setAppMasterSecret(String appMasterSecret) throws Exception {
		this.appMasterSecret = appMasterSecret;
	}

	public void setAppkey(String appkey) throws Exception {
		this.appkey = appkey;
	}

	public void put(Object o) throws Exception {
		linkedBlockingQueue.put(o);
		new Thread(new MyListener(this)).start();
	}

	public Object poll() throws Exception {
		return linkedBlockingQueue.poll();
	}

	public void setMessageMapper(MessageMapper messageMapper) {
		this.messageMapper = messageMapper;
	}

	public void send() throws Exception {
		@SuppressWarnings("unchecked")
		Map<String, Object> o = (Map<String, Object>) poll();
		String userId = (String) o.get("userId");
		int commentId = (Integer) o.get("commentId");
		String parentUserId = (String) o.get("parentUserId");
		int parentCommentId = (Integer) o.get("parentCommentId");
		messageMapper.addCommentMessage(userId, commentId, parentUserId,
				parentCommentId);
	}
}
