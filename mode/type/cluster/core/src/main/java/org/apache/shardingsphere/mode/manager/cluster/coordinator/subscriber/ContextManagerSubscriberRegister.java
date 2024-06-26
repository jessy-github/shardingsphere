/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.mode.manager.cluster.coordinator.subscriber;

import org.apache.shardingsphere.infra.util.eventbus.EventBusContext;
import org.apache.shardingsphere.infra.util.eventbus.EventSubscriber;
import org.apache.shardingsphere.mode.manager.ContextManager;
import org.apache.shardingsphere.mode.manager.cluster.coordinator.RegistryCenter;
import org.apache.shardingsphere.mode.manager.cluster.coordinator.registry.process.subscriber.ProcessListChangedSubscriber;

import java.util.Arrays;
import java.util.Collection;

/**
 * Context manager subscriber register.
 */
public final class ContextManagerSubscriberRegister implements EventSubscriber {
    
    private final EventBusContext eventBusContext;
    
    private final Collection<EventSubscriber> subscribers;
    
    public ContextManagerSubscriberRegister(final RegistryCenter registryCenter, final ContextManager contextManager) {
        eventBusContext = contextManager.getInstanceContext().getEventBusContext();
        subscribers = Arrays.asList(
                new ConfigurationChangedSubscriber(contextManager),
                new ResourceMetaDataChangedSubscriber(contextManager),
                new DatabaseChangedSubscriber(contextManager),
                new StateChangedSubscriber(contextManager, registryCenter),
                new ProcessListChangedSubscriber(contextManager, registryCenter),
                new CacheEvictedSubscriber());
    }
    
    /**
     * Register subscribers.
     */
    public void register() {
        subscribers.forEach(eventBusContext::register);
    }
}
