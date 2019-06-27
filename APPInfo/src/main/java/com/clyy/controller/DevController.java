package com.clyy.controller;

import com.alibaba.fastjson.JSON;
import com.clyy.exception.LoginFailException;
import com.clyy.pojo.AppInfo;
import com.clyy.pojo.AppVersion;
import com.clyy.pojo.DevUser;
import com.clyy.service.*;
import org.apache.commons.io.FilenameUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/dev")
public class DevController {
    @Resource
    private DevService devService;

    @Resource
    private AppInfoService appInfoService;

    @Resource
    private AppCategoryService appCategoryService;

    @Resource
    private DataDictionaryService dataDictionaryService;

    @Resource
    private BackEndService backEndService;

    @Resource
    private AppVersionService appVersionService;
    /**
     * 开发者登陆
     * @return
     */
    @RequestMapping(value = "/devLogin.html")
    public String devLogin(){
        return "devlogin";
    }

    /**
     * 实现登陆
     * @param devCode
     * @param devPassword
     * @return
     */
    @RequestMapping(value = "/doLogin.html")
    public String doLogin(@RequestParam(value = "devCode") String devCode,
                          @RequestParam(value = "devPassword") String devPassword,
                          HttpSession session){
        DevUser devUser = devService.devLogin(devCode, devPassword);
        if (devUser!=null){
            //放到session
            session.setAttribute("devUser",devUser);
            //去主页，重定向
            return "redirect:/dev/main.html";
        }
        throw new LoginFailException("用户名或密码不正确！");
    }

    /**
     * 主页
     * @param session
     * @return
     */
    @RequestMapping(value = "/main.html")
    public String main(HttpSession session){
        if (session.getAttribute("devUser")==null){
            return "devlogin";
        }
        return "developer/main";
    }

    @RequestMapping(value = "/devLogout.html")
    public String devLogout(HttpSession session,HttpServletRequest request){
        session.invalidate();//会话失效
        request.setAttribute("message","注销成功");
        return "devlogin";
    }


    @ExceptionHandler
    public String handleException(Exception e, HttpServletRequest request){
        request.setAttribute("message",e.getMessage());
        return "devlogin";
    }



    /**
     * 跳转到新增app版本页面
     * @return
     */
    @RequestMapping(value = "/appversionadd.html")
    public String addVersion(@Param(value = "id") Integer id,
                             Model model){

        //AppInfo appInfo = backEndService.getAppInfo(id);
        List<AppVersion> appVersionList=appVersionService.findVersionListById(id);
        model.addAttribute("appId",id);
        model.addAttribute("appVersionList",appVersionList);
        return "developer/appversionadd";
    }

    @RequestMapping(value = "/appVersionSave.html")
    public String appVersionAdd(@Valid AppVersion appVersion, BindingResult result,
                                @RequestParam(value = "a_downloadLink") MultipartFile multipartFile,
                                HttpServletRequest request, HttpSession session){

//判断是否有选择文件
        if (!multipartFile.isEmpty()){
            System.out.println("realPath===============");
            //保存文件
            //文件存放的路径
            //session.getServletContext()=> application
            //getRealPath(),使用相对路径获得绝对路径,,获取是布署运行后的路径
            String realPath = session.getServletContext().getRealPath(File.separator+"statics"+File.separator+"upload"+File.separator);
            //如realPath路径不存，创建路径
            new File(realPath).mkdirs();//mkdir(),创建当前文件夹//mkdirs()递归创建文件夹

            System.out.println("realPath"+realPath);
            //检查文件是否符合要求（文件的类型，文件的大小）
            //获取文件（上传的文件名a.jpg）
            String filename = multipartFile.getOriginalFilename();//a.jpg
            //获得文名的后缀
            String suffix = FilenameUtils.getExtension(filename);//jpg
            //jpg,png,gif,bmp,jpeg
            if (!"apk".equals(suffix)){
                //不符合要求，报错
                request.setAttribute("message","上传的文件格式为apk");
                return "developer/appversionadd";
            }

            //检查文件的大小
            if (multipartFile.getSize()>1024*1024*50){
                //不符合要求，报错
                request.setAttribute("mess","上传的文件不能大于50M");
                return "developer/appversionadd";
            }

            //保存。。。。
            //文件名：UUID.randomUUID()
            //asldjkfaslkfqw02398420.jpg
            // String newFileName= UUID.randomUUID().toString().replace("-","")+"."+suffix;
            File newFile=new File(realPath,filename);
            //保存
            // 设置文件名字
            appVersion.setApkFileName(filename);
            try {
                multipartFile.transferTo(newFile);
                //设置文件存放的路径
                appVersion.setApkLocPath(realPath + "\\"+filename);

                appVersion.setDownloadLink(File.separator+"statics"+File.separator+"upload"+File.separator+filename);

            } catch (IOException e) {
                e.printStackTrace();
                request.setAttribute("message","上传失败");
                return "developer/appversionadd";
            }

        }
        System.out.println("=============================="+appVersion.getApkFileName());
        //保存数据--->service--->dao
        int count = appInfoService.addAppVersion(appVersion);
        if (count>0){
            Date date=new Date();
            Long cha=0L;
            Integer versionId=null;
            List<AppVersion> appVersionList=appVersionService.findVersionListById(appVersion.getAppId());

            for(AppVersion appVersion1:appVersionList){
                if(date.getTime()-appVersion1.getCreationDate().getTime()>cha){
                    cha=date.getTime()-appVersion1.getCreationDate().getTime();
                    versionId=appVersion1.getId();
                }else{
                    versionId=appVersion1.getId();
                }
            }

            appInfoService.changeVersion(versionId,appVersion.getAppId());
            return "redirect:/appInfo/list.html";
        }
        request.setAttribute("message","增加APP版本失败!");
        return "developer/appversionadd";

    }

    /**
     * 删除appInfo
     * @param id
     * @return
     */
    @RequestMapping(value = "/delapp.json")
    @ResponseBody
    public Object delApp(@RequestParam(value = "id") Integer id) {
        boolean b = appInfoService.delApp(id);
        Map<String,Object> jsonMap = new HashMap<>();
        if (b==true){
            jsonMap.put("result","true");
        }else {
            jsonMap.put("result","false");
        }
        String json = JSON.toJSONString(jsonMap);
        return json;
    }

    /**
     * 查看单个app信息
     * @param aid
     * @param model
     * @return
     */
    @RequestMapping(value = "/appview.html")
    public String appView(@RequestParam(value = "aid") Integer aid, Model model){
        AppInfo appInfo = appInfoService.getAppInfo(aid);
        List<AppVersion> appVersionList=appVersionService.findVersionListById(aid);
        model.addAttribute("appInfo",appInfo);
        model.addAttribute("appVersionList",appVersionList);
        return "developer/appinfoview";
    }

}
