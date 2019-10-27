package com.tdoer.bedrock.serviceprovider.mapper.context;

import com.tdoer.bedrock.serviceprovider.eo.context.ContextRoleEO;

public interface ContextRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ContextRoleEO record);

    int insertSelective(ContextRoleEO record);

    ContextRoleEO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ContextRoleEO record);

    int updateByPrimaryKey(ContextRoleEO record);
}