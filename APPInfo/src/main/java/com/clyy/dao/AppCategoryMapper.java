package com.clyy.dao;

import com.clyy.pojo.AppCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppCategoryMapper {

    List<AppCategory> getAppCategoryByParentId(@Param("parentId") Integer parentId);

    List<AppCategory> getAppCategoryLevel2();

    List<AppCategory> getAppCategoryLevel3();
}
