package com.dskj.course.controll;

import com.dskj.base.Base;
import com.dskj.course.entity.MoreCourseList;
import com.dskj.course.entity.Plan;
import com.dskj.course.entity.PlanByClass;
import com.dskj.course.service.PlanService;
import com.dskj.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PlanControll extends Base {
    @Autowired
    private PlanService planService;

    /*
     * 6 为班级添加课程表 - 后台生成(适用于按周规则的批量添加)
     * plan={"classId":1,"date":1450195200000,"times"
     * :8,"plans":[{"week":1,"startTime"
     * :"13:00:00","endTime":"15:00:00","userId":"2ad23","address":""}]}
     */
    @RequestMapping("/plan/add/at/server")
    public void addPlanAtServer(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String jsonString = request.getParameter("plan");
        logger.info(jsonString);
        planService.addPlanAtServer(jsonString);
        write(response, null, null, null, null);
    }

    /*
     * 6 为班级添加课程表 - 1月12日重新修改
     * plan={"classId":1,"date":1450195200000
     * ,"startTime":"13:00:00","endTime"
     * :"15:00:00","userId":"3iji3","address":"","weeks":3}
     */
    @RequestMapping("/plan/add/at/server/easy")
    public void addPlanAtServerEasy(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String jsonString = request.getParameter("plan");
        logger.info(jsonString);
        planService.addPlanAtServerEasy(jsonString);
        write(response, null, null, null, null);
    }

    /*
     * 6 为班级添加课程表 - 客户端生成(适用于无规则的批量添加)
     * plan={"classId":1,"plans":[{"date":1450195200000
     * ,"startTime":"13:00:00","endTime"
     * :"15:00:00","userId":"3iji3","address":""}]}
     */
    @RequestMapping("/plan/add/at/client")
    public void addPlanAtClient(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String jsonString = request.getParameter("plan");
        logger.info(jsonString);
        planService.addPlanAtClient(jsonString);
        write(response, null, null, null, null);
    }

    /*
     * 6 修改班级课程表 - 客户端生成(适用于无规则的批量修改)
     * plan={"plans":[{"id":23,"date":1450195200000
     * ,"startTime":"13:00:00","endTime"
     * :"15:00:00","userId":"3iji3","address":""}]}
     */
    @RequestMapping("/plan/update/at/client")
    public void updatePlanAtClient(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String jsonString = request.getParameter("plan");
        logger.info(jsonString);
        List<Plan> plans = jsonToList(readTree(jsonString, "plans"), ArrayList.class, Plan.class);
        planService.updatePlans(plans);
        write(response, null, null, null, null);
    }

    /*
     * 6 删除班级课程表 plan={"id":1}
     */
    @RequestMapping("/plan/delete")
    public void deletePlan(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String jsonString = request.getParameter("plan");
        logger.info(jsonString);
        int i = planService.deleteById(readTreeAsInt(jsonString, "id"));
        switch (i) {
            case 1:
                write(response, false, 801, "本次课已上，不能删除！", null);
                break;
            case 2:
                write(response, false, 802, "本次课已有人请假，不能删除！", null);
                break;
            case 3:
                write(response, false, 803, "本次课已有人补课，不能删除！", null);
                break;
            default:
                write(response, null, null, null, null);
                break;
        }
    }

    /*
     * 4 课程-开课管理-具体安排 查看班级的课程表(兼容老师请假) plan={"classId":1}
     */
    @RequestMapping("/plan/list/under/class")
    public void getPlanByClass(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String jsonString = request.getParameter("plan");
        logger.info(jsonString);
        List<PlanByClass> plans = planService.getPlanByClass(readTreeAsInt(jsonString, "classId"));
        write(response, null, null, null, plans);
    }

    /*
     * 学生查看更多课程 plan={"userId":"","institutionId":"","pageNo":0,"pageSize":10}
     */
    @RequestMapping("/plan/list/more")
    public void getMorePlan(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String jsonString = request.getParameter("plan");
        logger.info(jsonString);
        Page page = new Page();
        page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
        page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
        List<MoreCourseList> plans = planService.getMoreCourseList(readTree(jsonString, "userId"), readTree(jsonString, "institutionId"), page);
        write(response, null, null, null, plans);
    }

    /*
     * 我的收藏里查看机构课程 plan={"institutionId":"","pageNo":0,"pageSize":10}
     */
    @RequestMapping("/plan/collect/course/list")
    public void getCollectCourseList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String jsonString = request.getParameter("plan");
        logger.info(jsonString);
        Page page = new Page();
        page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
        page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
        List<MoreCourseList> plans = planService.getCollectCourseList(readTree(jsonString, "institutionId"), page);
        write(response, null, null, null, plans);
    }
}
