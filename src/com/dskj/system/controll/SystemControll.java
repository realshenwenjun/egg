package com.dskj.system.controll;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dskj.base.Base;
import com.dskj.system.service.TokenService;

@Controller
public class SystemControll extends Base {
	@Autowired
	private TokenService tokenService;

	@RequestMapping("/sys/monitor")
	public String getJvmStat(HttpServletRequest request, HttpServletResponse response) {
		return "index";
	}

	@RequestMapping(value = "/sys/cache/clear", method = RequestMethod.GET)
	public String clearCache(HttpServletRequest request, HttpServletResponse response) {
		String mapper = request.getParameter("cache");
		try {
			tokenService.clearCache(mapper);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}

	/**
	 * 获取后台token
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/sys/token")
	public void getToken(HttpServletRequest request, HttpServletResponse response) {
		try {
			Object token = tokenService.checkAndGetToken();
			write(response, null, null, null, token);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}
}
