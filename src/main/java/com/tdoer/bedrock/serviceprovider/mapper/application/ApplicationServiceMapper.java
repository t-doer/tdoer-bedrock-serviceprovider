package com.tdoer.bedrock.serviceprovider.mapper.application;

import com.tdoer.bedrock.serviceprovider.eo.application.ApplicationServiceEO;

public interface ApplicationServiceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ApplicationServiceEO record);

    int insertSelective(ApplicationServiceEO record);

    ApplicationServiceEO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ApplicationServiceEO record);

    int updateByPrimaryKey(ApplicationServiceEO record);
}