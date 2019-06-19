package com.clyy.service.Impl;


import com.clyy.dao.DataDictionaryMapper;
import com.clyy.pojo.DataDictionary;
import com.clyy.service.DataDictionaryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DataDictionaryServiceImpl implements DataDictionaryService {

    @Resource
    private DataDictionaryMapper dataDictionaryMapper;

    @Override
    public List<DataDictionary> findPlatforms() {
        return dataDictionaryMapper.getPlatforms();
    }

    @Override
    public List<DataDictionary> findStatus() {
        return dataDictionaryMapper.getStatus();
    }
}
