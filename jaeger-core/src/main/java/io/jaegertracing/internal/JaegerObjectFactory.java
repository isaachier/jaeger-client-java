/*
 * Copyright (c) 2018, Uber Technologies, Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package io.jaegertracing.internal;

import java.util.List;
import java.util.Map;

public class JaegerObjectFactory {
  public JaegerSpan createSpan(
      JaegerTracer tracer,
      String operationName,
      JaegerSpanContext context,
      long startTimeMicroseconds,
      long startTimeNanoTicks,
      boolean computeDurationViaNanoTicks,
      Map<String, Object> tags,
      List<Reference> references) {
    return new JaegerSpan(
        tracer,
        operationName,
        context,
        startTimeMicroseconds,
        startTimeNanoTicks,
        computeDurationViaNanoTicks,
        tags,
        references);
  }

  public JaegerSpanContext createSpanContext(
      long traceId,
      long spanId,
      long parentId,
      byte flags,
      Map<String, String> baggage,
      String debugId) {
    return new JaegerSpanContext(traceId, spanId, parentId, flags, baggage, debugId, this);
  }

  public JaegerTracer.SpanBuilder createSpanBuilder(JaegerTracer tracer, String operationName) {
    return tracer.new SpanBuilder(operationName);
  }
}
