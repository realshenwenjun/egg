package com.dskj.census.controll;

import com.dskj.base.Base;
import com.dskj.census.service.SearchService;
import com.dskj.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SearchControll extends Base {
    @Autowired
    private SearchService searchService;

    /*
     * 首页搜索search={"userId":"","key":"","type":2,"pageNo":0,"pageSize":20}
     * 单独搜课程type传2
     */
    @RequestMapping("/search")
    public void getSearchList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String jsonString = request.getParameter("search");
        logger.info(jsonString);
        Page page = new Page();
        page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
        page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
        write(response, null, null, null, searchService.getSearch(readTree(jsonString, "key"), readTreeAsInt(jsonString, "type"), readTree(jsonString, "userId"), page));
    }

}
