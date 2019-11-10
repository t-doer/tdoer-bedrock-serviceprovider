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

package com.tdoer.bedrock.serviceprovider.service.product.impl;

import java.util.List;

import com.tdoer.bedrock.serviceprovider.constants.ServiceProviderEnums.YesOrNoStatus;
import com.tdoer.bedrock.serviceprovider.eo.product.NavigationItemEO;
import com.tdoer.bedrock.serviceprovider.mapper.product.NavigationItemMapper;
import com.tdoer.bedrock.serviceprovider.service.product.NavigationItemService;
import com.tdoer.springboot.service.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class NavigationItemServiceImpl extends BaseServiceImpl<Long, NavigationItemEO, NavigationItemMapper> implements NavigationItemService {
    @Override
    public List<NavigationItemEO> findPublicItems(Long clientId, Long tenantId, String contextPath) {
        NavigationItemEO example = new NavigationItemEO();
        example.setClientId(clientId);
        example.setTenantId(tenantId);
        example.setContextPath(contextPath);
        example.setIsPublic(YesOrNoStatus.YES.code());
        return findListByExample(example);
    }
}