package com.tdoer.bedrock.serviceprovider.mapper.context;

import com.tdoer.bedrock.serviceprovider.eo.context.ContextTypeEO;

public interface ContextTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ContextTypeEO record);

    int insertSelective(ContextTypeEO record);

    ContextTypeEO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ContextTypeEO record);

    int updateByPrimaryKey(ContextTypeEO record);
}