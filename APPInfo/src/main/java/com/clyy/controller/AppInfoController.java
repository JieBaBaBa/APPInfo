package com.clyy.controller;

import com.clyy.pojo.AppInfo;
import com.clyy.pojo.AppVersion;
import com.clyy.pojo.DataDictionary;
import com.clyy.service.AppInfoService;
import com.clyy.util.PageSupport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.AbstractList;
import java.util.ArrayList;
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
                       @RequestParam(value = "queryStatus",required = false,defaultValue = "") String status,
                       @RequestParam(value = "pageIndex",required = false,defaultValue = "1")Integer pageIndex,
                       @RequestParam(value = "pageSize",required = false,defaultValue = "5")Integer pageSize, Model model){

        PageSupport<AppInfo> pageSupport = appInfoService.findAppInfoByPage(softwareName,status,pageIndex, pageSize);
        model.addAttribute("pageSupport",pageSupport);
        List<DataDictionary> statusList = appInfoService.getallstatus();
        model.addAttribute("statusList",statusList);
        return "developer/appinfolist" ;
    }

    /**
     * 新增addinfo前，跳转到新增页面
     * @return
     */
    @RequestMapping(value = "/appinfoadd.html")
    public String appinfoadd(){
        return "developer/appinfoadd";
    }


    @RequestMapping("/appversionmodify")
    public String appversionmodify(@RequestParam("vid")String versionId,
                                   @RequestParam("aid")String appInfoId,
                                   Model model){

        List<AppVersion> appVersion=appInfoService.findAppVersion(appInfoId);
        //System.out.println("啊啊啊啊啊"+appVersion.toString());
        //hSRequest.setAttribute("appVersion",appVersion);

        model.addAttribute("appVersionList",appVersion);
        return "developer/appversionmodify";
    }

}
