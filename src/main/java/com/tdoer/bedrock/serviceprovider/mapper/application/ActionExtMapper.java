package com.tdoer.bedrock.serviceprovider.mapper.application;

import com.tdoer.bedrock.serviceprovider.eo.application.ActionExtEO;

public interface ActionExtMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ActionExtEO record);

    int insertSelective(ActionExtEO record);

    ActionExtEO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ActionExtEO record);

    int updateByPrimaryKey(ActionExtEO record);
}