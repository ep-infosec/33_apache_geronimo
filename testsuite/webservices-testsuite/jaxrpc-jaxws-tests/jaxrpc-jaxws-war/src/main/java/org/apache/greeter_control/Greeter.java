/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.greeter_control;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name = "Greeter", targetNamespace = "http://apache.org/greeter_control")
public interface Greeter {

    /**
     * 
     * @param requestType
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "responseType", targetNamespace = "http://apache.org/greeter_control/types")
    @RequestWrapper(localName = "greetMe", targetNamespace = "http://apache.org/greeter_control/types", className = "org.apache.greeter_control.types.GreetMe")
    @ResponseWrapper(localName = "greetMeResponse", targetNamespace = "http://apache.org/greeter_control/types", className = "org.apache.greeter_control.types.GreetMeResponse")
    public String greetMe(
        @WebParam(name = "requestType", targetNamespace = "http://apache.org/greeter_control/types")
        String requestType);

}
