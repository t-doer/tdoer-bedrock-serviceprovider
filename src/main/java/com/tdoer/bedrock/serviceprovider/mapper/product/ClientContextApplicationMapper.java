package com.tdoer.bedrock.serviceprovider.mapper.product;

import com.tdoer.bedrock.serviceprovider.eo.product.ClientContextApplicationEO;

public interface ClientContextApplicationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ClientContextApplicationEO record);

    int insertSelective(ClientContextApplicationEO record);

    ClientContextApplicationEO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ClientContextApplicationEO record);

    int updateByPrimaryKey(ClientContextApplicationEO record);
}