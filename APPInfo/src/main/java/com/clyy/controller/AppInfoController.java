package com.clyy.controller;

import com.clyy.pojo.AppCategory;
import com.clyy.pojo.AppInfo;
import com.clyy.pojo.DataDictionary;
import com.clyy.service.AppInfoService;
import com.clyy.util.PageSupport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
                       @RequestParam(value = "queryStatus",required = false,defaultValue = "") @ModelAttribute String status,
                       @RequestParam(value = "queryFlatformId",required = false,defaultValue = "") @ModelAttribute Integer flatformId,
                       @RequestParam(value = "queryCategoryLevel1",required = false,defaultValue = "") @ModelAttribute Integer categoryLevel1,
                       @RequestParam(value = "queryCategoryLevel2",required = false,defaultValue = "") @ModelAttribute Integer categoryLevel2,
                       @RequestParam(value = "queryCategoryLevel3",required = false,defaultValue = "") @ModelAttribute Integer categoryLevel3,
                       @RequestParam(value = "pageIndex",required = false,defaultValue = "1")Integer pageIndex,
                       @RequestParam(value = "pageSize",required = false,defaultValue = "5")Integer pageSize, Model model){

        PageSupport<AppInfo> pageSupport = appInfoService.findAppInfoByPage(softwareName,status,flatformId,categoryLevel1,categoryLevel2,categoryLevel3,pageIndex, pageSize);
        model.addAttribute("pageSupport",pageSupport);
        List<DataDictionary> statusList = appInfoService.getAllStatus();
        model.addAttribute("statusList",statusList);
        List<DataDictionary> flatFormList = appInfoService.getAllFlatformId();
        model.addAttribute("flatFormList",flatFormList);
        List<AppCategory> categoryLevel1List = appInfoService.getAppCategoryByParentId(null);
        model.addAttribute("categoryLevel1List",categoryLevel1List);
        List<AppCategory> categoryLevel2List = appInfoService.getAllcategoryLevel2();
        model.addAttribute("categoryLevel2List",categoryLevel2List);
        List<AppCategory> categoryLevel3List = appInfoService.getAllcategoryLevel3();
        model.addAttribute("categoryLevel3List",categoryLevel3List);
        return "developer/appinfolist";
    }

    /**
     * 新增addinfo前，跳转到新增页面
     * @return
     */
    @RequestMapping(value = "/appinfoadd.html")
    public String appinfoadd(){
        return "developer/appinfoadd";
    }

    /**
     * 校验分类
     * @param parentId
     * @return
     */
    @RequestMapping("/getAppCategory.json")
    @ResponseBody
    public Object getAppCategory(@RequestParam(value = "parentId",required = false) Integer parentId){
        List<AppCategory> appCategoryList = appInfoService.getAppCategoryByParentId(parentId);
        System.out.println("==============================================");
        return appCategoryList;
    }

}
