package com.dskj.user.controll;

import com.dskj.base.Base;
import com.dskj.user.entity.UserInfoBack;
import com.dskj.user.service.UserInfoBackService;
import com.dskj.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@Controller
public class UserInfoBackControll extends Base {
    @Autowired
    private UserInfoBackService userInfoBackService;

    /*
     * 添加信息反馈 infoback={"info":"","picture":"","userId":""}
     */
    @RequestMapping("/infoback/add")
    public void updateInstitutionInfo(HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        String jsonString = request.getParameter("infoback");
        logger.info(jsonString);
        UserInfoBack userInfoBack = stringToObj(jsonString,
                UserInfoBack.class);
        userInfoBack.setCreateTime(new Date());
        userInfoBack.setStatus(0);
        userInfoBackService.add(userInfoBack);
        write(response, null, null, null, null);
    }

    /*
     * 查询信息反馈 infoback={"pageNo":0,"pageSize:10}
     */
    @RequestMapping("/infoback/list")
    public void getInfoBackList(HttpServletRequest request,
                                HttpServletResponse response) throws Exception {
        String jsonString = request.getParameter("infoback");
        logger.info(jsonString);
        Page page = stringToObj(jsonString, Page.class);
        List<UserInfoBack> list = userInfoBackService.getList(page);
        write(response, null, null, null, list);
    }

    /*
     * 查询信息反馈数量
     */
    @RequestMapping("/infoback/count")
    public void getInfoBackCount(HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        String jsonString = request.getParameter("infoback");
        logger.info(jsonString);
        write(response, null, null, null,
                userInfoBackService.getInfoBackCount());
    }
}
