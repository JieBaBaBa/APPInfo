package com.clyy.service;

import com.clyy.pojo.DevUser;

public interface DevService {
    /**
     * 登陆
     * @param devCode
     * @param devPassword
     * @return
     */
    public DevUser devLogin(String devCode, String devPassword);
}
