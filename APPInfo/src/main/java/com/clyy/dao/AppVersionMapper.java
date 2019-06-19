package com.clyy.dao;


import com.clyy.pojo.AppVersion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppVersionMapper {

    AppVersion getAppVersionByAppId(@Param("appId") Integer appId);

    List<AppVersion> getVersionListById(@Param(value = "appId") Integer appId);


}
