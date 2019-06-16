package com.clyy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping(value = "/backend")
public class BackEndController {
    /**
     * 后台管理登陆
     * @return
     */
    @RequestMapping(value ="/backendlogin.html")
    public String backendlogin(){
        return "backendlogin";
    }
}
