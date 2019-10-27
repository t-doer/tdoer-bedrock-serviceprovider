package com.tdoer.bedrock.serviceprovider.mapper.product;

import com.tdoer.bedrock.serviceprovider.eo.product.ClientContextEO;

public interface ClientContextMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ClientContextEO record);

    int insertSelective(ClientContextEO record);

    ClientContextEO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ClientContextEO record);

    int updateByPrimaryKey(ClientContextEO record);
}