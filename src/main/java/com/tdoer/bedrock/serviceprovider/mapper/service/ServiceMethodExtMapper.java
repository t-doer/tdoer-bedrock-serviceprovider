package com.tdoer.bedrock.serviceprovider.mapper.service;

import com.tdoer.bedrock.serviceprovider.eo.service.ServiceMethodExtEO;

public interface ServiceMethodExtMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ServiceMethodExtEO record);

    int insertSelective(ServiceMethodExtEO record);

    ServiceMethodExtEO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ServiceMethodExtEO record);

    int updateByPrimaryKey(ServiceMethodExtEO record);
}