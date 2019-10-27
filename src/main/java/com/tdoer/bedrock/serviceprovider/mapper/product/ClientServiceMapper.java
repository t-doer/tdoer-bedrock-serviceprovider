package com.tdoer.bedrock.serviceprovider.mapper.product;

import com.tdoer.bedrock.serviceprovider.eo.product.ClientServiceEO;

public interface ClientServiceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ClientServiceEO record);

    int insertSelective(ClientServiceEO record);

    ClientServiceEO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ClientServiceEO record);

    int updateByPrimaryKey(ClientServiceEO record);
}