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

package org.apache.shardingsphere.infra.config.database;

import org.apache.shardingsphere.infra.config.rule.RuleConfiguration;
import org.apache.shardingsphere.infra.datasource.pool.props.domain.DataSourcePoolProperties;
import org.apache.shardingsphere.infra.datasource.storage.StorageResource;

import javax.sql.DataSource;
import java.util.Collection;
import java.util.Map;

/**
 * Database configuration.
 */
public interface DatabaseConfiguration {
    
    /**
     * Get data sources.
     * 
     * @return data sources
     */
    Map<String, DataSource> getDataSources();
    
    /**
     * Get rule configurations.
     * 
     * @return rule configurations
     */
    Collection<RuleConfiguration> getRuleConfigurations();
    
    /**
     * Get storage resource.
     *
     * @return storage resource
     */
    StorageResource getStorageResource();
    
    /**
     * Get data source pool properties map.
     *
     * @return data source pool properties map
     */
    Map<String, DataSourcePoolProperties> getDataSourcePoolPropertiesMap();
}
