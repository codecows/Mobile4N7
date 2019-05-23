package com.snsoft.configs;

import com.snsoft.utils.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomerInterceptor implements HandlerInterceptor {
    private final static Logger logger = LoggerFactory.getLogger(CustomerInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        logger.debug("请求开始**********URL:" + httpServletRequest.getRequestURI());
        final String authorization = httpServletRequest.getHeader("x-access-token");
        final String visitor = httpServletRequest.getHeader("visitor");
        logger.debug("token:" + authorization);

        if (visitor == null || visitor.length() <= 0) {
            logger.debug("visitor 不能为空");
            return false;
        }
        if (authorization == null || !authorization.startsWith("Bearer ")) {
            logger.debug("token 不能为空");
            return false;
        }

        final String token = authorization.substring(7);
        boolean b = JwtUtil.validateToken(token, visitor);
        if (!b) {
            logger.debug("token 验证失败");
        }
        return b;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        //logger.info("请求处理中");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        logger.debug("请求结束************URL:" + httpServletRequest.getRequestURI());
    }
}
