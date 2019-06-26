package com.clyy.dao;


import com.clyy.pojo.AppVersion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppVersionMapper {

    AppVersion getAppVersionByAppId(@Param("appId") Integer appId);

    List<AppVersion> getVersionListById(@Param(value = "appId") Integer appId);

    /**
     * 所要修改的app的版本信息
     */
    public List<AppVersion> findAppVersion(@Param("appInfoId")String appInfoId);

    /**
     * 更新app的最新版本信息
     * @param versionSize
     * @param versionInfo
     * @param versionNo
     * @return
     */
    public int updateAppVersion(
            @Param("versionSize")float versionSize,
            @Param("versionInfo")String versionInfo,
            @Param("versionNo")String versionNo);

}
