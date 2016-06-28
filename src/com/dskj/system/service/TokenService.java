package com.dskj.system.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface TokenService {
	public Object checkAndGetToken() throws Exception;

	public Boolean checkToken(HttpServletRequest request ,HttpServletResponse response) throws Exception;
	
	public void clearCache(String mapper) throws Exception;
}
