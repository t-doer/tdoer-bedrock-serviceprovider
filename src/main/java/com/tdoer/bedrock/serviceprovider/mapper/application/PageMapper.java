package com.tdoer.bedrock.serviceprovider.mapper.application;

import com.tdoer.bedrock.serviceprovider.eo.application.PageEO;

public interface PageMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PageEO record);

    int insertSelective(PageEO record);

    PageEO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PageEO record);

    int updateByPrimaryKey(PageEO record);
}