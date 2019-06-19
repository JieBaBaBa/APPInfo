package com.clyy.service;

import com.clyy.pojo.AppInfo;
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
     * Dev分页查找
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
     *修改app审核状态
     * @param status
     * @param id
     * @return
     */
    boolean changeStatus(Integer status, Integer id);

}
