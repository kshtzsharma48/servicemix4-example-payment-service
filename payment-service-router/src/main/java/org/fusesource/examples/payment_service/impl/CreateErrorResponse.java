/*
 * Copyright 2010 FuseSource
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

package org.fusesource.examples.payment_service.impl;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.fusesource.examples.payment_service.types.TransferResponse;

public class CreateErrorResponse implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        TransferResponse response = new TransferResponse();

        response.setReply("Fail: could not find target bank service '" + exchange.getProperty("targetBank") + "'");

        exchange.getIn().setBody(response);
    }
}