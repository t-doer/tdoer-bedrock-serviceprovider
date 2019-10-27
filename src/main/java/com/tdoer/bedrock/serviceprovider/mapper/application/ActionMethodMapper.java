package com.tdoer.bedrock.serviceprovider.mapper.application;

import com.tdoer.bedrock.serviceprovider.eo.application.ActionMethodEO;

public interface ActionMethodMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ActionMethodEO record);

    int insertSelective(ActionMethodEO record);

    ActionMethodEO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ActionMethodEO record);

    int updateByPrimaryKey(ActionMethodEO record);
}