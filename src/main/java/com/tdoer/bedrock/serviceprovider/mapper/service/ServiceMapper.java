package com.tdoer.bedrock.serviceprovider.mapper.service;

import com.tdoer.bedrock.serviceprovider.eo.service.ServiceEO;

public interface ServiceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ServiceEO record);

    int insertSelective(ServiceEO record);

    ServiceEO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ServiceEO record);

    int updateByPrimaryKey(ServiceEO record);
}