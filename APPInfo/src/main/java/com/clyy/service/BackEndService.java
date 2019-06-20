package com.clyy.service;

import com.clyy.pojo.BackendUser;

public interface BackEndService {
    /**
     * 登陆验证
     * @param userCode
     * @param userPassword
     * @return
     */
    public BackendUser userLogin(String userCode, String userPassword);
}
