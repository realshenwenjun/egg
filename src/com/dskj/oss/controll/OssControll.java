package com.dskj.oss.controll;

import com.dskj.base.Base;
import com.dskj.oss.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class OssControll extends Base {

    @Autowired
    private OssService ossService;

    /*
     * 获取oss签名 oss={"content":""}
     */
    @RequestMapping("/oss/sign")
    public void getOssSign(HttpServletRequest request,
                           HttpServletResponse response) throws Exception {
        String jsoString = request.getParameter("oss");
        logger.info(jsoString);
        write(response, null, null, null,
                ossService.signContent(readTree(jsoString, "content")));
    }

    /*
     * 为图片生成小尺寸规格 oss={"url":""}
     */
    @RequestMapping("/oss/object/small/add")
    public void addSmallObject(HttpServletRequest request,
                               HttpServletResponse response) throws Exception {
        String jsoString = request.getParameter("oss");
        logger.info(jsoString);
        ossService.addObjectSmallSpec(readTree(jsoString, "url"));
        write(response, null, null, null,
                null);
    }

    /*
     * 上传文件流 oss={"parentFile":"","path":""}
     */
    @RequestMapping("/oss/object/add")
    public void addObject(HttpServletRequest request,
                          HttpServletResponse response) throws Exception {
        String jsoString = request.getParameter("oss");
        logger.info(jsoString);
        String path = ossService.addObject(readTree(jsoString, "parentFile"), readTree(jsoString, "path"));
        write(response, null, null, null,
                path);
    }
}
