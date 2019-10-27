package com.tdoer.bedrock.serviceprovider.mapper.product;

import com.tdoer.bedrock.serviceprovider.eo.product.NavigationItemEO;

public interface NavigationItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(NavigationItemEO record);

    int insertSelective(NavigationItemEO record);

    NavigationItemEO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NavigationItemEO record);

    int updateByPrimaryKey(NavigationItemEO record);
}