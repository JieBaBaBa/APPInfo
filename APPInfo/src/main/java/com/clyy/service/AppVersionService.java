package com.clyy.service;


import com.clyy.pojo.AppVersion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppVersionService {

    AppVersion findAppVersionByAppId(@Param("appId") Integer appId);

    List<AppVersion> findVersionListById(@Param("appId") Integer appId);

    boolean addVersion(AppVersion appVersion);
}
