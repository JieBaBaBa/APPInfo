package com.clyy.controller;

import com.clyy.pojo.AppCategory;
import com.clyy.pojo.AppInfo;
import com.clyy.pojo.AppVersion;
import com.clyy.pojo.DataDictionary;
import com.clyy.service.*;
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
@RequestMapping(value = "/backend")
public class BackEndController {
    @Resource
    private BackEndService backEndService;

    @Resource
    private AppCategoryService appCategoryService;

    @Resource
    private DataDictionaryService dataDictionaryService;

    @Resource
    private AppInfoService appInfoService;

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
     * @param flatformId
     * @param categoryLevel1
     * @param categoryLevel2
     * @param categoryLevel3
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
                flatformId,1,categoryLevel1,categoryLevel2,categoryLevel3,pageIndex, pageSize);
        List<DataDictionary> flatFormList=dataDictionaryService.findPlatforms();
        List<AppCategory> categoryLevel1List = appCategoryService.findAppCategoryByParentId(null);
        List<AppCategory> categoryLevel2List = appCategoryService.findAppCategoryLevel2();
        List<AppCategory> categoryLevel3List = appCategoryService.findAppCategoryLevel3();

        model.addAttribute("pageSupport",pageSupport);
        model.addAttribute("flatFormList",flatFormList);
        model.addAttribute("categoryLevel1List",categoryLevel1List);
        model.addAttribute("categoryLevel2List",categoryLevel2List);
        model.addAttribute("categoryLevel3List",categoryLevel3List);
        return "backend/applist";
    }

    /**
     * 已审核的分页查询
     * @param softwareName
     * @param flatformId
     * @param categoryLevel1
     * @param categoryLevel2
     * @param categoryLevel3
     * @param pageIndex
     * @param pageSize
     * @param model
     * @return
     */
    @RequestMapping(value = "/listChecked.html")
    public String listChecked(@RequestParam(value = "softwareName",required = false,defaultValue = "")String softwareName,
                       @RequestParam(value = "flatformId",required = false)Integer flatformId,
                       @RequestParam(value = "categoryLevel1",required = false)Integer categoryLevel1,
                       @RequestParam(value = "categoryLevel2",required = false)Integer categoryLevel2,
                       @RequestParam(value = "categoryLevel3",required = false)Integer categoryLevel3,
                       @RequestParam(value = "pageIndex",required = false,defaultValue = "1")Integer pageIndex,
                       @RequestParam(value = "pageSize",required = false,defaultValue = "5")Integer pageSize,
                       Model model){

        PageSupport<AppInfo> pageSupport = backEndService.findAuditInfoByPage(softwareName,
                flatformId,2,categoryLevel1,categoryLevel2,categoryLevel3,pageIndex, pageSize);
        List<DataDictionary> flatFormList=dataDictionaryService.findPlatforms();
        List<AppCategory> categoryLevel1List = appCategoryService.findAppCategoryByParentId(null);
        List<AppCategory> categoryLevel2List = appCategoryService.findAppCategoryLevel2();
        List<AppCategory> categoryLevel3List = appCategoryService.findAppCategoryLevel3();

        model.addAttribute("pageSupport",pageSupport);
        model.addAttribute("flatFormList",flatFormList);
        model.addAttribute("categoryLevel1List",categoryLevel1List);
        model.addAttribute("categoryLevel2List",categoryLevel2List);
        model.addAttribute("categoryLevel3List",categoryLevel3List);
        return "backend/applistchecked";
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
       model.addAttribute("appVersion",appInfo.getAppVersion());
        return "backend/appcheck";
    }

    /**
     * 提交审核
     * @return
     */
    @RequestMapping(value = "/checked.html")
    public String checked(@RequestParam(value = "id") Integer id,
                            @RequestParam(value = "status") Integer status
                            ){
        boolean flag = appInfoService.changeStatus(status, id);
        System.out.println(flag);
        return "redirect:/backend/list.html";
    }
}
