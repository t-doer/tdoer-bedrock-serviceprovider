package com.tdoer.bedrock.serviceprovider.mapper.context;

import com.tdoer.bedrock.serviceprovider.eo.context.ContextRoleMethodEO;

public interface ContextRoleMethodMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ContextRoleMethodEO record);

    int insertSelective(ContextRoleMethodEO record);

    ContextRoleMethodEO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ContextRoleMethodEO record);

    int updateByPrimaryKey(ContextRoleMethodEO record);
}