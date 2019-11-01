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

import com.tdoer.bedrock.impl.definition.product.*;
import com.tdoer.bedrock.serviceprovider.bizz.ProductBizz;
import com.tdoer.springboot.rest.GenericResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Leon Wang (ahbbhywmd@163.com)
 * @Description
 * @create 2019-11-01
 */
@RestController
@RequestMapping("/bedrock/product")
public class ProductController {
    @Autowired
    private ProductBizz productBizz;

    @GetMapping("/definition/byId/{productId}")
    GenericResponseData<ProductDefinition> getProductDefinition(
            @PathVariable("productId") @NotNull Long productId) {
        return GenericResponseData.ok(productBizz.getProductDefinitionById(productId));
    }

    @GetMapping("/definition/byCode/{productCode}")
    GenericResponseData<ProductDefinition> getProductDefinition(
            @PathVariable("productCode") @NotBlank String productCode) {
        return GenericResponseData.ok(productBizz.getProductDefinitionByCode(productCode));
    }

    @GetMapping("{productId}/clientDefinitons")
    GenericResponseData<List<ClientDefinition>> getClientDefinitions(
            @PathVariable("productId") @NotNull Long productId) {
        return GenericResponseData.ok(productBizz.getClientDefinitions(productId));
    }

    @GetMapping("/client/{clientId}/tenant/{tenantId}/token")
    GenericResponseData<ClientTokenDefinition> getClientTokenDefinition(
            @PathVariable("clientId") @NotNull Long clientId,
            @RequestParam("tenantId") @NotNull Long tenantId) {
        return GenericResponseData.ok(productBizz.getClientTokenDefinition(clientId, tenantId));
    }

    @GetMapping("/client/{clientId}/tenant/{tenantId}/applications")
    GenericResponseData<List<ClientApplicationDefinition>> getClientApplicationDefinitions(
            @PathVariable("clientId") @NotNull Long clientId,
            @RequestParam("tenantId") @NotNull Long tenantId) {
        return GenericResponseData.ok(productBizz.getClientApplicationDefinitions(clientId, tenantId));
    }

    @GetMapping("/client/{clientId}/tenant/{tenantId}/services")
    GenericResponseData<List<ClientServiceDefinition>> getClientServiceDefinitions(
            @PathVariable("clientId") @NotNull Long clientId,
            @RequestParam("tenantId") @NotNull Long tenantId) {
        return GenericResponseData.ok(productBizz.getClientServiceDefinitions(clientId, tenantId));
    }

    @GetMapping("/client/{clientId}/tenant/{tenantId}/contexts")
    GenericResponseData<List<ClientContextDefinition>> getClientContextDefinitions(
            @PathVariable("clientId") @NotNull Long clientId,
            @RequestParam("tenantId") @NotNull Long tenantId) {
        return GenericResponseData.ok(productBizz.getClientContextDefinitions(clientId, tenantId));
    }
}
