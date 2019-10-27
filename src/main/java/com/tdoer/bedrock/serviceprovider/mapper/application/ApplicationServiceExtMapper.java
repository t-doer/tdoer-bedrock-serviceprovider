package com.tdoer.bedrock.serviceprovider.mapper.application;

import com.tdoer.bedrock.serviceprovider.eo.application.ApplicationServiceExtEO;

public interface ApplicationServiceExtMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ApplicationServiceExtEO record);

    int insertSelective(ApplicationServiceExtEO record);

    ApplicationServiceExtEO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ApplicationServiceExtEO record);

    int updateByPrimaryKey(ApplicationServiceExtEO record);
}