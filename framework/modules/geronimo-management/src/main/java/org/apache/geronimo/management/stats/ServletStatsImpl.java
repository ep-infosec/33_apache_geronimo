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
package org.apache.geronimo.management.stats;

import javax.management.j2ee.statistics.ServletStats;
import javax.management.j2ee.statistics.TimeStatistic;

/**
 * Geronimo implementation of the JSR-77 ServletStats interface.
 * 
 * @version $Rev: 476049 $ $Date: 2006-11-16 20:35:17 -0800 (Thu, 16 Nov 2006) $
 */
public class ServletStatsImpl extends StatsImpl implements ServletStats {
    private final TimeStatisticImpl serviceTime;

    public ServletStatsImpl() {
        serviceTime = new TimeStatisticImpl("Service Time",
                StatisticImpl.UNIT_TIME_MILLISECOND,
                "Execution time of the servlets service method");
        addStat("ServiceTime", serviceTime);
    }

    public TimeStatistic getServiceTime() {
        return serviceTime;
    }
}
