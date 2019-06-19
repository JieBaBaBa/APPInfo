package com.clyy.service;



import com.clyy.pojo.DataDictionary;

import java.util.List;

public interface DataDictionaryService {

    /**
     * 所属平台
     * @return
     */
    List<DataDictionary> findPlatforms();

    /**
     * 审核状态
     * @return
     */
    List<DataDictionary> findStatus();
}
