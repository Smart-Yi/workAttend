package com.program.common.interceptor;

import com.program.user.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 匡小菜 on 2017/6/27.
 */
public class SessionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
       //拿到请求uri
        String uri = request.getRequestURI();

        //判断是否在登录页面
        if (uri.indexOf("login") >= 0){
            return true ;
        }
        if (uri.indexOf("register") >= 0){
            return true ;
        }
//        if (uri.indexOf("sign") >= 0){
//            return true ;
//        }
//        if (uri.indexOf("attend") >= 0){
//            return true ;
//        }

        //拿到session
        Object object = request.getSession().getAttribute("userInfo");

        //判断session userInfo是否为空
       if (object != null){

           User user = (User) object ;

           return  true ;
       }

       //不在登录页面 且session为null 跳转到login界面 并返回FALSE
        request.getRequestDispatcher("/login").forward(request,response);

       return false ;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
