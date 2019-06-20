package com.clyy.dao;

import com.clyy.pojo.BackendUser;
import org.apache.ibatis.annotations.Param;

public interface BackEndMapper {
    /**
     * 登陆验证
     * @param userCode
     * @param userPassword
     * @return
     */
    BackendUser userLogin(@Param("userCode") String userCode, @Param("userPassword") String userPassword);
}
