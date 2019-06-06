package com.clyy.service;

import com.clyy.pojo.AppInfo;

import java.util.List;

public interface AppInfoService {

    /**
     * 查找所有AppInfo
     * @return
     */
    public List<AppInfo> findAllAppInfo();
}
