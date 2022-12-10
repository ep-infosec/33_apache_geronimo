/**
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.apache.geronimo.security;

import java.security.Principal;


/**
 * @version $Rev$ $Date$
 */
public class PrimaryPrincipal implements Principal {

    private final Principal principal;

    public PrimaryPrincipal(Principal principal) {
        if (principal == null) throw new IllegalArgumentException("principal is null");
        this.principal = principal;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final PrimaryPrincipal that = (PrimaryPrincipal) o;

        if (!principal.equals(that.principal)) return false;

        return true;
    }

    public int hashCode() {
        return principal.hashCode();
    }

    public String getName() {
        return principal.getName();
    }
}
