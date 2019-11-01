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
package com.tdoer.bedrock.serviceprovider.bizz;

import com.tdoer.bedrock.impl.definition.tenant.TenantClientDefinition;
import com.tdoer.bedrock.impl.definition.tenant.TenantDefinition;
import com.tdoer.bedrock.impl.definition.tenant.TenantProductDefinition;
import com.tdoer.bedrock.serviceprovider.eo.tenant.TenantClientEO;
import com.tdoer.bedrock.serviceprovider.eo.tenant.TenantProductEO;
import com.tdoer.bedrock.serviceprovider.service.tenant.TenantClientService;
import com.tdoer.bedrock.serviceprovider.service.tenant.TenantProductService;
import com.tdoer.bedrock.serviceprovider.service.tenant.TenantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Leon Wang (ahbbhywmd@163.com)
 * @Description
 * @create 2019-10-28
 */
@Component
public class TenantBizz {
    @Autowired
    private TenantService tenantService;
    @Autowired
    private TenantProductService tenantProductService;
    @Autowired
    private TenantClientService tenantClientService;

    public TenantDefinition getTenantDefinitionById(Long tenantId) {
        return tenantService.getById(tenantId);
    }

    public TenantDefinition getTenantDefinitionByCode(String tenantCode) {
        return tenantService.getByCode(tenantCode);
    }

    public TenantDefinition getTenantDefinitionByGuid(String guid) {
        return tenantService.getByGuid(guid);
    }

    public List<TenantProductDefinition> getTenantProductDefinitions(Long tenantId) {
        List<TenantProductEO> tenantProducts = tenantProductService.getTenantProducts(tenantId);
        List<TenantProductDefinition> tenantProductDefinitions = new ArrayList<>();
        tenantProducts.forEach(tenantProduct -> {
            tenantProductDefinitions.add(tenantProduct);
        });
        return tenantProductDefinitions;
    }

    public List<TenantClientDefinition> getTenantClientDefinitions(Long tenantId) {
        List<TenantClientEO> tenantClients = tenantClientService.getTenantClients(tenantId);
        List<TenantClientDefinition> tenantClientDefinitions = new ArrayList<>();
        tenantClients.forEach(tenantClient -> {
            tenantClientDefinitions.add(tenantClient);
        });
        return tenantClientDefinitions;
    }

    public TenantClientDefinition getTenantClientDefinition(String host) {
        return tenantClientService.getTenantClientByHost(host);
    }
}
