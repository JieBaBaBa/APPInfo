package com.clyy.service;

import com.clyy.pojo.AppInfo;
import com.clyy.pojo.BackendUser;
import com.clyy.util.PageSupport;

public interface BackEndService {
    /**
     * BackEnd审核APP的分页查找
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public PageSupport<AppInfo> findAuditInfoByPage(String softwareName,
                                                    Integer flatformId,
                                                    Integer status,
                                                    Integer categoryLevel1,
                                                    Integer categoryLevel2,
                                                    Integer categoryLevel3,
                                                    Integer pageIndex,
                                                    Integer pageSize);
                                                    //获取单个app信息到审核列表中
                                                    AppInfo getAppInfo(Integer id);

    /**
     * 登陆验证
     * @param userCode
     * @param userPassword
     * @return
     */
    public BackendUser userLogin(String userCode, String userPassword);


}
