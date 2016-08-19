package com.dskj.system.service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.dskj.base.Base;
import com.dskj.base.CacheBean;
import com.dskj.enu.OSAskLimit;
import com.dskj.system.entity.Token;
import com.dskj.system.entity.TokenConfig;
import com.dskj.system.mapper.TokenMapper;

@Service
public class TokenServiceImpl extends Base implements TokenService, InitializingBean, ApplicationContextAware {
	@Autowired
	private TokenMapper tokenMapper;
	private Map<String, Object> sysTokenConfigs = new ConcurrentHashMap<String, Object>();

	private ApplicationContext applicationContext;

	public void afterPropertiesSet() throws Exception {
		List<TokenConfig> list = tokenMapper.getTokenConfig();
		for (TokenConfig config : list) {
			sysTokenConfigs.put(config.getKey(), config.getValue());
		}
		if ("true".equals(sysTokenConfigs.get("sys_token_open")))
			logger.info("token config init success.");
	}

	public synchronized String getToekn() throws Exception {
		if (System.currentTimeMillis() > Long.valueOf(String.valueOf(sysTokenConfigs.get("sys_token_expires_in")))) {
			String token = Base64.encodeBase64String(UUID.randomUUID().toString().getBytes());
			Long expiresIn = System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000;
			tokenMapper.updateToken(token, expiresIn);
			sysTokenConfigs.put("sys_token_value", token);
			sysTokenConfigs.put("sys_token_expires_in", expiresIn);
			logger.info("system token refreshed.");
		}
		return sysTokenConfigs.get("sys_token_value").toString();
	}

	public Object checkAndGetToken() throws Exception {
		getToekn();
		Token token = new Token();
		token.setToken(sysTokenConfigs.get("sys_token_value").toString());
		token.setExpires_in(Long.valueOf(String.valueOf(sysTokenConfigs.get("sys_token_expires_in"))));
		return token;
	}

	public Boolean checkToken(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if ("false".equals(sysTokenConfigs.get("sys_token_open")))// 验证token开关
			return checkOSLimit(request, response);
		if (urlCkeck(request.getRequestURI(), request.getContextPath()))// 验证请求的资源
			return checkOSLimit(request, response);
		String authorization = request.getHeader("Authorization");// 验证token
		if (authorization == null || authorization.equals("")) {
			write(response, false, 899, "Header property 'Authorization' is missing", null);
			return false;
		}
		if (authorization.equals(netKey))// 验证是否是PC端
			return checkOSLimit(request, response);
		if (!authorization.equals(this.getToekn())) {
			write(response, false, 897, "token is not correct", null);
			return false;
		}
		return checkOSLimit(request, response);// 验证单日访问量
	}

	public Boolean checkOSLimit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String agent = request.getHeader("User-Agent");
		if (agent.toLowerCase().contains("android")) {
			if (!OSAskLimit.ANDROID.getOSAuth()) {
				write(response, false, 887, "超过本日请求次数!,单日最大请求次数为" + OSAskLimit.ANDROID.getO(), null);
				return false;
			} else
				return true;
		} else if (agent.toLowerCase().contains("iphone")) {
			if (!OSAskLimit.IOS.getOSAuth()) {
				write(response, false, 887, "超过本日请求次数!,单日最大请求次数为" + OSAskLimit.IOS.getO(), null);
				return false;
			} else
				return true;
		} else {
			if (!OSAskLimit.OTHER.getOSAuth()) {
				write(response, false, 887, "超过本日请求次数!,单日最大请求次数为" + OSAskLimit.OTHER.getO(), null);
				return false;
			} else
				return true;
		}
	}

	private Boolean urlCkeck(String url, String contextPath) throws Exception {
		if (url.equals(contextPath) || url.equals(contextPath + "/"))// 主页
			return true;
		if (url.contains(contextPath + "/sys"))
			return true;
		if (url.contains(contextPath + "/image"))// 静态资源
			return true;
		if (url.contains(contextPath + "/xml"))
			return true;
		if (url.contains(contextPath + "/file/xml/upload") || url.contains(contextPath + "/file/apk/upload"))
			return true;
		if (url.contains(".jsp"))// 动态页面
			return true;
		return false;
	}

	public void clearCache(String mapper) throws Exception {
		if ("all".equals(mapper)) {
			for (String c : clearMappers) {
				CacheBean cacheBean = (CacheBean) this.applicationContext.getBean(Class.forName(c));
				cacheBean.clear();
			}
		} else {
			CacheBean cacheBean = (CacheBean) this.applicationContext.getBean(Class.forName(mapper));
			cacheBean.clear();
		}
	}

	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		this.applicationContext = arg0;
	}

	private static String[] clearMappers = { "com.dskj.announcement.mapper.AnnouncementMapper", "com.dskj.announcement.mapper.AnnouncementReadMapper",
			"com.dskj.announcement.mapper.AnnouncementTypeMapper", "com.dskj.census.mapper.DailyLiveCensusMapper",
			"com.dskj.census.mapper.ScatterCensusMapper", "com.dskj.census.mapper.SignCensusMapper", "com.dskj.census.mapper.TimingCensusMapper",
			"com.dskj.census.mapper.UserCensusMapper", "com.dskj.course.mapper.AdminCourseMapper", "com.dskj.course.mapper.ClassMapper",
			"com.dskj.course.mapper.ClassSignMapper", "com.dskj.course.mapper.CourseMapper", "com.dskj.course.mapper.GatherMapper",
			"com.dskj.course.mapper.LackMapper", "com.dskj.course.mapper.PlanMapper", "com.dskj.course.mapper.PlanSignMapper",
			"com.dskj.course.mapper.SuppleMapper", "com.dskj.course.mapper.WorkTimeMapper", "com.dskj.spread.mapper.PropaMapper",
			"com.dskj.user.mapper.InstitutionMapper", "com.dskj.user.mapper.UserLoginLogMapper", "com.dskj.user.mapper.UserMapper" };
}
