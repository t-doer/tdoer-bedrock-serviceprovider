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

package com.tdoer.bedrock.serviceprovider.constants;

import com.tdoer.springboot.util.Resolvables.*;
/**
 * @description ServiceProviderEnums
 * @author fly_once(654126198@qq.com)
 * @create 2019-10-30
 */
public interface ServiceProviderEnums {
    /** 通用(是/否)状态 */
    public enum YesOrNoStatus implements StringResolvable {
        YES("Y", "是"), NO("N", "否");

        private String code;
        private String desc;

        private YesOrNoStatus(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public String code() { return this.code; }
        public String desc() { return this.desc; }
        
        public Boolean equalTo(String code) { return this.code.equals(code); } 
    }

}
