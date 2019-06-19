package com.clyy.dao;



import com.clyy.pojo.DataDictionary;

import java.util.List;

public interface DataDictionaryMapper {


    /**
     * 所属平台
     * @return
     */
    List<DataDictionary> getPlatforms();

    /**
     * 审核状态
     * @return
     */
    List<DataDictionary> getStatus();
}
