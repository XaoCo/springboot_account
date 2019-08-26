package com.abc.account.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * package: com.abc.account.interceptor
 * auther： abc
 * date: 2019/8/22 14:27
 * introduce: TODO 拦截未登录就进行的一些操作，除了登录路径的其他路径都不可以访问
 */
public class LoginInterceptor implements HandlerInterceptor {

    //    实例化日志
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {       //请求进入这个拦截器
        HttpSession session = request.getSession();
        if(session.getAttribute("user_session") == null){       //判断session中有没有user信息
//            System.out.println("进入拦截器");
//            if("XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"))){
//                response.sendError(401);
//            }
            logger.error("我是拦截器，用户未登录，拦截！");
            response.sendRedirect("/login/loginHtml");     //没有user信息的话进行路由重定向
            return false;
        } else {
            logger.error("我是拦截器，session存在，放行！");
            return true;        //有的话就继续操作
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
