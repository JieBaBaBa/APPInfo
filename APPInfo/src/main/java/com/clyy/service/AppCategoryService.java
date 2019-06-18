package com.clyy.service;

import com.clyy.pojo.AppCategory;

import java.util.List;

public interface AppCategoryService {

    List<AppCategory> findAppCategoryByParentId(Integer parentId);

    List<AppCategory> findAppCategoryLevel2();

    List<AppCategory> findAppCategoryLevel3();
}
