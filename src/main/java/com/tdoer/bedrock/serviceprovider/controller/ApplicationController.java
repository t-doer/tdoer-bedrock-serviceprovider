/*
 * Copyright 2017-2019 T-Doer (tdoer.com).
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

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.tdoer.bedrock.impl.definition.application.ActionDefinition;
import com.tdoer.bedrock.impl.definition.application.ActionMethodDefinition;
import com.tdoer.bedrock.impl.definition.application.ApplicationDefinition;
import com.tdoer.bedrock.impl.definition.application.PageDefinition;
import com.tdoer.bedrock.impl.definition.application.PageMethodDefinition;
import com.tdoer.bedrock.serviceprovider.bizz.ApplicationBizz;
import com.tdoer.springboot.rest.GenericResponseData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description ApplicationController
 * @author fly_once(654126198@qq.com)
 * @create 2019-10-30
 */
@RestController
@RequestMapping("/bedrock/application")
public class ApplicationController {

    @Autowired
    private ApplicationBizz applicationBizz;;

    @GetMapping("/definition/byId/{applicationId}")
    public GenericResponseData<ApplicationDefinition> getApplicationDefinitionById(
            @PathVariable("applicationId") @NotNull Long applicationId) {
        return GenericResponseData.ok(applicationBizz.getApplicationDefinitionById(applicationId));
    }

    @GetMapping("/definition/byCode/{applicationCode}")
    public GenericResponseData<ApplicationDefinition> getApplicationDefinitionByCode(
            @PathVariable("applicationCode") @NotBlank String applicationCode) {
        return GenericResponseData.ok(applicationBizz.getApplicationDefinitionByCode(applicationCode));
    }

    @GetMapping("/{applicationId}/pageDefinitions")
    public GenericResponseData<List<PageDefinition>> getAllPageDefinitions(
            @PathVariable("applicationId") @NotNull Long applicationId) {
        return GenericResponseData.ok(applicationBizz.getAllPageDefinitions(applicationId));
    }

    @GetMapping("/{applicationId}/customizedPageIds")
    public GenericResponseData<List<Long>> getCustomizedPageIds(
            @PathVariable("applicationId") @NotNull Long applicationId,
            @RequestParam("productId") @NotNull Long productId, @RequestParam("clientId") @NotNull Long clientId,
            @RequestParam("tenantId") @NotNull Long tenantId,
            @RequestParam("contextPath") @NotNull String contextPath) {
        return GenericResponseData.ok(applicationBizz.getCustomizedPageIds(applicationId, productId, clientId, tenantId, contextPath));
    }

    @GetMapping("/{applicationId}/commonPageIds")
    public GenericResponseData<List<Long>> getCommonPageIds(
            @PathVariable("applicationId") @NotNull Long applicationId) {
        return GenericResponseData.ok(applicationBizz.getCommonPageIds(applicationId));
    }

    @GetMapping("{pageId}/actionDefinitions")
    public GenericResponseData<List<ActionDefinition>> getAllActionDefinitions(
            @PathVariable("pageId") @NotNull Long pageId) {
        return GenericResponseData.ok(applicationBizz.getAllActionDefinitions(pageId));
    }

    @GetMapping("/{pageId}/customizedActionIds")
    public GenericResponseData<List<Long>> getCustomizedActionIds(
            @PathVariable("pageId") @NotNull Long pageId, @RequestParam("productId") @NotNull Long productId,
            @RequestParam("clientId") @NotNull Long clientId, @RequestParam("tenantId") @NotNull Long tenantId,
            @RequestParam("contextPath") @NotNull String contextPath) {
        return GenericResponseData.ok(applicationBizz.getCustomizedActionIds(pageId, productId, clientId, tenantId, contextPath));
    }

    @GetMapping("{pageId}/commonActionIds")
    public GenericResponseData<List<Long>> getCommonActionIds(@PathVariable("pageId") @NotNull Long pageId) {
        return GenericResponseData.ok(applicationBizz.getCommonActionIds(pageId));
    }

    @GetMapping("{applicationId}/customizedRefereeServiceIds")
    public GenericResponseData<List<Long>> getCustomizedRefereeServiceIds(
            @PathVariable("applicationId") @NotNull Long applicationId,
            @RequestParam("productId") @NotNull Long productId, @RequestParam("clientId") @NotNull Long clientId,
            @RequestParam("tenantId") @NotNull Long tenantId,
            @RequestParam("contextPath") @NotBlank String contextPath) {
        return GenericResponseData.ok(applicationBizz.getCustomizedRefereeServiceIds(applicationId, productId, clientId, tenantId, contextPath));
    }

    @GetMapping("{applicationId}/commonRefereeServiceIds")
    public GenericResponseData<List<Long>> getCommonRefereeServiceIds(
            @PathVariable("applicationId") @NotNull Long applicationId) {
        return GenericResponseData.ok(applicationBizz.getCommonRefereeServiceIds(applicationId));
    }

    @GetMapping("{applicationId}/refereeServiceIds")
    public GenericResponseData<List<Long>> getAllRefereeServiceIds(
            @PathVariable("applicationId") @NotNull Long applicationId) {
        return GenericResponseData.ok(applicationBizz.getAllRefereeServiceIds(applicationId));
    }

    @GetMapping("{pageId}/pageMethodDefinitions")
    public GenericResponseData<List<PageMethodDefinition>> getPageMethodDefinitions(
            @PathVariable("pageId") @NotNull Long pageId) {
        return GenericResponseData.ok(applicationBizz.getPageMethodDefinitions(pageId));
    }

    @GetMapping("{actionId}/actionMethodDefinitions")
    public GenericResponseData<List<ActionMethodDefinition>> getActionMethodDefinitions(
            @PathVariable("actionId") @NotNull Long actionId) {
        return GenericResponseData.ok(applicationBizz.getActionMethodDefinitions(actionId));
    }
}