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

import com.tdoer.bedrock.impl.definition.product.*;
import com.tdoer.bedrock.serviceprovider.eo.product.ClientApplicationEO;
import com.tdoer.bedrock.serviceprovider.eo.product.ClientContextEO;
import com.tdoer.bedrock.serviceprovider.eo.product.ClientEO;
import com.tdoer.bedrock.serviceprovider.eo.product.ClientServiceEO;
import com.tdoer.bedrock.serviceprovider.service.product.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Leon Wang (ahbbhywmd@163.com)
 * @Description
 * @create 2019-11-01
 */
@Component
public class ProductBizz {
    @Autowired
    private ProductService productService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private ClientTokenService clientTokenService;
    @Autowired
    private ClientApplicationService clientApplicationService;
    @Autowired
    private ClientServiceService clientServiceService;
    @Autowired
    private ClientContextService clientContextService;

    public ProductDefinition getProductDefinitionById(Long productId) {
        return productService.getById(productId);
    }

    public ProductDefinition getProductDefinitionByCode(String productCode) {
        return productService.getByCode(productCode);
    }

    public List<ClientDefinition> getClientDefinitions(Long productId) {
        List<ClientEO> clients = clientService.getClientsByProductId(productId);
        List<ClientDefinition> clientDefinitions = new ArrayList<>();
        clients.forEach(client->{
            clientDefinitions.add(client);
        });
        return clientDefinitions;
    }

    public ClientTokenDefinition getClientTokenDefinition(Long clientId, Long tenantId) {
        return clientTokenService.getClientToken(clientId, tenantId);
    }

    public List<ClientApplicationDefinition> getClientApplicationDefinitions(Long clientId, Long tenantId) {
        List<ClientApplicationEO> clientApplications =  clientApplicationService.getClientApplications(clientId, tenantId);
        List<ClientApplicationDefinition> clientApplicationDefinitions = new ArrayList<>();
        clientApplications.forEach(clientApplication -> {
            clientApplicationDefinitions.add(clientApplication);
        });
        return clientApplicationDefinitions;
    }

    public List<ClientServiceDefinition> getClientServiceDefinitions(Long clientId, Long tenantId) {
        List<ClientServiceEO> clientServices = clientServiceService.getClientServices(clientId, tenantId);
        List<ClientServiceDefinition> clientServiceDefinitions = new ArrayList<>();
        clientServices.forEach(clientService -> {
            clientServiceDefinitions.add(clientService);
        });
        return clientServiceDefinitions;
    }

    public List<ClientContextDefinition> getClientContextDefinitions(Long clientId, Long tenantId) {
        List<ClientContextEO> clientContexts = clientContextService.getClientContexts(clientId, tenantId);
        List<ClientContextDefinition> clientContextDefinitions = new ArrayList<>();
        clientContexts.forEach(clientContext -> {
            clientContextDefinitions.add(clientContext);
        });
        return clientContextDefinitions;
    }
}
