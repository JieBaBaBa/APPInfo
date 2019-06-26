package com.clyy.service.Impl;

import com.clyy.dao.BackEndMapper;
import com.clyy.pojo.AppInfo;
import com.clyy.pojo.BackendUser;
import com.clyy.service.BackEndService;
import com.clyy.util.PageSupport;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BackEndServiceImpl implements BackEndService {
    @Resource
     private BackEndMapper backEndMapper;

    //@Resource
    //private AppVersionMapper appVersionMapper;
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
                                                    Integer status,
                                                    Integer categoryLevel1,
                                                    Integer categoryLevel2,
                                                    Integer categoryLevel3,
                                                    Integer pageIndex,
                                                    Integer pageSize) {
        PageSupport<AppInfo> pageSupport = new PageSupport<>();
        //总数量
        int totalCount = backEndMapper.getAuditInfoCount(softwareName,flatformId,status,categoryLevel1,categoryLevel2,categoryLevel3);
        pageSupport.setPageSize(pageSize);
        pageSupport.setTotalCount(totalCount);
        pageSupport.setCurrentPageNo(pageIndex);

        if (totalCount>0){
            List<AppInfo> list = backEndMapper.getAuditInfoByPage(softwareName,flatformId,status,categoryLevel1,categoryLevel2,categoryLevel3,pageSupport.getStarRow(), pageSize);
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
        AppInfo appInfo = backEndMapper.getAppInfo(id);
       //AppVersion appVersion=appVersionMapper.getAppVersionByAppId(appInfo.getId());
       //appInfo.setAppVersion(appVersion);
        return appInfo;
    }

    /**
     * BackEnd登陆
     * @param userCode
     * @param userPassword
     * @return
     */
    @Override
    public BackendUser userLogin(String userCode, String userPassword){
        return backEndMapper.userLogin(userCode,userPassword);
    }
}
