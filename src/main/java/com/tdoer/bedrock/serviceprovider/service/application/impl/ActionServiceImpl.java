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

import com.tdoer.bedrock.impl.definition.application.PageDefinition;
import com.tdoer.bedrock.serviceprovider.constants.ServiceProviderEnums.CustomizeStatus;
import com.tdoer.bedrock.serviceprovider.eo.application.ActionEO;
import com.tdoer.bedrock.serviceprovider.mapper.application.ActionMapper;
import com.tdoer.bedrock.serviceprovider.service.application.ActionService;
import com.tdoer.springboot.service.BaseServiceImpl;

import org.springframework.stereotype.Service;

@Service
public class ActionServiceImpl extends BaseServiceImpl<Long, ActionEO, ActionMapper> implements ActionService {
    @Override
    public List<ActionEO> findActionsByPage(PageDefinition page) {
        return findActionsByPage(page.getId());
    }

    @Override
    public List<ActionEO> findActionsByPage(Long pageId) {
        ActionEO example = new ActionEO();
        example.setPageId(pageId);
        return findListByExample(example);
    }

    @Override
    public List<ActionEO> findCustomizedActionsByPage(PageDefinition page) {
        return findCustomizedActionsByPage(page.getId());
    }

    @Override
    public List<ActionEO> findCustomizedActionsByPage(Long pageId) {
        ActionEO example = new ActionEO();
        example.setPageId(pageId);
        example.setCustomized(CustomizeStatus.CUSTOMIZED.code());
        return findListByExample(example);
    }

    @Override
    public List<ActionEO> findCommonActionsByPage(PageDefinition page) {
        return findCommonActionsByPage(page.getId());
    }

    @Override
    public List<ActionEO> findCommonActionsByPage(Long pageId) {
        ActionEO example = new ActionEO();
        example.setPageId(pageId);
        example.setCustomized(CustomizeStatus.COMMON.code());
        return findListByExample(example);
    }
}