package com.clyy.service.Impl;

import com.clyy.dao.AppInfoMapper;
import com.clyy.pojo.AppInfo;
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

    @Override
    public PageSupport<AppInfo> findAppInfoByPage(String softwareName,Integer pageIndex, Integer pageSize) {

        PageSupport<AppInfo> pageSupport = new PageSupport<>();
        //总数量
        int totalCount = appInfoMapper.getAppInfoCount(softwareName);
        pageSupport.setPageSize(pageSize);
        pageSupport.setTotalCount(totalCount);
        pageSupport.setCurrentPageNo(pageIndex);

        if (totalCount>0){
            List<AppInfo> list = appInfoMapper.getAppInfoByPage(softwareName,pageSupport.getStarRow(), pageSize);
            for (AppInfo ai:list) {


                //变换名
                if (("1").equals(ai.getFlatformId())){
                    ai.setFlatformId("手机");
                }else if (("2").equals(ai.getFlatformId())){
                    ai.setFlatformId("平板");
                }else if (("3").equals(ai.getFlatformId())){
                    ai.setFlatformId("通用");
                }
                if (("1").equals(ai.getStatus())){
                    ai.setStatus("待审核");
                }else if (("2").equals(ai.getStatus())){
                    ai.setStatus("审核通过");
                }else if (("3").equals(ai.getStatus())){
                    ai.setStatus("审核未通过");
                }else if (("4").equals(ai.getStatus())){
                    ai.setStatus("已上架");
                }else if (("5").equals(ai.getStatus())){
                    ai.setStatus("已下架");
                }
                if (("1").equals(ai.getCategoryLevel1())){
                    ai.setCategoryLevel1("全部应用");
                }else if (("2").equals(ai.getCategoryLevel1())){
                    ai.setCategoryLevel1("全部游戏");
                }
                if (("3").equals(ai.getCategoryLevel2())){
                    ai.setCategoryLevel2("系统工具");
                }else if (("4").equals(ai.getCategoryLevel2())){
                    ai.setCategoryLevel2("桌面插件");
                }else if (("19").equals(ai.getCategoryLevel2())){
                    ai.setCategoryLevel2("休闲游戏");
                }else if (("20").equals(ai.getCategoryLevel2())){
                    ai.setCategoryLevel2("益智游戏");
                }
                if (("29").equals(ai.getCategoryLevel3())){
                    ai.setCategoryLevel3("输入法");
                }else if (("30").equals(ai.getCategoryLevel3())){
                    ai.setCategoryLevel3("文件管理");
                }else if (("32").equals(ai.getCategoryLevel3())){
                    ai.setCategoryLevel3("安全防护");
                }else if (("37").equals(ai.getCategoryLevel3())){
                    ai.setCategoryLevel3("锁屏");
                }else if (("38").equals(ai.getCategoryLevel3())){
                    ai.setCategoryLevel3("跳舞");
                }else if (("41").equals(ai.getCategoryLevel3())){
                    ai.setCategoryLevel3("冒险");
                }else if (("43").equals(ai.getCategoryLevel3())){
                    ai.setCategoryLevel3("解谜");
                }else if (("44").equals(ai.getCategoryLevel3())){
                    ai.setCategoryLevel3("物理");
                }


            }
            pageSupport.setList(list);
        }

        return pageSupport;
    }


}
