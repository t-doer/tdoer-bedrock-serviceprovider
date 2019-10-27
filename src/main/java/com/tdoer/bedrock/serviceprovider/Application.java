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
package com.tdoer.bedrock.serviceprovider;

import com.tdoer.bedrock.impl.BedrockImplErrorCodes;
import com.tdoer.security.autoconfigure.EnableManagementProtection;
import com.tdoer.springboot.autoconfigure.EnableErrorHandler;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author fly_once(654126198@qq.com)
 * @create 2017-09-19
 */

@SpringBootApplication(exclude = {MongoAutoConfiguration.class})
@EnableErrorHandler({ErrorStatusCodes.class, BedrockImplErrorCodes.class})
@EnableEurekaClient
@ComponentScan(basePackages={"com.tdoer.bedrock.serviceprovider","com.tdoer.springboot.log","com.tdoer.bedrock.impl","com.tdoer.service.interfaces"})
@EnableTransactionManagement
@EnableManagementProtection
public class Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).web(WebApplicationType.SERVLET).run(args);
    }

}
