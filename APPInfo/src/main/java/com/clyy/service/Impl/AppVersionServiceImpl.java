package com.clyy.service.Impl;


import com.clyy.dao.AppVersionMapper;
import com.clyy.pojo.AppVersion;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AppVersionServiceImpl implements AppVersionMapper {

    @Resource
    private AppVersionMapper appVersionMapper;

    @Override
    public AppVersion getAppVersionByAppId(Integer appId) {
        return appVersionMapper.getAppVersionByAppId(appId);
    }

    @Override
    public List<AppVersion> getVersionListById(Integer appId) {
        return appVersionMapper.getVersionListById(appId);
    }

}
