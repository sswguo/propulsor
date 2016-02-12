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
package org.commonjava.propulsor.deploy.undertow;

import org.commonjava.propulsor.boot.BootOptions;

public interface UndertowBootOptions
{

    UndertowBootOptions DEFAULT = new UndertowBootOptions()
    {
        private Integer port;

        @Override
        public String getContextPath()
        {
            return "/";
        }

        @Override
        public String getDeploymentName()
        {
            return "Web (Undertow)";
        }

        @Override
        public int getPort()
        {
            return port == null ? 8080 : port;
        }

        @Override
        public String getBind()
        {
            return "0.0.0.0";
        }

        @Override
        public void setPort( int port )
        {
            this.port = port;
        }
    };

    String getContextPath();

    String getDeploymentName();

    int getPort();

    String getBind();

    void setPort( int port );
}
