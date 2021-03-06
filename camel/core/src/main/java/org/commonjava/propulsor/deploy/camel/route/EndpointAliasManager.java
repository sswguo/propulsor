/**
 * Copyright (C) 2015 John Casey (jdcasey@commonjava.org)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.commonjava.propulsor.deploy.camel.route;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;

/**
 * Contains aliases from keys that can be used within route definitions, to actual endpoint URIs that define a protocol
 * for the endpoint. This provides the opportunity to change deployment topologies for the same application by simply
 * changing the endpoint aliases.
 */
@ApplicationScoped
public class EndpointAliasManager
{
    private Map<String, String> routeMap = new HashMap<>();

    public synchronized void loadAliasMap( Map<String, String> aliases )
    {
        this.routeMap = new HashMap<>( aliases );
    }

    public String lookup( String key )
    {
        return routeMap.computeIfAbsent( key, k->k );
    }
}
