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

import java.util.ArrayList;
import java.util.List;

import com.tdoer.bedrock.impl.definition.application.ActionDefinition;
import com.tdoer.bedrock.impl.definition.application.ActionMethodDefinition;
import com.tdoer.bedrock.impl.definition.application.ApplicationDefinition;
import com.tdoer.bedrock.impl.definition.application.PageDefinition;
import com.tdoer.bedrock.impl.definition.application.PageMethodDefinition;
import com.tdoer.bedrock.serviceprovider.eo.application.ActionEO;
import com.tdoer.bedrock.serviceprovider.eo.application.ActionExtEO;
import com.tdoer.bedrock.serviceprovider.eo.application.ActionMethodEO;
import com.tdoer.bedrock.serviceprovider.eo.application.ApplicationEO;
import com.tdoer.bedrock.serviceprovider.eo.application.ApplicationServiceEO;
import com.tdoer.bedrock.serviceprovider.eo.application.ApplicationServiceExtEO;
import com.tdoer.bedrock.serviceprovider.eo.application.PageEO;
import com.tdoer.bedrock.serviceprovider.eo.application.PageExtEO;
import com.tdoer.bedrock.serviceprovider.eo.application.PageMethodEO;
import com.tdoer.bedrock.serviceprovider.service.application.ActionExtService;
import com.tdoer.bedrock.serviceprovider.service.application.ActionMethodService;
import com.tdoer.bedrock.serviceprovider.service.application.ActionService;
import com.tdoer.bedrock.serviceprovider.service.application.ApplicationService;
import com.tdoer.bedrock.serviceprovider.service.application.ApplicationServiceExtService;
import com.tdoer.bedrock.serviceprovider.service.application.ApplicationServiceService;
import com.tdoer.bedrock.serviceprovider.service.application.PageExtService;
import com.tdoer.bedrock.serviceprovider.service.application.PageMethodService;
import com.tdoer.bedrock.serviceprovider.service.application.PageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description ApplicationBizz
 * @author fly_once(654126198@qq.com)
 * @create 2019-10-30
 */
@Component
public class ApplicationBizz {

    @Autowired
    private ApplicationService applicationService;
    @Autowired
    private PageService pageService;
    @Autowired
    private PageExtService pageExtService;
    @Autowired
    private ActionService actionService;
    @Autowired
    private ActionExtService actionExtService;
    @Autowired
    private PageMethodService pageMethodService;
    @Autowired
    private ActionMethodService actionMethodService;
    @Autowired
    private ApplicationServiceService applicationServiceService;
    @Autowired
    private ApplicationServiceExtService applicationServiceExtService;

    public ApplicationDefinition getApplicationDefinitionById(Long applicationId) {
        ApplicationEO applicationEO = applicationService.getById(applicationId);
        return applicationEO;
    }

    public ApplicationDefinition getApplicationDefinitionByCode(String applicationCode) {
        ApplicationEO applicationEO = applicationService.getByCode(applicationCode);
        return applicationEO;
    }

    public List<PageDefinition> getAllPageDefinitions(Long applicationId) {
        List<PageEO> pageEOs = pageService.findPagesByApplication(applicationId);
        List<PageDefinition> pageDefinitions = new ArrayList<>();
        pageEOs.forEach((pageEO) -> {
            pageDefinitions.add(pageEO);
        });
        return pageDefinitions;
    }

    public List<Long> getCustomizedPageIds(Long applicationId, Long productId, Long clientId, Long tenantId,
            String contextPath) {
        List<PageExtEO> customizedPageEOs = pageExtService.findCustomziedPages(applicationId, productId, clientId,
                tenantId, contextPath);
        List<Long> pageIds = new ArrayList<>();
        customizedPageEOs.forEach((customizedPageEO) -> {
            pageIds.add(customizedPageEO.getPageId());
        });
        return pageIds;
    }

    public List<Long> getCommonPageIds(Long applicationId) {
        List<PageEO> commonPageEOs = pageService.findCommonPagesByApplication(applicationId);
        List<Long> pageIds = new ArrayList<>();
        commonPageEOs.forEach((commonPageEO) -> {
            pageIds.add(commonPageEO.getId());
        });
        return pageIds;
    }

    public List<ActionDefinition> getAllActionDefinitions(Long pageId) {
        List<ActionEO> actionEOs = actionService.findActionsByPage(pageId);
        List<ActionDefinition> actionDefinitions = new ArrayList<>();
        actionEOs.forEach((actionEO) -> {
            actionDefinitions.add(actionEO);
        });
        return actionDefinitions;
    }

    public List<Long> getCustomizedActionIds(Long pageId, Long productId, Long clientId, Long tenantId,
            String contextPath) {
        List<ActionExtEO> actionExtEOs = actionExtService.findCustomizedActions(pageId, productId, clientId, tenantId,
                contextPath);
        List<Long> actionIds = new ArrayList<>();
        actionExtEOs.forEach((actionExtEO) -> {
            actionIds.add(actionExtEO.getActionId());
        });
        return actionIds;
    }

    public List<Long> getCommonActionIds(Long pageId) {
        List<ActionEO> actionEOs = actionService.findCommonActionsByPage(pageId);
        List<Long> actionIds = new ArrayList<>();
        actionEOs.forEach((actionEO) -> {
            actionIds.add(actionEO.getId());
        });
        return actionIds;
    }

    public List<Long> getCustomizedRefereeServiceIds(Long applicationId, Long productId, Long clientId, Long tenantId,
            String contextPath) {
        List<ApplicationServiceExtEO> applicationServiceExtEOs = applicationServiceExtService
                .findCustomizedRefereeServices(applicationId, productId, clientId, tenantId, contextPath);
        List<Long> applicationIds = new ArrayList<>();
        applicationServiceExtEOs.forEach((applicationServiceExtEO) -> {
            applicationIds.add(applicationServiceExtEO.getServiceId());
        });
        return applicationIds;
    }

    public List<Long> getCommonRefereeServiceIds(Long applicationId) {
        List<ApplicationServiceEO> applicationServiceEOs = applicationServiceService
                .findCommonRefereeServicesByAppliction(applicationId);
        List<Long> applicationIds = new ArrayList<>();
        applicationServiceEOs.forEach((applicationServiceEO) -> {
            applicationIds.add(applicationServiceEO.getServiceId());
        });
        return applicationIds;
    }

    public List<Long> getAllRefereeServiceIds(Long applicationId) {
        List<ApplicationServiceEO> applicationServiceEOs = applicationServiceService
                .findRefereeServicesByAppliction(applicationId);
        List<Long> applicationIds = new ArrayList<>();
        applicationServiceEOs.forEach((applicationServiceEO) -> {
            applicationIds.add(applicationServiceEO.getServiceId());
        });
        return applicationIds;
    }

    public List<PageMethodDefinition> getPageMethodDefinitions(Long pageId) {
        List<PageMethodEO> pageMethodEOs = pageMethodService.findPageMethodsByPage(pageId);
        List<PageMethodDefinition> pageMethodDefinitions = new ArrayList<>();
        pageMethodEOs.forEach((pageMethodEO) -> {
            pageMethodDefinitions.add(pageMethodEO);
        });
        return pageMethodDefinitions;
    }

    public List<ActionMethodDefinition> getActionMethodDefinitions(Long actionId) {
        List<ActionMethodEO> actionMethodEOs = actionMethodService.findActionMethodsByAction(actionId);
        List<ActionMethodDefinition> actionMethodDefinitions = new ArrayList<>();
        actionMethodEOs.forEach((actionMethodEO) -> {
            actionMethodDefinitions.add(actionMethodEO);
        });
        return actionMethodDefinitions;
    }
}