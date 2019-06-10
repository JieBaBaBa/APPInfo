package com.clyy.controller;

import com.clyy.pojo.AppInfo;
import com.clyy.service.AppInfoService;
import com.clyy.util.PageSupport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping(value = "/list.html")
    public String list(@RequestParam(value = "pageIndex",required = false,defaultValue = "1")Integer pageIndex,
                       @RequestParam(value = "pageSize",required = false,defaultValue = "10")Integer pageSize, Model model){

        PageSupport<AppInfo> pageSupport = appInfoService.findAppInfoByPage(pageIndex, pageSize);
        model.addAttribute("pageSupport",pageSupport);
        return "appinfolist";
    }
}
