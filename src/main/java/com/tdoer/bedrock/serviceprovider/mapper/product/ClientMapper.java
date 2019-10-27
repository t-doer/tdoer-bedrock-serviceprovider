package com.tdoer.bedrock.serviceprovider.mapper.product;

import com.tdoer.bedrock.serviceprovider.eo.product.ClientEO;

public interface ClientMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ClientEO record);

    int insertSelective(ClientEO record);

    ClientEO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ClientEO record);

    int updateByPrimaryKey(ClientEO record);
}