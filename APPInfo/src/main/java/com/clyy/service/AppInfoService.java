package com.clyy.service;

import com.clyy.pojo.AppInfo;
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
    public PageSupport<AppInfo> findAppInfoByPage(String softwareName,Integer pageIndex, Integer pageSize);
}
