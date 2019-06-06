package com.clyy.controller;

import com.clyy.pojo.AppInfo;
import com.clyy.service.AppInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/appinfo")
public class AppInfoController {

    @Resource
    private AppInfoService appInfoService;

    /**
     * 测试
     * @return
     */
    @RequestMapping("/test.html")
    public String test(){

        return "appinfolist";
    }

    /**
     * 查找所有AppInfo
     * @return
     */
    @RequestMapping(value = "/appinfolist.html")
    public String appInfoList(Model model){
        List<AppInfo> appinfolist = appInfoService.findAllAppInfo();
        model.addAttribute("appinfolist",appinfolist);

        return "appinfolist";
    }
}
