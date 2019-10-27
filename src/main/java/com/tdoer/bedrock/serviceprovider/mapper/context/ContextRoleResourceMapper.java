package com.tdoer.bedrock.serviceprovider.mapper.context;

import com.tdoer.bedrock.serviceprovider.eo.context.ContextRoleResourceEO;

public interface ContextRoleResourceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ContextRoleResourceEO record);

    int insertSelective(ContextRoleResourceEO record);

    ContextRoleResourceEO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ContextRoleResourceEO record);

    int updateByPrimaryKey(ContextRoleResourceEO record);
}