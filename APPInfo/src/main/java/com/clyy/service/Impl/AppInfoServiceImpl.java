package com.clyy.service.Impl;

import com.clyy.dao.AppInfoMapper;
import com.clyy.pojo.AppInfo;
import com.clyy.pojo.DataDictionary;
import com.clyy.service.AppInfoService;
import com.clyy.util.PageSupport;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service(value = "appInfoServiceImpl")
public class AppInfoServiceImpl implements AppInfoService {

    @Resource
    private AppInfoMapper appInfoMapper;

    /**
     * 查找所有AppInfo
     * @return
     */
    @Override
    public List<AppInfo> findAllAppInfo() {
        return appInfoMapper.findAllAppInfo();
    }

    /**
     * 分页
     * @param softwareName
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Override
    public PageSupport<AppInfo> findAppInfoByPage(String softwareName,String status,Integer pageIndex, Integer pageSize) {

        PageSupport<AppInfo> pageSupport = new PageSupport<>();
        //总数量
        int totalCount = appInfoMapper.getAppInfoCount(softwareName);
        pageSupport.setPageSize(pageSize);
        pageSupport.setTotalCount(totalCount);
        pageSupport.setCurrentPageNo(pageIndex);

        if (totalCount>0){
            List<AppInfo> list = appInfoMapper.getAppInfoByPage(softwareName,status,pageSupport.getStarRow(), pageSize);
            pageSupport.setList(list);
        }

        return pageSupport;
    }

    /**
     * 查询所有状态
     * @return
     */
    @Override
    public List<DataDictionary> getallstatus() {
        return appInfoMapper.getallstatus();
    }
}
