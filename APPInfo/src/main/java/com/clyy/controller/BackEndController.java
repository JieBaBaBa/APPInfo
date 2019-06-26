package com.clyy.controller;

import com.clyy.exception.LoginFailException;
import com.clyy.pojo.*;
import com.clyy.service.*;
import com.clyy.util.PageSupport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    @Resource
    private AppVersionService appVersionService;


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
        AppVersion appVersion=appVersionService.findAppVersionByAppId(aid);
        model.addAttribute("appInfo",appInfo);
       model.addAttribute("appVersion",appVersion);
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

    /**
     * 后台管理登陆
     * @return
     */
    @RequestMapping(value ="/backendlogin.html")
    public String backendlogin(){
        return "backendlogin";
    }

    /**
     * 校验账号和密码
     * @param userCode
     * @param userPassword
     * @param httpSession
     * @return
     */
    @RequestMapping("/dologin.html")
    public String dologin(@RequestParam("userCode")String userCode,
                          @RequestParam("userPassword")String userPassword,
                          HttpSession httpSession,HttpServletRequest httpServletRequest){
        //用户是否存在
        BackendUser backend_user=backEndService.userLogin(userCode,userPassword);
        if(backend_user!=null){
            //会话角色
            httpSession.setAttribute("backendUser",backend_user);
            //跳转到后台管理主页
            return "redirect:/backend/main.html";
        }
        throw new LoginFailException("用户名或密码不正确！");
    }

    /**
     * 主页
     * @param httpSession
     * @return
     */
    @RequestMapping("/main.html")
    public String main(HttpSession httpSession){
        return httpSession.getAttribute("backendUser")!=null? "backend/main": "backendlogin";
    }

    /**
     * 注销
     * @param httpSession
     * @param httpServletRequest
     * @return
     */
    @RequestMapping("logout.html")
    public String userLogin(HttpSession httpSession, HttpServletRequest httpServletRequest){
        httpSession.invalidate();
        httpServletRequest.setAttribute("message","注销成功！");
        return "backendlogin";
    }

    @ExceptionHandler
    public String handleException(Exception e, HttpServletRequest request){
        request.setAttribute("message",e.getMessage());
        return "backendlogin";
    }


}
