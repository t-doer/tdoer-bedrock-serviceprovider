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

package com.tdoer.bedrock.serviceprovider.bizz;

import com.tdoer.bedrock.impl.definition.context.*;
import com.tdoer.bedrock.serviceprovider.eo.context.*;
import com.tdoer.bedrock.serviceprovider.eo.org.OrganizationEO;
import com.tdoer.bedrock.serviceprovider.eo.org.OrganizationMemberEO;
import com.tdoer.bedrock.serviceprovider.eo.product.ClientContextApplicationEO;
import com.tdoer.bedrock.serviceprovider.eo.product.NavigationItemEO;
import com.tdoer.bedrock.serviceprovider.service.context.*;
import com.tdoer.bedrock.serviceprovider.service.org.OrganizationMemberService;
import com.tdoer.bedrock.serviceprovider.service.org.OrganizationService;
import com.tdoer.bedrock.serviceprovider.service.product.ClientContextApplicationService;
import com.tdoer.bedrock.serviceprovider.service.product.NavigationItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description ContextBizz
 * @author fly_once(654126198@qq.com)
 * @create 2019-10-31
 */
@Component
public class ContextBizz {

    @Autowired
    private ContextPubliMethodService contextPubliMethodService;
    @Autowired
    private ContextRoleMethodService contextRoleMethodService;
    @Autowired
    private ContextRoleResourceService contextRoleResourceService;
    @Autowired
    private ContextRoleService contextRoleService;
    @Autowired
    private ContextTypeService contextTypeService;
    @Autowired
    private ClientContextApplicationService clientContextApplicationService;
    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private OrganizationMemberService organizationMemberService;
    @Autowired
    private NavigationItemService navigationItemService;

    public List<ContextTypeDefinition> getContextTypes(Long tenantId) {
        List<ContextTypeEO> contextTypes = contextTypeService.findContextTypesByTenant(tenantId);
        List<ContextTypeDefinition> definitions = new ArrayList<>();
        contextTypes.forEach((contextType) -> {
            definitions.add(contextType);
        });
        return definitions;
    }

    public List<ContextPublicMethodDefinition> getContextPublicMethods(Long clientId, Long tenantId,
            String contextPath) {
        List<ContextPublicMethodEO> publicMethodEOs = contextPubliMethodService.findMethods(clientId, tenantId,
                contextPath);
        List<ContextPublicMethodDefinition> definitions = new ArrayList<>();
        publicMethodEOs.forEach((publicMethod) -> {
            definitions.add(publicMethod);
        });
        return definitions;
    }

    public List<ContextRoleMethodDefinition> getContextRoleMethods(Long clientId, Long tenantId, String contextPath,
            Long roleId) {
        List<ContextRoleMethodEO> roleMethodEOs = contextRoleMethodService.findMethods(clientId, tenantId, contextPath,
                roleId);
        List<ContextRoleMethodDefinition> definitions = new ArrayList<>();
        roleMethodEOs.forEach((roleMethod) -> {
            definitions.add(roleMethod);
        });
        return definitions;
    }

    public List<Long> getRoleIdsOfUserInContext(Long tenantId, String contextPath, Long userId) {
        OrganizationEO organization = organizationService.getByContext(contextPath);
        OrganizationMemberEO organizationMember = organizationMemberService.getByOrgIdAndUserId(organization.getId(),
                userId);
        List<String> strRoleIds = Arrays.asList(organizationMember.getRoleIds().split(","));
        List<Long> roleIds = new ArrayList<>();
        strRoleIds.forEach((strRoleId) -> {
            roleIds.add(Long.valueOf(strRoleId));
        });
        return roleIds;
    }

    public List<ContextPublicResourceDefinition> getContextPublicResources(Long clientId, Long tenantId,
            String contextPath) {
        List<NavigationItemEO> publicItems = navigationItemService.findPublicItems(clientId, tenantId, contextPath);
        List<ContextPublicResourceDefinition> definitions = new ArrayList<>();
        publicItems.forEach((publicItem) -> {
            definitions.add(toContextPublicResourceDefinition(publicItem));
        });
        return definitions;
    }

    public List<ContextRoleResourceDefinition> getContextRoleResources(Long clientId, Long tenantId, String contextPath,
            Long roleId) {
        List<ContextRoleResourceEO> contextRoleResourceEOs = contextRoleResourceService.findRoleResources(clientId,
                tenantId, contextPath, roleId);
        List<ContextRoleResourceDefinition> definitions = new ArrayList<>();
        contextRoleResourceEOs.forEach((resource) -> {
            definitions.add(resource);
        });
        return definitions;
    }

    public List<ContextRoleDefinition> getContextRoles(Long tenantId, String contextPath) {
        List<ContextRoleEO> roleEOs = contextRoleService.findRoles(tenantId, contextPath);
        List<ContextRoleDefinition> definitions = new ArrayList<>();
        roleEOs.forEach((role) -> {
            definitions.add(role);
        });
        return definitions;
    }

    public List<ContextApplicationDefinition> getContextApplications(Long clientId, Long tenantId, String contextPath) {
        List<ClientContextApplicationEO> contextApplicationEOs = clientContextApplicationService
                .findApplications(clientId, tenantId, contextPath);
        List<ContextApplicationDefinition> definitions = new ArrayList<>();
        contextApplicationEOs.forEach((application) -> {
            definitions.add(application);
        });
        return definitions;
    }

    private ContextPublicResourceDefinition toContextPublicResourceDefinition(NavigationItemEO item) {
        ContextPublicResourceDefinition definition = new ContextPublicResourceDefinition();
        definition.setClientId(item.getClientId());
        definition.setResourceId(item.getId());
        definition.setResourceType(item.getType());
        definition.setTenantId(item.getTenantId());
        definition.setContextPath(item.getContextPath());
        return definition;
    }
}