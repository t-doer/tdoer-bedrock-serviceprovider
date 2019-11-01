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

package com.tdoer.bedrock.serviceprovider.service.service.impl;

import com.github.pagehelper.Constant;
import com.tdoer.bedrock.service.ServiceMethod;
import com.tdoer.bedrock.serviceprovider.constants.ServiceProviderEnums;
import com.tdoer.bedrock.serviceprovider.eo.service.ServiceMethodEO;
import com.tdoer.bedrock.serviceprovider.mapper.service.ServiceMethodMapper;
import com.tdoer.bedrock.serviceprovider.service.service.ServiceMethodService;
import com.tdoer.springboot.service.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceMethodServiceImpl extends BaseServiceImpl<Long, ServiceMethodEO, ServiceMethodMapper> implements ServiceMethodService {
    @Override
    public List<ServiceMethodEO> getServiceMethodsByServiceId(Long serviceId) {
        ServiceMethodEO example = new ServiceMethodEO();
        example.setServiceId(serviceId);
        return findListByExample(example);
    }

    @Override
    public List<ServiceMethodEO> getCommonServiceMethods(Long serviceId) {
        ServiceMethodEO example = new ServiceMethodEO();
        example.setServiceId(serviceId);
        example.setCustomized(ServiceProviderEnums.CustomizeStatus.COMMON.code());
        return findListByExample(example);
    }
}