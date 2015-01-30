/*
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.elasticsearch.support.diagnostics.cat;

import com.google.api.client.http.HttpRequestFactory;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import org.elasticsearch.support.diagnostics.http.VersionedHttpRequestDiagnosticProcess;
import org.elasticsearch.support.diagnostics.settings.Version;

/**
 * {@code ThreadPoolDiagnosticProcess} performs a request to <code>{baseUrl}/_cat/thread_pool?v</code> and
 * writes to <code>"cat_thread_pool.txt"</code>.
 * <p />
 * The <code>_cat/thread_pool</code> API was not added until Elasticsearch 1.0.0.
 */
@Singleton
class ThreadPoolDiagnosticProcess extends VersionedHttpRequestDiagnosticProcess {
    /**
     * Create a new {@link ThreadPoolDiagnosticProcess}.
     */
    @Inject
    ThreadPoolDiagnosticProcess(HttpRequestFactory httpRequestFactory) {
        super("_cat/thread_pool?v", "cat_thread_pool.txt", httpRequestFactory, Version.VERSION_1_0, null);
    }
}
