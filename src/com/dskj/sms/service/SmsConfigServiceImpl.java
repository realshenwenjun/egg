package com.dskj.sms.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloopen.rest.sdk.CCPRestSmsSDK;
import com.dskj.base.Base;
import com.dskj.sms.entity.SmsConfig;
import com.dskj.sms.entity.SmsPhone;
import com.dskj.sms.mapper.SmsConfigMapper;
import com.dskj.util.DateUtil;

@Service
public class SmsConfigServiceImpl extends Base implements SmsConfigService, InitializingBean {
	@Autowired
	private SmsConfigMapper smsConfigMapper;
	CCPRestSmsSDK restAPI = new CCPRestSmsSDK();
	private Map<String, String> smsConfigs = new HashMap<String, String>();
	private Long samp = 0l;

	public List<SmsConfig> getSmsConfig() throws Exception {
		List<SmsConfig> sms = smsConfigMapper.getSmsConfig();
		if (sms == null)
			throw new Exception("Sms config init fail.");
		for (SmsConfig config : sms) {
			smsConfigs.put(config.getKey(), config.getValue());
		}
		return sms;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> sendTemplateSMS(SmsPhone smsPhone) throws Exception {
		String code = randomCode();
		long timestamp = 0;
		HashMap<String, Object> result = restAPI.sendTemplateSMS(smsPhone.getPhone(), smsConfigs.get(smsPhone.getTempleteId()),
				new String[] { code, smsConfigs.get("sms_min") });
		if ("000000".equals(result.get("statusCode"))) {
			// 正常返回输出data包体信息（map）
			HashMap<String, Object> data = ((HashMap<String, Object>) result.get("data"));
			data = (HashMap<String, Object>) data.get("templateSMS");
			StringBuilder date = new StringBuilder((String) data.get("dateCreated"));// 获取发送时间
			date.insert(4, "-").insert(7, "-").insert(10, " ").insert(13, ":").insert(16, ":");
			timestamp = DateUtil.parseDate(date.toString(), DateUtil.normalTimeFormat).getTime();
			timestamp = timestamp + samp;
			result.clear();
			result.put("code", code);
			result.put("timestamp", timestamp);
		} else {
			String statusMsg = (String) result.get("statusMsg");
			result.clear();
			result.put("message", statusMsg);
		}
		return result;
	}

	/**
	 * 随机生成验证码
	 * 
	 * @return
	 */
	private String randomCode() {
		Random random = new Random();
		String result = "";
		for (int i = 0; i < 6; i++) {
			result += random.nextInt(10);
		}
		return result;
	}

	public void afterPropertiesSet() throws Exception {
		try {
			this.getSmsConfig();

			restAPI.init(smsConfigs.get("sms_restUrl"), smsConfigs.get("sms_port"));
			restAPI.setAccount(smsConfigs.get("sms_accountSid"), smsConfigs.get("sms_authToken"));
			restAPI.setAppId(smsConfigs.get("sms_appId"));
			this.samp = Long.valueOf(smsConfigs.get("sms_min")) * 60 * 1000;
			logger.info("sms client init success.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
