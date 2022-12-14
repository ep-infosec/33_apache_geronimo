/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
 
package org.apache.geronimo.testsuite.javaee6.helloworld.web;

import java.io.*;

import javax.annotation.Resource;
import javax.servlet.ServletException;

import javax.servlet.http.*;

import javax.servlet.annotation.WebServlet;

@WebServlet("/hello")
public class HelloWorld extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Resource(name="welcomeMessage")
    private  String welcomeMessage;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        performTask(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        performTask(request, response);
    }
    
    protected void  performTask(HttpServletRequest request, HttpServletResponse response){
        PrintWriter out;
        try {
            out = response.getWriter();
            out.println(welcomeMessage);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
    }
}
