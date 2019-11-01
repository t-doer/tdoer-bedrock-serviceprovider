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

import com.tdoer.bedrock.impl.definition.application.ApplicationDefinition;
import com.tdoer.bedrock.serviceprovider.constants.ServiceProviderEnums.CustomizeStatus;
import com.tdoer.bedrock.serviceprovider.eo.application.ApplicationServiceEO;
import com.tdoer.bedrock.serviceprovider.mapper.application.ApplicationServiceMapper;
import com.tdoer.bedrock.serviceprovider.service.application.ApplicationServiceService;
import com.tdoer.springboot.service.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ApplicationServiceServiceImpl extends BaseServiceImpl<Long, ApplicationServiceEO, ApplicationServiceMapper> implements ApplicationServiceService {

    @Override
    public List<ApplicationServiceEO> findRefereeServicesByAppliction(ApplicationDefinition application) {
        return findRefereeServicesByAppliction(application.getId());
    }

    @Override
    public List<ApplicationServiceEO> findRefereeServicesByAppliction(Long applicationId) {
        ApplicationServiceEO example = new ApplicationServiceEO();
        example.setApplicationId(applicationId);
        return findListByExample(example);
    }

    @Override
    public List<ApplicationServiceEO> findCommonRefereeServicesByAppliction(ApplicationDefinition application) {
        return findCommonRefereeServicesByAppliction(application.getId());
    }

    @Override
    public List<ApplicationServiceEO> findCommonRefereeServicesByAppliction(Long applicationId) {
        ApplicationServiceEO example = new ApplicationServiceEO();
        example.setApplicationId(applicationId);
        example.setCustomized(CustomizeStatus.COMMON.code());
        return findListByExample(example);
    }

    @Override
    public List<ApplicationServiceEO> getApplicationServicesByServiceId(Long serviceId) {
        ApplicationServiceEO example = new ApplicationServiceEO();
        example.setServiceId(serviceId);
        return findListByExample(example);
    }
}