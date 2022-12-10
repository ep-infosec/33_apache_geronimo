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

package org.apache.geronimo.kernel.config.transformer;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @version $Rev:$ $Date:$
 */
public class PatternFilter implements FileFilter {

    private final Pattern pattern;
    
    public PatternFilter(Pattern pattern) {
        if (null == pattern) {
            throw new IllegalArgumentException("pattern is required");
        }
        this.pattern = pattern;
    }

    public boolean accept(File pathname) {
        Matcher matcher = pattern.matcher(pathname.getName());
        return matcher.matches();
    }

}