package com.tdoer.bedrock.serviceprovider.mapper.service;

import com.tdoer.bedrock.serviceprovider.eo.service.ServiceMethodEO;

public interface ServiceMethodMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ServiceMethodEO record);

    int insertSelective(ServiceMethodEO record);

    ServiceMethodEO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ServiceMethodEO record);

    int updateByPrimaryKey(ServiceMethodEO record);
}