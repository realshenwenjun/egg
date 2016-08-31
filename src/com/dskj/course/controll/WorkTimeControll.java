package com.dskj.course.controll;

import com.dskj.base.Base;
import com.dskj.course.entity.WorkTime;
import com.dskj.course.service.WorkTimeService;
import com.dskj.util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WorkTimeControll extends Base {
    @Autowired
    private WorkTimeService workTimeService;

    /*
     * 上课时间维护
     * worktime=[{"institutionId":"","workDate":1332322222,"workStart"
     * :"09:00:00","workEnd":"17:00:00","free":0}] free:0(false),1(true)
     */
    @RequestMapping("/worktime/add")
    public void addWorkTime(HttpServletRequest request,
                            HttpServletResponse response) throws Exception {
        String jsonString = request.getParameter("worktime");
        logger.info(jsonString);
        List<WorkTime> workTimes = jsonToList(jsonString,
                ArrayList.class, WorkTime.class);
        workTimeService.addWorkTimes(workTimes);
        /**刷新考勤统计缓存***/
        String host = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/sys/cache/clear?cache=com.dskj.census.mapper.TimingCensusMapper";
        HttpUtil.get(host, null);
        write(response, null, null, null, null);
    }

    /*
     * 上课时间维护查询
     * worktime={"institutionId":"","year":2015,"month":12}
     */
    @RequestMapping("/worktime/list")
    public void getWorkTimes(HttpServletRequest request,
                             HttpServletResponse response) throws Exception {
        String jsonString = request.getParameter("worktime");
        logger.info(jsonString);
        List<WorkTime> workTimes = workTimeService.getWorkTimes(readTree(jsonString, "institutionId"), readTreeAsInt(jsonString, "year"), readTreeAsInt(jsonString, "month"));
        write(response, null, null, null, workTimes);
    }

    /*
     * 上课时间维护修改
     * worktime=[{"id":1,"workStart":"","workEnd":"","free":0}] 0:false,1：true
     */
    @RequestMapping("/worktime/update")
    public void updateWorkTimes(HttpServletRequest request,
                                HttpServletResponse response) throws Exception {
        String jsonString = request.getParameter("worktime");
        logger.info(jsonString);
        List<WorkTime> workTimes = jsonToList(jsonString,
                ArrayList.class, WorkTime.class);
        workTimeService.updateWorkTimes(workTimes);
        /**刷新考勤统计缓存***/
        String host = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/sys/cache/clear?cache=com.dskj.census.mapper.TimingCensusMapper";
        HttpUtil.get(host, null);
        write(response, null, null, null, workTimes);
    }
}
