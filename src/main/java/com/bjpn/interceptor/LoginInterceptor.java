package com.bjpn.interceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Haisong Jiang
 * @Date: 2024/03/05/19:48
 * @Description:
 */
public class LoginInterceptor implements HandlerInterceptor {
    //前置拦截  true 放行 false不放行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //为什么参数不写HttpSession 而是用 request。get
        HttpSession session = request.getSession();
        Object admin = session.getAttribute("Admin");
//        拦截器拦截所用的.action请求  当检测都有session时代表时登陆状态都可以访问放行；反之推到登陆页面
        if (admin != null) {
            //放行
            return true;
        }else{
            //response??????
            response.sendRedirect(request.getContextPath()+"login/toLogin.action");
        }
        return false;
    }
    //后置拦截
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
    //关闭资源
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
