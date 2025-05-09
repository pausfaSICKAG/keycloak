/*
 * Copyright 2021 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.keycloak.quarkus.runtime.storage.infinispan;

import io.quarkus.arc.Arc;
import org.keycloak.Config;
import org.keycloak.cluster.ManagedCacheManagerProvider;
import org.keycloak.models.KeycloakSession;

/**
 * @author <a href="mailto:psilva@redhat.com">Pedro Igor</a>
 */
@SuppressWarnings({"unchecked", "resource"})
public final class QuarkusCacheManagerProvider implements ManagedCacheManagerProvider {

    @Override
    public <C> C getEmbeddedCacheManager(KeycloakSession keycloakSession, Config.Scope config) {
        return (C) Arc.container().instance(CacheManagerFactory.class).get().getOrCreateEmbeddedCacheManager(keycloakSession);
    }
}
