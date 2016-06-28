package com.dskj.census.controll;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dskj.base.Base;
import com.dskj.census.entity.SignCensusUserSignDetail;
import com.dskj.census.entity.SignCensusUserSignList;
import com.dskj.census.service.SignCensusService;
import com.dskj.util.Page;
/**
 * 上课情况
 * @author Administrator
 *
 */
@Controller
public class SignCensusControll extends Base{
	@Autowired
	private SignCensusService signCensusService;
	
	/*
	 * census={"institutionId":"","startTime":178465211000,"endTime":178465211000,"pageNo":0,"pageSize":10}
	 */
	@RequestMapping("/census/sign/user/list")
	public void getSignCensusUserSignList(HttpServletRequest request, HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("census");
			logger.info(jsonString);
			Page page = new Page();
			page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
			page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
			Date startTime = new Date(readTreeAsLong(jsonString, "startTime"));
			Date endTime = new Date(readTreeAsLong(jsonString, "endTime"));
			List<SignCensusUserSignList> list = signCensusService.getSignCensusUserSignList(readTree(jsonString, "institutionId"),startTime,endTime, page);
			write(response, null, null, null, list);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}
	/*
	 * census={"institutionId":"","userId":"","startTime":178465211000,"endTime":178465211000,"pageNo":0,"pageSize":10}
	 */
	@RequestMapping("/census/sign/user/detail")
	public void getSignCensusUserSignDetail(HttpServletRequest request, HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("census");
			logger.info(jsonString);
			Page page = new Page();
			page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
			page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
			Date startTime = new Date(readTreeAsLong(jsonString, "startTime"));
			Date endTime = new Date(readTreeAsLong(jsonString, "endTime"));
			List<SignCensusUserSignDetail> list = signCensusService.getSignCensusUserSignDetail(readTree(jsonString, "institutionId"),readTree(jsonString, "userId"), startTime,endTime, page);
			write(response, null, null, null, list);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}
}
