package com.program.user.controller;

import com.program.user.entity.User;
import com.program.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by 匡小菜 on 2017/6/25.
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private IUserService userService ;


    /**
     * @Author: Smart-YI
     * @Date: 2017/6/28 16:46
     * @params:  * @param
     * @Description:用户主页
     */
    @RequestMapping("/home")
    public String home(){

        return "home";
    }


    /**
     * @Author: Smart-YI
     * @Date: 2017/6/28 16:48
     * @params:  * @param session
     * @Description:获取session里用户信息
     */
    @RequestMapping("/getUserInfo")
    @ResponseBody
    public User getUser(HttpSession session){

        User user =  (User)session.getAttribute("userInfo");

        return user ;
    }



    /**
     * @Author: Smart-YI
     * @Date: 2017/6/28 16:51
     * @params:  * @param session
     * @Description:登出系统 摧毁session 跳转到登录页面
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session){

        session.invalidate();

        return "/login" ;
    }

}
