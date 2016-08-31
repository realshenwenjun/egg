package com.dskj.census.controll;

import com.dskj.base.Base;
import com.dskj.census.entity.DailyLiveCensusDateList;
import com.dskj.census.service.DailyLiveCensusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@Controller
public class DailyLiveCensusControll extends Base {
    @Autowired
    private DailyLiveCensusService dailyLiveCensusService;

    /*
     * 7天日活量 census={"date":176767880000}
     */
    @RequestMapping("/census/daily/live/list")
    public void getDailyLiveCensusDateList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String jsonString = request.getParameter("census");
        logger.info(jsonString);
        Date date = null;
        try {
            date = new Date(readTreeAsLong(jsonString, "date") == 0 ? null : readTreeAsLong(jsonString, "date"));
        } catch (Exception e) {
        }
        List<DailyLiveCensusDateList> list = dailyLiveCensusService.getDailyLiveCensusDateList(date);
        write(response, null, null, null, list);
    }

    /*
     * 7天注册量 census={"date":176767880000}
     */
    @RequestMapping("/census/daily/user/list")
    public void getDailyLiveCensusUserList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String jsonString = request.getParameter("census");
        logger.info(jsonString);
        Date date = null;
        try {
            date = new Date(readTreeAsLong(jsonString, "date") == 0 ? null : readTreeAsLong(jsonString, "date"));
        } catch (Exception e) {
        }
        List<DailyLiveCensusDateList> list = dailyLiveCensusService.getDailyLiveCensusUserList(date);
        write(response, null, null, null, list);
    }
}
