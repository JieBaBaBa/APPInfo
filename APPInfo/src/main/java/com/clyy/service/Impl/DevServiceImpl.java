package com.clyy.service.Impl;

import com.clyy.dao.DevMapper;
import com.clyy.pojo.DevUser;
import com.clyy.service.DevService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "devServiceImpl")
public class DevServiceImpl implements DevService {

    @Resource
    private DevMapper devMapper;

    @Override
    public DevUser devLogin(String devCode, String devPassword) {

        return devMapper.devLogin(devCode,devPassword);
    }
}
