package com.dskj.census.controll;

import com.dskj.base.Base;
import com.dskj.census.entity.UserCensusByChildInstitution;
import com.dskj.census.entity.UserCensusByCourseType;
import com.dskj.census.service.UserCensusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 学生数量
 *
 * @author Administrator
 */
@Controller
public class UserCensusControll extends Base {
    @Autowired
    private UserCensusService userCensusService;

    /*
     * 按课程类型查看学生数 census={"institutionId":""}
     */
    @RequestMapping("/census/user/by/course/type")
    public void getUserCensusByCourseType(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String jsonString = request.getParameter("census");
        logger.info(jsonString);
        List<UserCensusByCourseType> list = userCensusService.getUserCensusByCourseType(readTree(jsonString, "institutionId"));
        write(response, null, null, null, list);
    }

    /*
     * 按子机构查看学生数 census={"institutionId":""}
     */
    @RequestMapping("/census/user/by/child/institution")
    public void getUserCensusByChildInstitution(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String jsonString = request.getParameter("census");
        logger.info(jsonString);
        List<UserCensusByChildInstitution> list = userCensusService.getUserCensusByChildInstitution(readTree(jsonString, "institutionId"));
        write(response, null, null, null, list);
    }
}
