package com.clyy.controller;

import com.clyy.exception.LoginFailException;
import com.clyy.pojo.DevUser;
import com.clyy.service.DevService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/dev")
public class DevController {
    @Resource
    private DevService devService;
    /**
     * 开发者登陆
     * @return
     */
    @RequestMapping(value = "/devLogin.html")
    public String devLogin(){
        return "devlogin";
    }

    /**
     * 实现登陆
     * @param devCode
     * @param devPassword
     * @return
     */
    @RequestMapping(value = "/doLogin.html")
    public String doLogin(@RequestParam(value = "devCode") String devCode,
                          @RequestParam(value = "devPassword") String devPassword,
                          HttpSession session){
        DevUser devUser = devService.devLogin(devCode, devPassword);
        if (devUser!=null){
            //放到session
            session.setAttribute("devUser",devUser);
            //去主页，重定向
            return "redirect:/dev/main.html";
        }
        throw new LoginFailException("用户名或密码不正确！");
    }

    /**
     * 主页
     * @param session
     * @return
     */
    @RequestMapping(value = "/main.html")
    public String main(HttpSession session){
        if (session.getAttribute("devUser")==null){
            return "devlogin";
        }
        return "developer/main";
    }

    @RequestMapping(value = "/devLogout.html")
    public String devLogout(HttpSession session,HttpServletRequest request){
        session.invalidate();//会话失效
        request.setAttribute("message","注销成功");
        return "devlogin";
    }


    @ExceptionHandler
    public String handleException(Exception e, HttpServletRequest request){
        request.setAttribute("message",e.getMessage());
        return "devlogin";
    }


}
