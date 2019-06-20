package com.clyy.controller;

import com.clyy.exception.LoginFailException;
import com.clyy.pojo.BackendUser;
import com.clyy.service.BackEndService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/backend")
public class BackEndController {

    @Resource
    private BackEndService backEndService;
    /**
     * 后台管理登陆
     * @return
     */
    @RequestMapping(value ="/backendlogin.html")
    public String backendlogin(){
        return "backendlogin";
    }

    /**
     * 校验账号和密码
     * @param userCode
     * @param userPassword
     * @param httpSession
     * @return
     */
    @RequestMapping("/dologin.html")
    public String dologin(@RequestParam("userCode")String userCode,
                          @RequestParam("userPassword")String userPassword,
                          HttpSession httpSession,HttpServletRequest httpServletRequest){
        //用户是否存在
        BackendUser backend_user=backEndService.userLogin(userCode,userPassword);
        if(backend_user!=null){
            //会话角色
            httpSession.setAttribute("backendUser",backend_user);
            //跳转到后台管理主页
            return "redirect:/backend/main.html";
        }
        throw new LoginFailException("用户名或密码不正确！");
    }

    /**
     * 主页
     * @param httpSession
     * @return
     */
    @RequestMapping("/main.html")
    public String main(HttpSession httpSession){
        return httpSession.getAttribute("backendUser")!=null? "backend/main": "backendlogin";
    }

    /**
     * 注销
     * @param httpSession
     * @param httpServletRequest
     * @return
     */
    @RequestMapping("logout.html")
    public String userLogin(HttpSession httpSession, HttpServletRequest httpServletRequest){
        httpSession.invalidate();
        httpServletRequest.setAttribute("message","注销成功！");
        return "backendlogin";
    }

    @ExceptionHandler
    public String handleException(Exception e, HttpServletRequest request){
        request.setAttribute("message",e.getMessage());
        return "backendlogin";
    }
}
