package com.clyy.service;

import com.clyy.pojo.AppCategory;
import com.clyy.pojo.AppInfo;
import com.clyy.pojo.AppVersion;
import com.clyy.pojo.DataDictionary;
import com.clyy.util.PageSupport;

import java.util.List;

public interface AppInfoService {

    /**
     * 根据id查appinfo
     * @return
     */
    public AppInfo findAppInfoById(Integer id);

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

    /**
     * 增加appInfo
     * @param appInfo
     * @return
     */
    public int appInfoAdd(AppInfo appInfo);

    /**
     * 检查有没有重复的apkName
     * @param apkName
     * @return
     */
    public Integer checkAPKNameExist(String apkName);


    /**
     *修改app审核状态
     * @param status
     * @param id
     * @return
     */
    boolean changeStatus(Integer status, Integer id);

    /**
     * 修改appInfo信息
     * @param appInfo
     * @return
     */
    public int updateAppInfo(AppInfo appInfo);



    /**
     * 增加APP版本
     * @param appVersion
     * @return
     */
    int addAppVersion(AppVersion appVersion);

    /**
     * 更新APP的最新版本
     * @param versionId
     * @param id
     * @return
     */

    boolean changeVersion(Integer versionId, Integer id);
    /**
     * 上架和下架
     * @param appInfoId
     * @param saleswitch 用于判定该APP当前是上架还是下架状态
     * @return
     */
    public String updateAppStatus(Integer appInfoId,String saleswitch);

    /**
     * 删除app
     * @param id
     * @return
     */
    boolean delApp(Integer id);

    /**
     * 查看单个app信息
     * @param id
     * @return
     */
    AppInfo getAppInfo(Integer id);

}
