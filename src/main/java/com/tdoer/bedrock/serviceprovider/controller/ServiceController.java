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
package com.tdoer.bedrock.serviceprovider.controller;

import com.tdoer.bedrock.impl.definition.service.ServiceDefinition;
import com.tdoer.bedrock.impl.definition.service.ServiceMethodDefinition;
import com.tdoer.bedrock.serviceprovider.bizz.ServiceBizz;
import com.tdoer.springboot.rest.GenericResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Leon Wang (ahbbhywmd@163.com)
 * @Description
 * @create 2019-10-30
 */
@RestController
@RequestMapping("/bedrock/service")
public class ServiceController {
    @Autowired
    private ServiceBizz serviceBizz;

    @GetMapping("/definition/byId/{serviceId}")
    GenericResponseData<ServiceDefinition> getServiceDefinitionById(
            @PathVariable("serviceId") Long serviceId) {
        return GenericResponseData.ok(serviceBizz.getServiceDefinitionById(serviceId));
    }

    @GetMapping("/definition/byCode/{serviceId}")
    GenericResponseData<ServiceDefinition> getServiceDefinitionByCode(
            @PathVariable("serviceCode") String serviceCode) {
        return GenericResponseData.ok(serviceBizz.getServiceDefinitionByCode(serviceCode));
    }
    @GetMapping("/{serviceId}/methods")
    GenericResponseData<List<ServiceMethodDefinition>> getAllServiceMethodDefinitions(
            @PathVariable("serviceId") Long serviceId) {
        return GenericResponseData.ok(serviceBizz.getAllServiceMethodDefinitions(serviceId));
    }

    @GetMapping("/{serviceId}/customizedMethodIds")
    GenericResponseData<List<Long>> getCustomizedServiceMethodIds(
            @PathVariable("serviceId") @NotNull Long serviceId,
            @RequestParam("applicationId") @NotNull Long applicationId,
            @RequestParam("productId") @NotNull Long productId,
            @RequestParam("clientId") @NotNull Long clientId,
            @RequestParam("tenantId") @NotNull Long tenantId,
            @RequestParam("contextPath")  String contextPath) {
        return GenericResponseData.ok(serviceBizz.getCustomizedServiceMethodIds(serviceId, applicationId
                , productId, clientId, tenantId, contextPath));
    }

    @GetMapping("{serviceId}/commonMethodIds")
    GenericResponseData<List<Long>> getCommonServiceMethodIds(
            @PathVariable("serviceId") @NotNull Long serviceId) {
        return GenericResponseData.ok(serviceBizz.getCommonServiceMethodIds(serviceId));
    }


    @GetMapping("{serviceId}/refererClientIds")
    GenericResponseData<List<Long>> getRefererClientIds(@PathVariable("serviceId") @NotNull Long serviceId) {
        return GenericResponseData.ok(serviceBizz.getRefererClientIds(serviceId));
    }

    @GetMapping("{serviceId}/refererApplicationIds")
    GenericResponseData<List<Long>> getRefererApplicationIds(@PathVariable("serviceId") @NotNull Long serviceId) {
        return GenericResponseData.ok(serviceBizz.getRefererClientIds(serviceId));
    }


    @GetMapping("{serviceId}/refererServiceIds")
    GenericResponseData<List<Long>> getRefererServiceIds(@PathVariable("serviceId") @NotNull Long serviceId) {
        return GenericResponseData.ok(serviceBizz.getRefererServiceIds(serviceId));
    }

    @GetMapping("{serviceId}/refereeServiceIds")
    GenericResponseData<List<Long>> getRefereeServiceIds(@PathVariable("serviceId") @NotNull Long serviceId) {
        return GenericResponseData.ok(serviceBizz.getRefereeServiceIds(serviceId));
    }
}
