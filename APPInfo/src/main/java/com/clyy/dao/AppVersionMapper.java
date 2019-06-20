package com.clyy.dao;

import com.clyy.pojo.AppVersion;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("AppVersionMapper")
public interface AppVersionMapper {

    /**
     * 所要修改的app的版本信息
     * @param versionId
     * @param appInfoId
     * @return
     */
    public List<AppVersion> findAppVersion(
                                           @Param("appInfoId")String appInfoId);
}
