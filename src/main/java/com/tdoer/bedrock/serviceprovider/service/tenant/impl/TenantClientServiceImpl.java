/*
 * Copyright 2019 T-Doer (tdoer.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tdoer.bedrock.serviceprovider.service.tenant.impl;

import com.tdoer.bedrock.impl.definition.tenant.TenantClientDefinition;
import com.tdoer.bedrock.serviceprovider.eo.tenant.TenantClientEO;
import com.tdoer.bedrock.serviceprovider.mapper.tenant.TenantClientMapper;
import com.tdoer.bedrock.serviceprovider.service.tenant.TenantClientService;
import com.tdoer.springboot.service.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Leon Wang (ahbbhywmd@163.com)
 * @Description
 * @create 2019-10-28
 */
@Service
public class TenantClientServiceImpl extends BaseServiceImpl<Long, TenantClientEO, TenantClientMapper> implements TenantClientService {

    @Override
    public List<TenantClientEO> getTenantClients(Long tenantId) {
        TenantClientEO example = new TenantClientEO();
        example.setTenantId(tenantId);
        return findListByExample(example);
    }

    @Override
    public TenantClientEO getTenantClientByHost(String host) {
        TenantClientEO example = new TenantClientEO();
        example.setHosts(host);
        return getByExample(example);
    }
}
