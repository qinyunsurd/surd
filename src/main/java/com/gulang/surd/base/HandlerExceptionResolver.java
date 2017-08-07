package com.gulang.surd.base;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author : gulang
 *         Create Date : 2017/7/25
 *         Company     : Garden Plus
 *         Description :
 */
public class HandlerExceptionResolver extends SimpleMappingExceptionResolver {
    private final Logger logger = Logger.getLogger(this.getClass());

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        String uri = request.getRequestURI();
        logger.error(uri + "--error:", ex);
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.put("status", "failure");
        resultMessage.put("ex", ExceptionUtil.getStackTrace(ex));
        resultMessage.put("requestCode", request.getAttribute("requestCode"));
        resultMessage.put("responseCode", response.getStatus());
        request.setAttribute("resultMessage", JSON.toJSONString(resultMessage));
        String viewName = determineViewName(ex, request);
        if (null != viewName) {
            if ((request.getHeader("accept") != null) && (!(request.getHeader("accept").indexOf("application/json") > -1
                    || (request.getHeader("X-Requested-With") != null
                    && request.getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1)))) {

                Integer statusCode = determineStatusCode(request, viewName);
                if (statusCode != null) {
                    applyStatusCodeIfPossible(request, response, statusCode);
                }
                return getModelAndView(viewName, ex, request);
            } else {
                PrintWriter writer = null;
                try {
                    response.setCharacterEncoding("utf-8");
                    response.setContentType("application/json;charset=utf-8");
                    writer = response.getWriter();
                    writer.write(ex.getMessage());
                    writer.flush();
                } catch (IOException e) {
                    logger.error(e.getMessage(),e);
                } finally {
                    writer.close();
                }
                return null;
            }

        } else {
            return null;
        }
    }
}
