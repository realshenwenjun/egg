package com.dskj.spread.controll;

import com.dskj.base.Base;
import com.dskj.spread.entity.Propagate;
import com.dskj.spread.service.PropaService;
import com.dskj.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * 宣传
 *
 * @author wenjunshen
 */
@Controller
public class PropaControll extends Base {
    @Autowired
    private PropaService propaService;

    /*
     * 增加机构宣传信息 propa={"institutionId":"","title":"","propagate":""}
     */
    @RequestMapping("/propa/add")
    public void addPropa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Propagate propagate = null;
        String jsonString = request.getParameter("propa");
        logger.info(jsonString);
        propagate = stringToObj(jsonString, Propagate.class);
        propagate.setCreateTime(new Date());
        propaService.add(propagate);
        write(response, null, null, null, propagate);
    }

    /*
     * 修改机构宣传信息 propa={"id":1,"title":"","propagate":""}
     */
    @RequestMapping("/propa/update")
    public void updatePropa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Propagate propagate = null;
        String jsonString = request.getParameter("propa");
        logger.info(jsonString);
        propagate = stringToObj(jsonString, Propagate.class);
        Propagate propagate2 = propaService.get(propagate.getId());
        propaService.update(propagate2);
        write(response, null, null, null, null);
    }

    /*
     * 删除机构宣传信息 propa={"id":1}
     */
    @RequestMapping("/propa/delete")
    public void deletePropa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String jsonString = request.getParameter("propa");
        logger.info(jsonString);
        propaService.deleteById(readTreeAsInt(jsonString, "id"));
        write(response, null, null, null, null);
    }

    /*
     * 获取机构宣传信息列表 propa={"institutionId":"","pageNo":0,"pageSize":10}
     */
    @RequestMapping("/propa/list")
    public void getPropaList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String jsonString = request.getParameter("propa");
        logger.info(jsonString);
        Page page = new Page();
        page.setPageNo(readTreeAsInt(jsonString, "pageNo"));
        page.setPageSize(readTreeAsInt(jsonString, "pageSize"));
        List<Propagate> list = propaService.getList(readTree(jsonString, "institutionId"), page);
        write(response, null, null, null, list);
    }
}
