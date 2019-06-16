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
@RequestMapping(value = "/appInfo")
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

        return "developer/appinfolist";
    }

    /**
     * 分页查询
     * @param softwareName
     * @param pageIndex
     * @param pageSize
     * @param model
     * @return
     */
    @RequestMapping(value = "/list.html")
    public String list(@RequestParam(value = "softwareName",required = false,defaultValue = "")String softwareName,
                       @RequestParam(value = "pageIndex",required = false,defaultValue = "1")Integer pageIndex,
                       @RequestParam(value = "pageSize",required = false,defaultValue = "5")Integer pageSize, Model model){

        PageSupport<AppInfo> pageSupport = appInfoService.findAppInfoByPage(softwareName,pageIndex, pageSize);
        model.addAttribute("pageSupport",pageSupport);
        return "developer/appinfolist";
    }

    /**
     * 新增addinfo前，跳转到新增页面
     * @return
     */
    @RequestMapping(value = "/appinfoadd.html")
    public String appinfoadd(){
        return "appinfoadd";
    }


}
