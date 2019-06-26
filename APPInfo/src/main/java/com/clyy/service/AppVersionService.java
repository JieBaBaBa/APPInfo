package com.clyy.service;


import com.clyy.pojo.AppVersion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppVersionService {

    AppVersion findAppVersionByAppId(@Param("appId") Integer appId);

    List<AppVersion> findVersionListById(@Param("appId") Integer appId);

    boolean addVersion(AppVersion appVersion);


    /**
     * 所要修改的app的版本信息
     * @param appInfoId
     * @return
     */
    public List<AppVersion> findAppVersion(String appInfoId);

    /**
     * 更新修改的app最新版本信息
     * @param versionNo
     * @param versionSize
     * @param versionInfo
     * @return
     */
    public int updateAppVersion(float versionSize,String versionInfo,String versionNo);
}
