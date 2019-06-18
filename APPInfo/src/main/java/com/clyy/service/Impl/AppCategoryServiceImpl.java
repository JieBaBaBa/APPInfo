package com.clyy.service.Impl;

import com.clyy.dao.AppCategoryMapper;
import com.clyy.pojo.AppCategory;
import com.clyy.service.AppCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AppCategoryServiceImpl implements AppCategoryService {

    @Resource
    private AppCategoryMapper appCategoryMapper;
    @Override
    public List<AppCategory> findAppCategoryByParentId(Integer parentId) {
        return appCategoryMapper.getAppCategoryByParentId(parentId);
    }

    @Override
    public List<AppCategory> findAppCategoryLevel2() {
        return appCategoryMapper.getAppCategoryLevel2();
    }

    @Override
    public List<AppCategory> findAppCategoryLevel3() {
        return appCategoryMapper.getAppCategoryLevel3();
    }
}
