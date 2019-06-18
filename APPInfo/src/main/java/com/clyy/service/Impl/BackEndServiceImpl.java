package com.clyy.service.Impl;

import com.clyy.dao.BackEndMapper;
import com.clyy.pojo.AppInfo;
import com.clyy.pojo.AppVersion;
import com.clyy.service.BackEndService;
import com.clyy.util.PageSupport;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "backEndServiceImpl")
public class BackEndServiceImpl implements BackEndService {
    @Resource
     private BackEndMapper backEndMapper;
    /**
     * BackEnd分页
     * @param softwareName
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Override
    public PageSupport<AppInfo> findAuditInfoByPage(String softwareName,
                                                    Integer flatformId,
                                                    Integer categoryLevel1,
                                                    Integer categoryLevel2,
                                                    Integer categoryLevel3,
                                                    Integer pageIndex,
                                                    Integer pageSize) {
        PageSupport<AppInfo> pageSupport = new PageSupport<>();
        //总数量
        int totalCount = backEndMapper.getAuditInfoCount(softwareName,flatformId,categoryLevel1,categoryLevel2,categoryLevel3);
        pageSupport.setPageSize(pageSize);
        pageSupport.setTotalCount(totalCount);
        pageSupport.setCurrentPageNo(pageIndex);

        if (totalCount>0){
            List<AppInfo> list = backEndMapper.getAuditInfoByPage(softwareName,flatformId,categoryLevel1,categoryLevel2,categoryLevel3,pageSupport.getStarRow(), pageSize);
            pageSupport.setList(list);
        }

        return pageSupport;
    }

    /**
     * 根据ID获取审核APP的信息
     * @param id
     * @return
     */
    @Override
    public AppInfo getAppInfo(Integer id) {
  /*      AppInfo appInfo = appInfoMapper.getAppInfo(id);
//        AppVersion lastAppVersion = appVersionMapper.getAppVersionByAppId(appInfo.getId());
        List<AppVersion> lastAppVersion = appVersionMapper.getVersionListById(appInfo.getId());
        AppVersion appVersion= appVersionMapper.getAppVersionByAppId(appInfo.getId());
        appInfo.setVersionList(lastAppVersion);
        appInfo.setLastAppVersion(appVersion);*/
//        System.out.println("Service lastAppVersion --" + lastAppVersion.get(0).getVersionNo());
       /* return appInfo;*/
        return null;
    }
}
