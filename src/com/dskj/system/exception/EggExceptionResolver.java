package com.dskj.system.exception;

import com.dskj.base.Base;
import com.dskj.response.JsonResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * Created by ASUS on 2016/8/31.
 */
@Component
public class EggExceptionResolver extends Base implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse, Object o, Exception e) {
        JsonResponse resultModel = getResultModel(e);
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("UTF-8");
        try {
            httpServletResponse.getWriter().write(objToString(resultModel));
            logger.info(objToString(resultModel));
        } catch (IOException e1) {
            logger.error(e1);
        }
        return null;
    }

    private JsonResponse getResultModel(Exception e) {
        JsonResponse resultModel = new JsonResponse();
        resultModel.setMessage(e.getMessage());
        resultModel.setCode(911);
        resultModel.setSuccess(false);
        return resultModel;
    }
}
