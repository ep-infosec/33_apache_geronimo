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


package org.apache.geronimo.jasper;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.jasper.Constants;
import org.apache.jasper.servlet.JspServlet;

/**
 * @version $Rev$ $Date$
 */
public class JspFileServlet extends JspServlet {

    private String jspFile;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        jspFile = config.getInitParameter("jspFile");
        if (jspFile == null) {
            throw new ServletException("Must supply jspFile init param");
        }
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute(Constants.JSP_FILE, jspFile);
        try {
            super.service(request, response);
        } finally {
            request.removeAttribute(Constants.JSP_FILE);
        }
    }
}
