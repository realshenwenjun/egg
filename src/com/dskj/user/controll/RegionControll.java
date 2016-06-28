package com.dskj.user.controll;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dskj.base.Base;
import com.dskj.user.entity.RegionEntity;
import com.dskj.user.service.RegionService;

@Controller
public class RegionControll extends Base {
    @Autowired
    private RegionService regionService;

    /*
     * 获取地区 region={"parentId":1}
     *
     * @param request
     *
     * @param response
     */
    @RequestMapping("/region/get")
    public void getRegionsByParentId(HttpServletRequest request, HttpServletResponse response) {
        try {
            String jsonString = request.getParameter("region");
            logger.info(jsonString);
            List<RegionEntity> object = regionService.getRegionsByParentId(readTreeAsInt(jsonString, "parentId"));
            write(response, null, null, null, object);
        } catch (Exception e) {
            e.printStackTrace();
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /*
     * 获取单个地区信息 region={"id":1}
     *
     * @param request
     *
     * @param response
     */
    @RequestMapping("/region/id")
    public void getRegionById(HttpServletRequest request, HttpServletResponse response) {
        try {
            String jsonString = request.getParameter("region");
            logger.info(jsonString);
            RegionEntity object = regionService.getRegionById(readTreeAsInt(jsonString, "id"));
            write(response, null, null, null, object);
        } catch (Exception e) {
            e.printStackTrace();
            write(response, false, 911, e.getMessage(), null);
        }
    }

    /*
     * 获得地址库版本
     *
     * @param request
     *
     * @param response
     */
    @RequestMapping("/region/version")
    public void getRegionVersion(HttpServletRequest request, HttpServletResponse response) {
        try {
            Object object = regionService.getRegionVersion();
            write(response, null, null, null, object);
        } catch (Exception e) {
            e.printStackTrace();
            write(response, false, 911, e.getMessage(), null);
        }
    }

}
