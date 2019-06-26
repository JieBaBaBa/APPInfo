package com.clyy.dao;

import com.clyy.pojo.AppCategory;
import com.clyy.pojo.AppInfo;
import com.clyy.pojo.DataDictionary;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component(value = "appInfoMapper")
public interface AppInfoMapper {

    /**
     * 根据id查appinfo
     * @return
     */
    public AppInfo findAppInfoById(@Param(value = "id") Integer id);

    /**
     * 分页查找
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public List<AppInfo> getAppInfoByPage(@Param(value = "softwareName") String softwareName,
                                          @Param(value = "status") String status,
                                          @Param(value = "flatformId") Integer flatformId,
                                          @Param(value = "categoryLevel1") Integer categoryLevel1,
                                          @Param(value = "categoryLevel2") Integer categoryLevel2,
                                          @Param(value = "categoryLevel3") Integer categoryLevel3,
                                          @Param(value = "pageIndex") Integer pageIndex,
                                          @Param(value = "pageSize") Integer pageSize);

    /**
     * 查总数量
     * @return
     */
    public int getAppInfoCount(@Param(value = "softwareName") String softwareName,
                               @Param(value = "status") String status,
                               @Param(value = "flatformId") Integer flatformId,
                               @Param(value = "categoryLevel1") Integer categoryLevel1,
                               @Param(value = "categoryLevel2") Integer categoryLevel2,
                               @Param(value = "categoryLevel3") Integer categoryLevel3);

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
    List<AppCategory> getAppCategoryByParentId(@Param("parentId") Integer parentId);

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
    public Integer checkAPKNameExist(@Param(value = "APKName") String apkName);

    /**
     * 修改app审核状态
     * @param status
     * @param id
     * @return
     */
    int changeStatus(@Param(value = "status")Integer status,
                     @Param(value = "id") Integer id);

    /**
     * 修改appInfo信息
     * @param appInfo
     * @return
     */
    public int updateAppInfo(AppInfo appInfo);

    /**
     *增加APP版本信息
     * @param appId
     * @param versionNo
     * @param versionInfo
     * @param publishStatus
     * @param downloadLink
     * @param versionSize
     * @param createdBy
     * @param creationDate
     * @param apkLocPath
     * @param apkFileName
     * @return
     */
    int addVersion(@Param(value = "appId") Integer appId,
                   @Param(value = "versionNo") String versionNo,
                   @Param(value = "versionInfo") String versionInfo,
                   @Param(value = "publishStatus") Integer publishStatus,
                   @Param(value = "downloadLink") String downloadLink,
                   @Param(value = "versionSize") float versionSize,
                   @Param(value = "createdBy") Integer createdBy,
                   @Param(value = "creationDate") Date creationDate,
                   @Param(value = "apkLocPath") String apkLocPath,
                   @Param(value = "apkFileName") String apkFileName);

    /**
     * 更新上架或下架状态
     * @param appInfoId
     * @param afterStatus
     * @return
     */
    public int updateAppStatus(@Param("appInfoId")Integer appInfoId,
                               @Param("afterStatus")Integer afterStatus);


    /**
     * 删除app
     * @param id
     * @return
     */
    int delApp(@Param(value = "id") Integer id);

    /**
     * 查看单个app的信息
     * @param id
     * @return
     */
    AppInfo getAppInfo(@Param(value = "id") Integer id);
}
