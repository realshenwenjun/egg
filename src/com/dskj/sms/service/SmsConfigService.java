package com.dskj.sms.service;

import java.util.List;
import java.util.Map;

import com.dskj.sms.entity.SmsConfig;
import com.dskj.sms.entity.SmsPhone;

public interface SmsConfigService {
	public List<SmsConfig> getSmsConfig() throws Exception;

	public Map<String, Object> sendTemplateSMS(SmsPhone smsPhone) throws Exception;
}
