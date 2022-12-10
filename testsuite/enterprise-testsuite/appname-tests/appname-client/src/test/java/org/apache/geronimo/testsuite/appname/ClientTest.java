/**
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.apache.geronimo.testsuite.appname;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileInputStream;

import org.apache.geronimo.testsupport.TestSupport;
import org.testng.annotations.Test;

public class ClientTest extends TestSupport {

    @Test
    public void testClient() throws Exception {
        String outputFile = System.getProperty("clientLogFile");
        assertNotNull(outputFile);
        FileInputStream in = null;
        try {
            in = new FileInputStream(outputFile);
            BufferedReader reader = 
                new BufferedReader(new InputStreamReader(in));
            String output = toString(reader);

            assertTrue("AppName", output.indexOf("AppName: " + System.getProperty("appName")) != -1);
            assertTrue("ModuleName", output.indexOf("ModuleName: " + System.getProperty("appName")) != -1);

        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

    private String toString(BufferedReader reader)
        throws IOException {
        StringBuilder buf = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            buf.append(line).append("\n");
        }
        return buf.toString();
    }

}
