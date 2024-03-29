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

import com.tdoer.bedrock.impl.definition.context.*;
import com.tdoer.bedrock.serviceprovider.bizz.ContextBizz;
import com.tdoer.springboot.rest.GenericResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description ContextController
 * @author fly_once(654126198@qq.com)
 * @create 2019-10-31
 */
@RestController
@RequestMapping("/bedrock/context")
public class ContextController {

    @Autowired
    private ContextBizz contextBizz;

    @GetMapping("/{tenantId}/types")
    public GenericResponseData<List<ContextTypeDefinition>> getContextTypes(
            @PathVariable("tenantId") @NonNull Long tenantId) {
        return GenericResponseData.ok(contextBizz.getContextTypes(tenantId));
    }

    @GetMapping("/{contextPath}/publicMethods")
    public GenericResponseData<List<ContextPublicMethodDefinition>> getContextPublicMethods(
            @RequestParam("clientId") @NonNull Long clientId, @RequestParam("tenantId") @NonNull Long tenantId,
            @PathVariable("contextPath") @NonNull String contextPath) {
        return GenericResponseData.ok(contextBizz.getContextPublicMethods(clientId, tenantId, contextPath));
    }

    @GetMapping("/{contextPath}/role/{roleId}/methods")
    public GenericResponseData<List<ContextRoleMethodDefinition>> getContextRoleMethods(
            @RequestParam("clientId") @NonNull Long clientId, @RequestParam("tenantId") @NonNull Long tenantId,
            @PathVariable("contextPath") @NonNull String contextPath, @PathVariable("roleId") @NonNull Long roleId) {
        return GenericResponseData.ok(contextBizz.getContextRoleMethods(clientId, tenantId, contextPath, roleId));
    }

    @GetMapping("/{contextPath}/user/{userId}/roles")
    public GenericResponseData<List<Long>> getRoleIdsOfUserInContext(@RequestParam("tenantId") @NonNull Long tenantId,
            @PathVariable("contextPath") @NonNull String contextPath, @PathVariable("userId") @NonNull Long userId) {
        return GenericResponseData.ok(contextBizz.getRoleIdsOfUserInContext(tenantId, contextPath, userId));
    }

    @GetMapping("/{contextPath}/role/{roleId}/resources")
    public GenericResponseData<List<ContextRoleResourceDefinition>> getContextRoleResources(
            @RequestParam("clientId") @NonNull Long clientId, @RequestParam("tenantId") @NonNull Long tenantId,
            @PathVariable("contextPath") @NonNull String contextPath, @PathVariable("roleId") @NonNull Long roleId) {
        return GenericResponseData.ok(contextBizz.getContextRoleResources(clientId, tenantId, contextPath, roleId));
    }

    @GetMapping("/{contextPath}/roles")
    public GenericResponseData<List<ContextRoleDefinition>> getContextRoles(
            @RequestParam("tenantId") @NonNull Long tenantId,
            @PathVariable("contextPath") @NonNull String contextPath) {
        return GenericResponseData.ok(contextBizz.getContextRoles(tenantId, contextPath));
    }

    @GetMapping("/{contextPath}/publicResources")
    public GenericResponseData<List<ContextPublicResourceDefinition>> getContextPublicResources(
            @RequestParam("clientId") @NonNull Long clientId, @RequestParam("tenantId") @NonNull Long tenantId,
            @PathVariable("contextPath") @NonNull String contextPath) {
        return GenericResponseData.ok(contextBizz.getContextPublicResources(clientId, tenantId, contextPath));
    }

    @GetMapping("/{contextPath}/applications")
    public GenericResponseData<List<ContextApplicationDefinition>> getContextApplications(
            @RequestParam("clientId") @NonNull Long clientId, @RequestParam("tenantId") @NonNull Long tenantId,
            @PathVariable("contextPath") @NonNull String contextPath) {
        return GenericResponseData.ok(contextBizz.getContextApplications(clientId, tenantId, contextPath));
    }
}