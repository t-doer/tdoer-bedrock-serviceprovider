package com.tdoer.bedrock.serviceprovider.mapper.product;

import com.tdoer.bedrock.serviceprovider.eo.product.ClientTokenEO;

public interface ClientTokenMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ClientTokenEO record);

    int insertSelective(ClientTokenEO record);

    ClientTokenEO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ClientTokenEO record);

    int updateByPrimaryKey(ClientTokenEO record);
}