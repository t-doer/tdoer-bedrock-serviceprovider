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

import com.netflix.discovery.converters.Auto;
import com.tdoer.bedrock.impl.definition.service.ServiceDefinition;
import com.tdoer.bedrock.impl.definition.service.ServiceMethodDefinition;
import com.tdoer.bedrock.serviceprovider.eo.application.ApplicationServiceEO;
import com.tdoer.bedrock.serviceprovider.eo.product.ClientServiceEO;
import com.tdoer.bedrock.serviceprovider.eo.service.ServiceMethodEO;
import com.tdoer.bedrock.serviceprovider.eo.service.ServiceMethodExtEO;
import com.tdoer.bedrock.serviceprovider.eo.service.ServiceReferenceEO;
import com.tdoer.bedrock.serviceprovider.service.application.ApplicationService;
import com.tdoer.bedrock.serviceprovider.service.application.ApplicationServiceExtService;
import com.tdoer.bedrock.serviceprovider.service.application.ApplicationServiceService;
import com.tdoer.bedrock.serviceprovider.service.product.ClientService;
import com.tdoer.bedrock.serviceprovider.service.product.ClientServiceService;
import com.tdoer.bedrock.serviceprovider.service.service.ServiceMethodExtService;
import com.tdoer.bedrock.serviceprovider.service.service.ServiceMethodService;
import com.tdoer.bedrock.serviceprovider.service.service.ServiceReferenceService;
import com.tdoer.bedrock.serviceprovider.service.service.ServiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Leon Wang (ahbbhywmd@163.com)
 * @Description
 * @create 2019-10-30
 */
@Component
public class ServiceBizz {
    @Autowired
    private ServiceService serviceService;
    @Autowired
    private ServiceMethodExtService serviceMethodExtService;
    @Autowired
    private ServiceMethodService serviceMethodService;
    @Autowired
    private ServiceReferenceService serviceReferenceService;
    @Autowired
    private ApplicationServiceService applicationServiceService;
    @Autowired
    private ClientServiceService clientServiceService;

    public ServiceDefinition getServiceDefinitionById(Long serviceId) {
        return serviceService.getById(serviceId);
    }

    public ServiceDefinition getServiceDefinitionByCode(String serviceCode) {
        return serviceService.getByCode(serviceCode);
    }

    public List<ServiceMethodDefinition> getAllServiceMethodDefinitions(Long serviceId) {
        List<ServiceMethodEO> serviceMethods = serviceMethodService.getServiceMethodsByServiceId(serviceId);
        List<ServiceMethodDefinition> serviceMethodDefinitions = new ArrayList<>();
        serviceMethods.forEach(serviceMethod -> {
            serviceMethodDefinitions.add(serviceMethod);
        });
        return serviceMethodDefinitions;
    }

    public List<Long> getCustomizedServiceMethodIds(Long serviceId, Long applicationId, Long productId, Long clientId, Long tenantId, String contextPath) {
        List<ServiceMethodExtEO> serviceMethodExts = serviceMethodExtService.getCustomizedServiceMethods(serviceId, applicationId,
                productId, clientId, tenantId, contextPath);
        List<Long> customizedServiceMethodIds = new ArrayList<>();
        serviceMethodExts.forEach(serviceMethodExt -> {
            customizedServiceMethodIds.add(serviceMethodExt.getMethodId());
        });
        return customizedServiceMethodIds;
    }

    public List<Long> getCommonServiceMethodIds(Long serviceId) {
        List<ServiceMethodEO> serviceMethods = serviceMethodService.getCommonServiceMethods(serviceId);
        List<Long> commonServiceMethodIds = new ArrayList<>();
        serviceMethods.forEach(serviceMethod -> {
            commonServiceMethodIds.add(serviceMethod.getId());
        });
        return commonServiceMethodIds;
    }

    public List<Long> getRefererClientIds(Long serviceId) {
        List<ClientServiceEO> clientServices = clientServiceService.getClientServicesByServiceId(serviceId);
        List<Long> clientIds = new ArrayList<>();
        clientServices.forEach(clientService->{
            clientIds.add(clientService.getClientId());
        });
        return clientIds;
    }

    public List<Long> getRefererApplicationIds(Long serviceId) {
        List<ApplicationServiceEO> applicationServices = applicationServiceService.getApplicationServicesByServiceId(serviceId);
        List<Long> applicationIds = new ArrayList<>();
        applicationServices.forEach(applicationService->{
            applicationIds.add(applicationService.getApplicationId());
        });
        return applicationIds;
    }


    public List<Long> getRefererServiceIds(Long serviceId) {
        List<ServiceReferenceEO> serviceReferences = serviceReferenceService.getRefererServices(serviceId);
        List<Long> refererServiceIds = new ArrayList<>();
        serviceReferences.forEach(serviceReference -> {
            refererServiceIds.add(serviceReference.getRefereeId());
        });
        return refererServiceIds;
    }
    public List<Long> getRefereeServiceIds(Long serviceId) {
        List<ServiceReferenceEO> serviceReferences = serviceReferenceService.getRefereeServices(serviceId);
        List<Long> refereeServiceIds = new ArrayList<>();
        serviceReferences.forEach(serviceReference -> {
            refereeServiceIds.add(serviceReference.getServiceId());
        });
        return refereeServiceIds;
    }

}
