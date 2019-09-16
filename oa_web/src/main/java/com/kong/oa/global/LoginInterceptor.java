package com.kong.oa.global;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url=request.getRequestURI();
        //通过查看请求路径，判断是否范围的是登录界面，如果是登录页面，放行
        if(url.toLowerCase().indexOf("login")>=0){
            return true;
        }

        //判断是否登录,获取session，如果有登录信息，放行
        HttpSession session = request.getSession();
        if(session.getAttribute("employee")!=null){
            return true;
        }

        response.sendRedirect("/to_login");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
