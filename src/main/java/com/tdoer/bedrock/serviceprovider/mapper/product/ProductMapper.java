package com.tdoer.bedrock.serviceprovider.mapper.product;

import com.tdoer.bedrock.serviceprovider.eo.product.ProductEO;

public interface ProductMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProductEO record);

    int insertSelective(ProductEO record);

    ProductEO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductEO record);

    int updateByPrimaryKey(ProductEO record);
}