package com.clyy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    /**
     * 初始页面
     * @return
     */
    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }

}
