package com.tdoer.bedrock.serviceprovider.mapper.application;

import com.tdoer.bedrock.serviceprovider.eo.application.ActionEO;

public interface ActionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ActionEO record);

    int insertSelective(ActionEO record);

    ActionEO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ActionEO record);

    int updateByPrimaryKey(ActionEO record);
}