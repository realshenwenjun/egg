package com.dskj.census.controll;

import com.dskj.base.Base;
import com.dskj.census.entity.ScatterCensusList;
import com.dskj.census.service.ScatterCensusService;
import com.dskj.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class ScatterCensusControll extends Base {
    @Autowired
    private ScatterCensusService courseScatterCensusService;

    /*
     * 按课程学生分布 census={"pageNo":0,"pageSize":10}
     */
    @RequestMapping("/census/scatter/course/user")
    public void getScatterCensusCourseUserList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String jsonString = request.getParameter("census");
        logger.info(jsonString);
        Page page = new Page();
        page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
        page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
        List<ScatterCensusList> list = courseScatterCensusService.getScatterCensusCourseUserList(page);
        write(response, null, null, null, list);
    }

    /*
     * 机构地理位置分布 census={"parentId":1}
     */
    @RequestMapping("/census/scatter/institution/list")
    public void getScatterCensusInstitutionList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String jsonString = request.getParameter("census");
        logger.info(jsonString);
        List<ScatterCensusList> list = courseScatterCensusService.getScatterCensusInstitutionList(readTreeAsInt(jsonString, "parentId"));
        write(response, null, null, null, list);
    }

    /*
     * 学生地理位置分布 census={"parentId":1}
     */
    @RequestMapping("/census/scatter/user/list")
    public void getScatterCensusUserList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String jsonString = request.getParameter("census");
        logger.info(jsonString);
        List<ScatterCensusList> list = courseScatterCensusService.getScatterCensusUserList(readTreeAsInt(jsonString, "parentId"));
        write(response, null, null, null, list);
    }
}
