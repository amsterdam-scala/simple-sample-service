package com.sample.service
package directives

import akka.event.LoggingAdapter

import spray.routing.Directive0
import spray.routing.directives.BasicDirectives
import spray.http.HttpRequest

trait CustomDirectives extends BasicDirectives {

  def log: LoggingAdapter

  def withExecutionTime: Directive0 = {
    mapRequestContext { ctx =>
      if (log.isDebugEnabled) {
        val start = System.currentTimeMillis()
        ctx.withRouteResponseMapped { response => logExecutionTimeForReq(ctx.request, start); response }
      } else {
        ctx
      }
    }
  }

  private def logExecutionTimeForReq(request: HttpRequest, start: Long) = {
    val end = System.currentTimeMillis()
    log.debug("Request {} -> {} took {} ms to be processed", request.method.name, request.uri.path, end - start)
  }
}
