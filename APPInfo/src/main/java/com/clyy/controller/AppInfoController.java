package com.clyy.controller;

import com.alibaba.fastjson.JSON;
import com.clyy.pojo.AppCategory;
import com.clyy.pojo.AppInfo;
import com.clyy.pojo.DataDictionary;
import com.clyy.pojo.DevUser;
import com.clyy.service.AppInfoService;
import com.clyy.util.PageSupport;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
     * 分页查询
     * @param softwareName
     * @param status
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
        return appCategoryList;
    }

    /**
     * 增加appInfo，异步查询所有平台
     * @return
     */
    @RequestMapping(value = "/flatformlist.json")
    @ResponseBody
    public Object getAllFlatformId(){
        List<DataDictionary> flatformIdList = appInfoService.getAllFlatformId();
        return flatformIdList;
    }

    /**
     * 增加appInfo
     * @param appInfo
     * @return
     */
    @RequestMapping(value = "/appinfoaddsave.html")
    public String appInfoAdd(AppInfo appInfo, HttpSession session,
                             HttpServletRequest request,@RequestParam(value = "file") MultipartFile multipartFile){

        DevUser devUser = (DevUser) session.getAttribute("devUser");
        //判断有没有登陆的人
        /*if (devUser==null){
            request.setAttribute("message","请先登陆!");
            return "login";
        }*/

        //设置增加用户的人
        //appInfo.setCreatedBy(devUser.getId());


        //判断是否有选择文件
        if (!multipartFile.isEmpty()){
            //保存文件
            //文件存放的路径
            //session.getServletContext()=> application
            //getRealPath(),使用相对路径获得绝对路径,,获取是布署运行后的路径
            String realPath = session.getServletContext().getRealPath(File.separator+"statics"+File.separator+"upload"+File.separator);
            //如realPath路径不存，创建路径
            new File(realPath).mkdirs();//mkdir(),创建当前文件夹//mkdirs()递归创建文件夹

            //检查文件是否符合要求（文件的类型，文件的大小）
            //获取文件（上传的文件名a.jpg）
            String filename = multipartFile.getOriginalFilename();//a.jpg
            //获得文名的后缀
            String suffix = FilenameUtils.getExtension(filename);//jpg
            //jpg,png,jpeg
            if (!"jpg".equals(suffix) && !"png".equals(suffix)&&  !"jpeg".equals(suffix)){
                //不符合要求，报错
                request.setAttribute("fileUploadError","上传的文件格式为jpg,png,jpeg");
                return "developer/appinfoadd";
            }

            //检查文件的大小
            if (multipartFile.getSize()>1024*50){
                //不符合要求，报错
                request.setAttribute("fileUploadError","上传的文件不能大于50k");
                return "developer/appinfoadd";
            }

            //保存。。。。
            //文件名：UUID.randomUUID()
            //asldjkfaslkfqw02398420.jpg
            String newFileName= UUID.randomUUID().toString().replace("-","")+"."+suffix;
            File newFile=new File(realPath,newFileName);

            //保存
            try {
                multipartFile.transferTo(newFile);
                //设置文件存放的路径
                appInfo.setLogoPicPath(File.separator+"statics"+File.separator+"upload"+File.separator+newFileName);
            } catch (IOException e) {
                e.printStackTrace();
                request.setAttribute("fileUploadError","上传失败");
                return "developer/appinfoadd";
            }

        }

        int count = appInfoService.appInfoAdd(appInfo);
        if (count>0){
            return "redirect:/appInfo/list.html";
        }
        request.setAttribute("fileUploadError","增加失败!");
        return "developer/appinfoadd";

    }
    
    @RequestMapping(value = "/apkexist.json")
    @ResponseBody
    public Object checkAPKNameExist(@RequestParam(value = "APKName") String apkName){
        Integer count = appInfoService.checkAPKNameExist(apkName);
        Map<String,Object> jsonMap = new HashMap<>();
        if (("").equals(apkName)){
            jsonMap.put("result","empty");
        }else if (count>0) {
            jsonMap.put("result","exist");
        } else {
            jsonMap.put("result","notExist");
        }
        String json = JSON.toJSONString(jsonMap);
        return json;
    }

    /**
     * 跳转到修改页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("appinfomodify.html")
    public String appinfomodify(@RequestParam(value = "id") Integer id,Model model){
        AppInfo appInfo = appInfoService.findAppInfoById(id);
        model.addAttribute("appInfo",appInfo);
        return "developer/appinfomodify";
    }

    @RequestMapping(value = "appinfomodifysave.html")
    public String appinfomodifysave(AppInfo appInfo,HttpServletRequest request,HttpSession session){
        DevUser devUser = (DevUser) session.getAttribute("devUser");
        //判断有没有登陆的人
        if (devUser==null){
            request.setAttribute("message","请先登陆!");
            return "devlogin";
        }

        //设置增加用户的人
        appInfo.setDevId(devUser.getId());
        appInfo.setModifyBy(devUser.getId());

        int count = appInfoService.updateAppInfo(appInfo);
        if (count>0){
            return "redirect:/appInfo/list.html";
        }
        request.setAttribute("message","修改失败");
        return "developer/appinfomodify";
    }

}
