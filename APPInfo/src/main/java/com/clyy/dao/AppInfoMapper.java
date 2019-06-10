package com.clyy.dao;

import com.clyy.pojo.AppInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "appInfoMapper")
public interface AppInfoMapper {

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
    public List<AppInfo> getAppInfoByPage(@Param(value = "pageIndex") Integer pageIndex,
                                          @Param(value = "pageSize") Integer pageSize);

    /**
     * 查数量
     * @return
     */
    public int getAppInfoCount();
}
