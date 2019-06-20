package com.clyy.dao;

import com.clyy.pojo.AppInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BackEndMapper {
    /**
     * BackEnd分页查找
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public List<AppInfo> getAuditInfoByPage(@Param(value = "softwareName") String softwareName,
                                            @Param(value = "flatformId") Integer flatformId,
                                            @Param(value = "status") Integer status,
                                            @Param(value = "categoryLevel1") Integer categoryLevel1,
                                            @Param(value = "categoryLevel2") Integer categoryLevel2,
                                            @Param(value = "categoryLevel3") Integer categoryLevel3,
                                            @Param(value = "pageIndex") Integer pageIndex,
                                            @Param(value = "pageSize") Integer pageSize);

    /**
     * BackEnd查总数量
     * @return
     */
    public int getAuditInfoCount(@Param(value = "softwareName") String softwareName,
                                 @Param(value = "flatformId") Integer flatformId,
                                 @Param(value = "categoryLevel1") Integer categoryLevel1,
                                 @Param(value = "categoryLevel2") Integer categoryLevel2,
                                 @Param(value = "categoryLevel3") Integer categoryLevel3);

    /**
     * 根据ID获取审核APP信息
     * @param id
     * @return
     */

    AppInfo getAppInfo(@Param(value = "id") Integer id);

}
