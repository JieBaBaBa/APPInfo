package com.clyy.dao;

import com.clyy.pojo.DevUser;
import org.apache.ibatis.annotations.Param;

public interface DevMapper {

    /**
     * 登陆
     * @param devCode
     * @param devPassword
     * @return
     */
    public DevUser devLogin(@Param(value = "devCode") String devCode, @Param(value = "devPassword") String devPassword);
}
