package com.tdoer.bedrock.serviceprovider.mapper.service;

import com.tdoer.bedrock.serviceprovider.eo.service.ServiceReferenceEO;

public interface ServiceReferenceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ServiceReferenceEO record);

    int insertSelective(ServiceReferenceEO record);

    ServiceReferenceEO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ServiceReferenceEO record);

    int updateByPrimaryKey(ServiceReferenceEO record);
}