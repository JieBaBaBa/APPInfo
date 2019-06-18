package com.clyy.controller;

import com.clyy.pojo.AppInfo;
import com.clyy.pojo.DataDictionary;
import com.clyy.service.AppInfoService;
import com.clyy.service.BackEndService;
import com.clyy.util.PageSupport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@SessionAttributes(value = "pageSupport" ,types = PageSupport.class)
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



    /*
    * 尹维立
    * */

    /**
     * 待审核的分页查询
     * @param softwareName
     * @param pageIndex
     * @param pageSize
     * @param model
     * @return
     */
    @RequestMapping(value = "/list.html")
    public String list(@RequestParam(value = "softwareName",required = false,defaultValue = "")String softwareName,
                       @RequestParam(value = "flatformId",required = false)Integer flatformId,
                       @RequestParam(value = "categoryLevel1",required = false)Integer categoryLevel1,
                       @RequestParam(value = "categoryLevel2",required = false)Integer categoryLevel2,
                       @RequestParam(value = "categoryLevel3",required = false)Integer categoryLevel3,
                       @RequestParam(value = "pageIndex",required = false,defaultValue = "1")Integer pageIndex,
                       @RequestParam(value = "pageSize",required = false,defaultValue = "5")Integer pageSize,
                       Model model){

        PageSupport<AppInfo> pageSupport = backEndService.findAuditInfoByPage(softwareName,
                flatformId,categoryLevel1,categoryLevel2,categoryLevel3,pageIndex, pageSize);
        model.addAttribute("pageSupport",pageSupport);
        return "backend/applist";
    }

    /**
     * 跳转到审核页面
     * @return
     */
    @RequestMapping(value = "/check.html")
    public Object check(@RequestParam(value = "aid") Integer aid,
                        Model model){
        AppInfo appInfo = backEndService.getAppInfo(aid);
        model.addAttribute("appInfo",appInfo);
       // model.addAttribute("appVersion",appInfo.getLastAppVersion());
        return "backend/appcheck";
    }
}
