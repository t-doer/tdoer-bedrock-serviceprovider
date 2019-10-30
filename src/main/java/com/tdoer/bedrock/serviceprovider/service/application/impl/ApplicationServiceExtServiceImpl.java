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

package com.tdoer.bedrock.serviceprovider.service.application.impl;

import java.util.List;

import com.tdoer.bedrock.serviceprovider.eo.application.ApplicationServiceEO;
import com.tdoer.bedrock.serviceprovider.eo.application.ApplicationServiceExtEO;
import com.tdoer.bedrock.serviceprovider.mapper.application.ApplicationServiceExtMapper;
import com.tdoer.bedrock.serviceprovider.service.application.ApplicationServiceExtService;
import com.tdoer.springboot.service.BaseServiceImpl;

import org.springframework.stereotype.Service;

@Service
public class ApplicationServiceExtServiceImpl extends BaseServiceImpl<Long, ApplicationServiceExtEO, ApplicationServiceExtMapper> implements ApplicationServiceExtService {
    @Override
    public List<ApplicationServiceExtEO> findCustomizedRefereeServices(Long applicationId, Long productId,
            Long clientId, Long tenantId, String contextPath) {
        ApplicationServiceExtEO example = new ApplicationServiceExtEO();
        example.setApplicationId(applicationId);
        example.setProductId(productId);
        example.setClientId(clientId);
        example.setTenantId(tenantId);
        example.setContextPath(contextPath);
        return findListByExample(example);
    }
}