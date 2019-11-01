/* 
/* Copyright 2017-2019 T-Doer (tdoer.com). 
/* 
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

package com.tdoer.bedrock.serviceprovider.service.product.impl;

import com.tdoer.bedrock.serviceprovider.eo.product.ClientContextEO;
import com.tdoer.bedrock.serviceprovider.mapper.product.ClientContextMapper;
import com.tdoer.bedrock.serviceprovider.service.product.ClientContextService;
import com.tdoer.springboot.service.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientContextServiceImpl extends BaseServiceImpl<Long, ClientContextEO, ClientContextMapper> implements ClientContextService {
    @Override
    public List<ClientContextEO> getClientContexts(Long clientId, Long tenantId) {
        ClientContextEO example = new ClientContextEO();
        example.setClientId(clientId);
        example.setTenantId(tenantId);
        return findListByExample(example);
    }
}