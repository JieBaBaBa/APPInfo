package com.clyy.service;

import com.clyy.pojo.AppInfo;
import com.clyy.pojo.AppVersion;
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
    public PageSupport<AppInfo> findAppInfoByPage(String softwareName,String status,Integer pageIndex, Integer pageSize);

    /**
     * 查询所有状态
     * @return
     */
    public List<DataDictionary> getallstatus();

    /**
     * 所要修改的app的版本信息
     * @param versionId
     * @param appInfoId
     * @return
     */
    public List<AppVersion> findAppVersion(String appInfoId);

}
