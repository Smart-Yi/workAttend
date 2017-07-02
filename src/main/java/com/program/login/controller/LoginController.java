package com.program.login.controller;

import com.program.common.utils.SecurityUtils;
import com.program.user.entity.User;
import com.program.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by 匡小菜 on 2017/6/27.
 */
@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    private IUserService userService ;

/**
 * @Author: Smart-YI
 * @Date: 2017/6/27 15:39
 * @Description: 登陆页面
 */ 
    @RequestMapping
    public String login(){
        return "login";
    }
/**
 * @Author: Smart-YI
 * @Date: 2017/6/27 15:40
 * @Description: 检查用户名密码
 */
    @RequestMapping("/check")
    @ResponseBody
    public String checkLogin(HttpServletRequest request) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        String username = request.getParameter("username");

        String pwd = request.getParameter("password");

        //查询数据库
        User u = userService.findUserByUserName(username);

        //校验用户名密码
        if (u != null){//数据库查询为null，密码错误都返回"login_fail"

            if (SecurityUtils.checkPassword(pwd,u.getPassword())){
                //校验成功 设置session 返回"login_success"
                HttpSession session = request.getSession();

                session.setAttribute("userInfo" , u );

            }else {

                return "login_fail";
            }

        }else {
            return "login_fail";
        }

        //校验成功 返回"login_success"
        return "login_success" ;


    }


}
