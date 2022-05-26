package com.yeyi.seckill.controller.interceptor;

import com.yeyi.seckill.entity.User;
import com.yeyi.seckill.utils.CookieUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @BelongsProject: seckill-demo1
 * @BelongsPackage: com.yeyi.seckill.controller.interceptor
 * @Author: yeyi
 * @CreateTime: 2022-05-21  16:45
 * @Description: TODO
 * @Version: 1.0
 */
@Component
public class GoodsInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取session
        HttpSession session = request.getSession();
        String ticket = CookieUtil.getCookieValue(request, "userTicket");
        User user = (User) session.getAttribute(ticket);
        if(user == null){
            response.sendRedirect("/login/toLogin");
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}

