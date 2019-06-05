package com.clyy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/test.html")
    public String test(){

        return "appinfolist";
    }
}
