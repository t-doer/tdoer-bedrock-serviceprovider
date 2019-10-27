package com.tdoer.bedrock.serviceprovider.mapper.application;

import com.tdoer.bedrock.serviceprovider.eo.application.PageExtEO;

public interface PageExtMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PageExtEO record);

    int insertSelective(PageExtEO record);

    PageExtEO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PageExtEO record);

    int updateByPrimaryKey(PageExtEO record);
}