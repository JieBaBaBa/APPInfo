package com.clyy.service.Impl;


import com.clyy.dao.AppVersionMapper;
import com.clyy.pojo.AppVersion;
import com.clyy.service.AppVersionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AppVersionServiceImpl implements AppVersionService {

    @Resource
    private AppVersionMapper appVersionMapper;

    @Override
    public AppVersion findAppVersionByAppId(Integer appId) {
        return appVersionMapper.getAppVersionByAppId(appId);
    }

    @Override
    public List<AppVersion> findVersionListById(Integer appId) {
        return appVersionMapper.getVersionListById(appId);
    }

    @Override
    public boolean addVersion(AppVersion appVersion) {
        return false;
    }
}
