package com.program.register.controller;

import com.program.user.entity.User;
import com.program.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by 匡小菜 on 2017/6/27.
 */
@Controller
@RequestMapping("register")
public class RegisterController {
    @Autowired
    private IUserService userService ;
    /**
     * @Author: Smart-YI
     * @Date: 2017/6/27 21:28
     * @params:  * @param
     * @Description:
     */
    @RequestMapping
    public String register(){

        return "register" ;
    }
    /**
     * @Author: Smart-YI
     * @Date: 2017/6/27 22:41
     * @params:  * @param user
     * @Description:
     */
    @RequestMapping("/check")
    @ResponseBody
    public String register(HttpServletRequest request) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        User user = new User() ;
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setRealName(request.getParameter("realname"));

        User u  = userService.findUserByUserName(user.getUsername());

        if (u != null){
            return "register_fail_hasUserName" ;
        }

        userService.createUser(user);

        return "register_success";
    }
}
