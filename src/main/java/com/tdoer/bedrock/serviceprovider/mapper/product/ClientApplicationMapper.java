package com.tdoer.bedrock.serviceprovider.mapper.product;

import com.tdoer.bedrock.serviceprovider.eo.product.ClientApplicationEO;

public interface ClientApplicationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ClientApplicationEO record);

    int insertSelective(ClientApplicationEO record);

    ClientApplicationEO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ClientApplicationEO record);

    int updateByPrimaryKey(ClientApplicationEO record);
}