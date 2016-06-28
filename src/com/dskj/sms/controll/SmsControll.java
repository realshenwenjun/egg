package com.dskj.sms.controll;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dskj.base.Base;
import com.dskj.sms.entity.SmsPhone;
import com.dskj.sms.service.SmsConfigService;

@Controller
public class SmsControll extends Base {
	@Autowired
	private SmsConfigService smsConfigService;

	/**
	 * 发送短信验证码
	 * 
	 * @param sms={"phone":"13552261484","templeteId":"sms_regist_templateId"}
	 * @param response
	 */
	@RequestMapping("/sms/send")
	public void sendTemplateSMS(HttpServletRequest request, HttpServletResponse response) {
		try {
			String smsString = request.getParameter("sms");
			SmsPhone smsPhone = stringToObj(smsString, SmsPhone.class);
			Map<String, Object> result = smsConfigService.sendTemplateSMS(smsPhone);
			if(result.get("code") == null || "".equals(result.get("code"))){
				write(response, false, 909, result.get("message").toString(), result);
			}else{
				write(response, null, null, null, result);
			}
		} catch (Exception e) {
			write(response, false, 911, e.getMessage(), null);
		}
	}
}
