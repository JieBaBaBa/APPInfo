package com.clyy.service;

import com.clyy.pojo.AppCategory;
import com.clyy.pojo.AppInfo;
import com.clyy.pojo.DataDictionary;
import com.clyy.util.PageSupport;

import java.util.List;

public interface AppInfoService {

    /**
     * 查找所有AppInfo
     * @return
     */
    public List<AppInfo> findAllAppInfo();

    /**
     * 分页查找
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public PageSupport<AppInfo> findAppInfoByPage(String softwareName,String status,Integer flatformId, Integer pageIndex,
                                                  Integer categoryLevel1,Integer categoryLevel2,Integer categoryLevel3,Integer pageSize);

    /**
     * 查询所有状态
     * @return
     */
    public List<DataDictionary> getAllStatus();

    /**
     * 查询所有平台ID
     * @return
     */
    public List<DataDictionary> getAllFlatformId();

    /**
     * 查询所有一级分类
     * @return
     */
    List<AppCategory> getAppCategoryByParentId(Integer parentId);

    /**
     * 查询所有二级分类
     * @return
     */
    public List<AppCategory> getAllcategoryLevel2();

    /**
     * 查询所有三级分类
     * @return
     */
    public List<AppCategory> getAllcategoryLevel3();
}
