package com.dskj.census.controll;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dskj.base.Base;
import com.dskj.census.entity.TimingCensusUserSignDetail;
import com.dskj.census.entity.TimingCensusUserSignList;
import com.dskj.census.service.TimingCensusService;
import com.dskj.util.Page;

@Controller
public class TimingCensusControll extends Base {
	@Autowired
	private TimingCensusService timingCensusService;

	/*
	 * census={"institutionId":"","date":178465211000,"pageNo":0,"pageSize":10}
	 */
	@RequestMapping("/census/timing/user/list")
	public void getTimingCensusUserSignList(HttpServletRequest request, HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("census");
			logger.info(jsonString);
			Page page = new Page();
			page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
			page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
			Date date = new Date(readTreeAsLong(jsonString, "date"));
			List<TimingCensusUserSignList> list = timingCensusService.getTimingCensusUserSignList(readTree(jsonString, "institutionId"), date, page);
			write(response, null, null, null, list);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * census={"institutionId":"","userId":"","startTime":178465211000,"endTime":
	 * 178465211000,"pageNo":0,"pageSize":10}
	 */
	@RequestMapping("/census/timing/user/detail")
	public void getTimingCensusUserSignDetail(HttpServletRequest request, HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("census");
			logger.info(jsonString);
			Page page = new Page();
			page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
			page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
			Date startTime = new Date(readTreeAsLong(jsonString, "startTime"));
			Date endTime = new Date(readTreeAsLong(jsonString, "endTime"));
			List<TimingCensusUserSignDetail> list = timingCensusService.getTimingCensusUserSignDetail(readTree(jsonString, "institutionId"),
					readTree(jsonString, "userId"), startTime, endTime, page);
			write(response, null, null, null, list);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}
}
