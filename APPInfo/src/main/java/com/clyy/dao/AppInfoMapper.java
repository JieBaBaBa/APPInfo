package com.clyy.dao;

import com.clyy.pojo.AppCategory;
import com.clyy.pojo.AppInfo;
import com.clyy.pojo.DataDictionary;
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
    public List<AppInfo> getAppInfoByPage(@Param(value = "softwareName") String softwareName,
                                          @Param(value = "status") String status,
                                          @Param(value = "flatformId") Integer flatformId,
                                          @Param(value = "categoryLevel1") Integer categoryLevel1,
                                          @Param(value = "categoryLevel2") Integer categoryLevel2,
                                          @Param(value = "categoryLevel3") Integer categoryLevel3,
                                          @Param(value = "pageIndex") Integer pageIndex,
                                          @Param(value = "pageSize") Integer pageSize);

    /**
     * 查总数量
     * @return
     */
    public int getAppInfoCount(@Param(value = "softwareName") String softwareName);

    /**
     * 查询所有状态
     * @return
     */
    public List<DataDictionary> getAllStatus();

    /**
     * 查询所有平台ID
     * @return
     */
    public List<DataDictionary> getAllFlatformId();

    /**
     * 查询所有一级分类
     * @return
     */
    List<AppCategory> getAppCategoryByParentId(@Param("parentId") Integer parentId);

    /**
     * 查询所有二级分类
     * @return
     */
    public List<AppCategory> getAllcategoryLevel2();

    /**
     * 查询所有三级分类
     * @return
     */
    public List<AppCategory> getAllcategoryLevel3();
}
