package com.clyy.service.Impl;

import com.clyy.dao.BackEndMapper;
import com.clyy.pojo.BackendUser;
import com.clyy.service.BackEndService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "backEndServiceImpl")
public class BackEndServiceImpl implements BackEndService {
    @Resource
    BackEndMapper backEndMapper;

    @Override
    public BackendUser userLogin(String userCode, String userPassword){
        return backEndMapper.userLogin(userCode,userPassword);
    }
}
