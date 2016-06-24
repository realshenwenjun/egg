package com.dskj.system.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import com.dskj.base.Base;
import com.dskj.system.service.TokenService;

/**
 * Servlet Filter implementation class SystemFilter
 */
public class SystemFilter extends Base implements Filter {
	private TokenService tokenService;

	/**
	 * Default constructor.
	 */
	public SystemFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		try {
			/**
			 * 校验
			 */
			if (!tokenService.checkToken((HttpServletRequest) request, (HttpServletResponse) response))
				return;
		} catch (Exception e) {
			e.printStackTrace();
			write((HttpServletResponse) response, false, 898, "验证token时异常", null);
			return;
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		ApplicationContext applicationContext = (ApplicationContext) fConfig.getServletContext().getAttribute(
				WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		tokenService = (TokenService) applicationContext.getBean(TokenService.class);
	}

}
