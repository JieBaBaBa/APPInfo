package com.clyy.controller;

import com.clyy.pojo.AppVersion;
import com.clyy.service.AppVersionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/appVersion")
public class AppVersionController {

    @Resource
    private AppVersionService appVersionService;


    /**
     * 修改app最新版本
     * @param appInfoId
     * @param model
     * @return
     */
    @RequestMapping("/appversionmodify")
    public String appversionmodify(@RequestParam("aid")String appInfoId,
                                   Model model){

        List<AppVersion> appVersionList=appVersionService.findAppVersion(appInfoId);
        System.out.println("标记1");
        model.addAttribute("appVersionList",appVersionList);
        model.addAttribute("appVersion",appVersionList.get(0));
        return "developer/appversionmodify";
    }


    /**
     * 提交修改的app最新版本信息
     * @param versionNo
     * @param versionSize
     * @param versionInfo
     * @return
     */
    @RequestMapping("addversionsave")
    public String addversionsave(@RequestParam("appId")Integer appId,
                                 @RequestParam("versionNo")String versionNo,
                                 @RequestParam("versionSize")float versionSize,
                                 @RequestParam("versionInfo")String versionInfo
                                 ){

        int count=appVersionService.updateAppVersion(versionSize,versionInfo,versionNo);
        if(count!=0)
            return "redirect:/appInfo/list.html";
        return "";
    }
}
