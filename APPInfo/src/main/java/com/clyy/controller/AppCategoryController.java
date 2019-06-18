package com.clyy.controller;

import com.clyy.pojo.AppCategory;
import com.clyy.service.AppCategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/appCategory")
public class AppCategoryController {

    @Resource
    private AppCategoryService appCategoryService;
    @RequestMapping("/getAppCategoryByParentId.json")
    @ResponseBody
    public Object getAppCategoryByParentId(@RequestParam(value = "parentId",required = false) Integer parentId){
        List<AppCategory> appCategoryList = appCategoryService.findAppCategoryByParentId(parentId);
        return appCategoryList;
    }
}
