/* $Id: Obfuscate.java 988245 2010-08-23 18:39:35Z kwright $ */

/**
* Licensed to the Apache Software Foundation (ASF) under one or more
* contributor license agreements. See the NOTICE file distributed with
* this work for additional information regarding copyright ownership.
* The ASF licenses this file to You under the Apache License, Version 2.0
* (the "License"); you may not use this file except in compliance with
* the License. You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package org.apache.manifoldcf.authorities;

import org.apache.manifoldcf.authorities.interfaces.AuthorityConnectorManagerFactory;
import org.apache.manifoldcf.authorities.interfaces.IAuthorityConnectorManager;
import org.apache.manifoldcf.authorities.system.ManifoldCF;
import org.apache.manifoldcf.core.InitializationCommand;
import org.apache.manifoldcf.core.interfaces.IThreadContext;
import org.apache.manifoldcf.core.interfaces.ManifoldCFException;
import org.apache.manifoldcf.core.interfaces.ThreadContextFactory;

/**
 * @author Jettro Coenradie
 */
public abstract class BaseAuthoritiesInitializationCommand implements InitializationCommand
{
  public void execute() throws ManifoldCFException
  {
    IThreadContext tc = ThreadContextFactory.make();
    ManifoldCF.initializeEnvironment(tc);
    IAuthorityConnectorManager mgr = AuthorityConnectorManagerFactory.make(tc);

    doExecute(mgr);
  }

  protected abstract void doExecute(IAuthorityConnectorManager mgr) throws ManifoldCFException;
}
