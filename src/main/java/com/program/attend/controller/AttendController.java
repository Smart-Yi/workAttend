package com.program.attend.controller;

import com.program.attend.entity.Attend;
import com.program.attend.service.AttendServiceImpl;
import com.program.attend.service.IAttendService;
import com.program.attend.vo.QueryCondition;
import com.program.common.page.PageQueryBean;
import com.program.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 匡小菜 on 2017/6/28.
 */
@Controller
@RequestMapping("attend")
public class AttendController {
    @Autowired
    private IAttendService attendService ;

    @RequestMapping
    public String toAttend (){

        return "attend" ;
    }

    /**
     * @Author: Smart-YI
     * @Date: 2017/6/28 21:01
     * @params:  * @param attend
     * @Description:
     */
    @RequestMapping("/sign")
    @ResponseBody
    public String signAttend(HttpSession session) throws Exception {

        //获得用户ID 保存到attend
        User user = (User)session.getAttribute("userInfo");

        Long userID = user.getId() ;

        Attend attend = new Attend() ;

        attend.setUserId(userID);

        attendService.signAttend(attend);


        return "success" ;
    }


    @RequestMapping("/attendList")
    @ResponseBody
    public PageQueryBean list(QueryCondition queryCondition,HttpSession  session){

        User user = (User) session.getAttribute("userInfo") ;

        Long userId = user.getId() ;

        queryCondition.setUserId(userId);

        PageQueryBean pageQueryBean = attendService.listAttend(queryCondition);

        return pageQueryBean ;
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test(@RequestBody Attend attend){


        attendService.test(attend);

        return "success" ;
    }

}
