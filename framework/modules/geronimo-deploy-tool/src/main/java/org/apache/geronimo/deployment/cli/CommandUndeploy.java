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

package org.apache.geronimo.deployment.cli;

import javax.enterprise.deploy.spi.DeploymentManager;
import javax.enterprise.deploy.spi.TargetModuleID;
import javax.enterprise.deploy.spi.status.ProgressObject;

/**
 * the CLI deployer logic to undeploy.
 *
 * @version $Rev$ $Date$
 */
public class CommandUndeploy extends CommandStart {

    protected ProgressObject runCommand(ConsoleReader out, DeploymentManager mgr, TargetModuleID[] ids) {
        ProgressObject po = mgr.undeploy(ids);
        waitForProgress(out, po);
        return po;
    }

    protected String getAction() {
        return "Undeployed";
    }
}