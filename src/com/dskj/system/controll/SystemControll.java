package com.dskj.system.controll;

import com.dskj.base.Base;
import com.dskj.system.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SystemControll extends Base {
    @Autowired
    private TokenService tokenService;

    @RequestMapping("/sys/monitor")
    public String getJvmStat(HttpServletRequest request, HttpServletResponse response) {
        return "index";
    }

    @RequestMapping(value = "/sys/cache/clear", method = RequestMethod.GET)
    public String clearCache(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String mapper = request.getParameter("cache");
        tokenService.clearCache(mapper);
        return "index";
    }

    /**
     * 获取后台token
     *
     * @param request
     * @param response
     */
    @RequestMapping("/sys/token")
    public void getToken(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Object token = tokenService.checkAndGetToken();
        write(response, null, null, null, token);
    }
}
