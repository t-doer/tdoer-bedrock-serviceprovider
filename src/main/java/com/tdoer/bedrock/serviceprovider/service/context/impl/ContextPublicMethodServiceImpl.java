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

package com.tdoer.bedrock.serviceprovider.service.context.impl;

import java.util.List;

import com.tdoer.bedrock.serviceprovider.eo.context.ContextPublicMethodEO;
import com.tdoer.bedrock.serviceprovider.mapper.context.ContextPubliMethodMapper;
import com.tdoer.bedrock.serviceprovider.service.context.ContextPubliMethodService;
import com.tdoer.springboot.service.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ContextPublicMethodServiceImpl extends BaseServiceImpl<Long, ContextPublicMethodEO, ContextPubliMethodMapper> implements ContextPubliMethodService {
    @Override
    public List<ContextPublicMethodEO> findMethods(Long clientId, Long tenantId, String contextPath) {
        ContextPublicMethodEO example = new ContextPublicMethodEO();
        example.setClientId(clientId);
        example.setContextPath(contextPath);
        example.setTenantId(tenantId);
        return findListByExample(example);
    }
}