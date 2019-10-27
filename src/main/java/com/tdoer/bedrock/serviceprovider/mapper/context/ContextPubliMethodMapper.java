package com.tdoer.bedrock.serviceprovider.mapper.context;

import com.tdoer.bedrock.serviceprovider.eo.context.ContextPublicMethodEO;

public interface ContextPubliMethodMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ContextPublicMethodEO record);

    int insertSelective(ContextPublicMethodEO record);

    ContextPublicMethodEO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ContextPublicMethodEO record);

    int updateByPrimaryKey(ContextPublicMethodEO record);
}