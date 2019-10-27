package com.tdoer.bedrock.serviceprovider.mapper.tenant;

import com.tdoer.bedrock.serviceprovider.eo.tenant.TenantEO;

public interface TenantMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TenantEO record);

    int insertSelective(TenantEO record);

    TenantEO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TenantEO record);

    int updateByPrimaryKey(TenantEO record);
}