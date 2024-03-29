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
import com.tdoer.bedrock.serviceprovider.constants.ServiceProviderEnums.YesOrNoStatus;
import com.tdoer.bedrock.serviceprovider.eo.application.PageEO;
import com.tdoer.bedrock.serviceprovider.mapper.application.PageMapper;
import com.tdoer.bedrock.serviceprovider.service.application.PageService;
import com.tdoer.springboot.service.BaseServiceImpl;

import org.springframework.stereotype.Service;

@Service
public class PageServiceImpl extends BaseServiceImpl<Long, PageEO, PageMapper> implements PageService {
    @Override
    public List<PageEO> findPagesByApplication(ApplicationDefinition application) {
        return findPagesByApplication(application.getId());
    }

    @Override
    public List<PageEO> findPagesByApplication(Long applicationId) {
        PageEO example = new PageEO();
        example.setApplicationId(applicationId);
        return findListByExample(example);
    }

    @Override
    public List<PageEO> findCommonPagesByApplication(ApplicationDefinition application) {
        return findCommonPagesByApplication(application.getId());
    }

    @Override
    public List<PageEO> findCommonPagesByApplication(Long applicationId) {
        PageEO example = new PageEO();
        example.setApplicationId(applicationId);
        example.setCustomized(YesOrNoStatus.NO.code());
        return findListByExample(example);
    }

}