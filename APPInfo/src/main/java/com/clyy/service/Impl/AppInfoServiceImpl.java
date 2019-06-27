package com.clyy.service.Impl;

import com.clyy.dao.AppInfoMapper;
import com.clyy.pojo.AppCategory;
import com.clyy.pojo.AppInfo;
import com.clyy.pojo.AppVersion;
import com.clyy.pojo.DataDictionary;
import com.clyy.service.AppInfoService;
import com.clyy.util.PageSupport;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service(value = "appInfoServiceImpl")
public class AppInfoServiceImpl implements AppInfoService {

    @Resource
    private AppInfoMapper appInfoMapper;

    /**
     * 根据id查appinfo
     * @param id
     * @return
     */
    @Override
    public AppInfo findAppInfoById(Integer id) {
        return appInfoMapper.findAppInfoById(id);
    }

    /**
     * 分页
     *
     * @param softwareName
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Override
    public PageSupport<AppInfo> findAppInfoByPage(String softwareName, String status, Integer flatformId,
                                                  Integer categoryLevel1,Integer categoryLevel2, Integer categoryLevel3, Integer pageIndex, Integer pageSize) {

        PageSupport<AppInfo> pageSupport = new PageSupport<>();
        //总数量
        int totalCount = appInfoMapper.getAppInfoCount(softwareName,status,flatformId,categoryLevel1,categoryLevel2,categoryLevel3);
        pageSupport.setPageSize(pageSize);
        pageSupport.setTotalCount(totalCount);
        pageSupport.setCurrentPageNo(pageIndex);

        if (totalCount > 0) {
            List<AppInfo> list = appInfoMapper.getAppInfoByPage(softwareName, status, flatformId, categoryLevel1,categoryLevel2,categoryLevel3, pageSupport.getStarRow(), pageSize);
            pageSupport.setList(list);
        }

        return pageSupport;
    }

    /**
     * 查询所有状态
     *
     * @return
     */
    @Override
    public List<DataDictionary> getAllStatus() {
        return appInfoMapper.getAllStatus();
    }

    /**
     * 查询所有平台
     *
     * @return
     */
    @Override
    public List<DataDictionary> getAllFlatformId() {
        return appInfoMapper.getAllFlatformId();
    }

    /**
     * 查看所有的一级分类
     * @param parentId
     * @return
     */
    @Override
    public List<AppCategory> getAppCategoryByParentId(Integer parentId) {
        return appInfoMapper.getAppCategoryByParentId(parentId);
    }

    /**
     * 查看所有的二级分类
     * @return
     */
    @Override
    public List<AppCategory> getAllcategoryLevel2() {
        return appInfoMapper.getAllcategoryLevel2();
    }

    /**
     * 查看所有的三级分类
     * @return
     */
    @Override
    public List<AppCategory> getAllcategoryLevel3() {
        return appInfoMapper.getAllcategoryLevel3();
    }

    /**
     * 增加appInfo
     * @param appInfo
     * @return
     */
    @Override
    public int appInfoAdd(AppInfo appInfo) {
        return appInfoMapper.appInfoAdd(appInfo);
    }

    /**
     * 检查有没有重复的apkName
     * @param apkName
     * @return
     */
    @Override
    public Integer checkAPKNameExist(String apkName) {
        return appInfoMapper.checkAPKNameExist(apkName);
    }

    /**
     *修改app审核状态
     * @param status
     * @param id
     * @return
     */
    @Override
    public boolean changeStatus(Integer status, Integer id) {
        if (status ==1){
            status = 2;
        }
        System.out.println("审核状态为:"+status);
        int i = appInfoMapper.changeStatus(status, id);
        if (i>0){
            return true;
        }
        return false;
    }

    @Override
    public int updateAppInfo(AppInfo appInfo) {
        int count = appInfoMapper.updateAppInfo(appInfo);
        return count;
    }

    /**
     * 增加APP版本
     * @param appVersion
     * @return
     */
    @Override
    public int addAppVersion(AppVersion appVersion) {
        int i = appInfoMapper.addVersion(
                appVersion.getAppId(),
                appVersion.getVersionNo(),
                appVersion.getVersionInfo(),
                3,
                appVersion.getDownloadLink(),
                appVersion.getVersionSize(),
                1,
                new Date(),
                appVersion.getApkLocPath(),
                appVersion.getApkFileName());

        return i;
    }

    /**
     * 更新APP的最新版本
     * @param versionId
     * @param id
     * @return
     */
    @Override
    public boolean changeVersion(Integer versionId, Integer id) {
        int i = appInfoMapper.changeVersion(versionId, id);
        if (i>0){
            return true;
        }
        return false;
    }


    /**
     * 上架和下架
     * @param appInfoId
     * @param saleswitch 用于判定该APP当前是上架还是下架状态
     * @return
     */
    @Override
    public String updateAppStatus(Integer appInfoId, String saleswitch) {
        int afterStatus=4;
        if(saleswitch.equals("close")){
            afterStatus=5;
        }
        int count =appInfoMapper.updateAppStatus(appInfoId,afterStatus);
        return count>0?"success":"failed";
    }

    /**
     * 删除app
     * @param appId
     * @return
     */
    @Override
    public boolean delApp(Integer appId) {
        int i = appInfoMapper.delApp(appId);
        if (i>0){
            return true;
        } else {
            return false;
        }
    }

    /**
     * 查看单个app信息
     * @param id
     * @return
     */
    @Override
    public AppInfo getAppInfo(Integer id) {
        AppInfo appInfo = appInfoMapper.getAppInfo(id);
        return appInfo;
    }

}
