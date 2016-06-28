package com.dskj.spread.controll;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dskj.base.Base;
import com.dskj.spread.entity.Propagate;
import com.dskj.spread.service.PropaService;
import com.dskj.util.Page;

/**
 * 宣传
 * 
 * @author wenjunshen
 * 
 */
@Controller
public class PropaControll extends Base {
	@Autowired
	private PropaService propaService;

	/*
	 * 增加机构宣传信息 propa={"institutionId":"","title":"","propagate":""}
	 */
	@RequestMapping("/propa/add")
	public void addPropa(HttpServletRequest request, HttpServletResponse response) {
		Propagate propagate = null;
		try {
			String jsonString = request.getParameter("propa");
			logger.info(jsonString);
			propagate = stringToObj(jsonString, Propagate.class);
			propagate.setCreateTime(new Date());
			propaService.add(propagate);
			write(response, null, null, null, propagate);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 修改机构宣传信息 propa={"id":1,"title":"","propagate":""}
	 */
	@RequestMapping("/propa/update")
	public void updatePropa(HttpServletRequest request, HttpServletResponse response) {
		Propagate propagate = null;
		try {
			String jsonString = request.getParameter("propa");
			logger.info(jsonString);
			propagate = stringToObj(jsonString, Propagate.class);
			Propagate propagate2 = propaService.get(propagate.getId());
			propaService.update(propagate2);
			write(response, null, null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 删除机构宣传信息 propa={"id":1}
	 */
	@RequestMapping("/propa/delete")
	public void deletePropa(HttpServletRequest request, HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("propa");
			logger.info(jsonString);
			propaService.deleteById(readTreeAsInt(jsonString, "id"));
			write(response, null, null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}

	/*
	 * 获取机构宣传信息列表 propa={"institutionId":"","pageNo":0,"pageSize":10}
	 */
	@RequestMapping("/propa/list")
	public void getPropaList(HttpServletRequest request, HttpServletResponse response) {
		try {
			String jsonString = request.getParameter("propa");
			logger.info(jsonString);
			Page page = new Page();
			page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
			page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
			List<Propagate> list = propaService.getList(readTree(jsonString, "institutionId"), page);
			write(response, null, null, null, list);
		} catch (Exception e) {
			e.printStackTrace();
			write(response, false, 911, e.getMessage(), null);
		}
	}
}
