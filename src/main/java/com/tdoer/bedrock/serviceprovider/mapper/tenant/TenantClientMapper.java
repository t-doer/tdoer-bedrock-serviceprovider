package com.tdoer.bedrock.serviceprovider.mapper.tenant;

import com.tdoer.bedrock.serviceprovider.eo.tenant.TenantClientEO;

public interface TenantClientMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TenantClientEO record);

    int insertSelective(TenantClientEO record);

    TenantClientEO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TenantClientEO record);

    int updateByPrimaryKey(TenantClientEO record);
}