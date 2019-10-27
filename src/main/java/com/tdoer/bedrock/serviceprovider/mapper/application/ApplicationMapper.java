package com.tdoer.bedrock.serviceprovider.mapper.application;

import com.tdoer.bedrock.serviceprovider.eo.application.ApplicationEO;

public interface ApplicationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ApplicationEO record);

    int insertSelective(ApplicationEO record);

    ApplicationEO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ApplicationEO record);

    int updateByPrimaryKey(ApplicationEO record);
}