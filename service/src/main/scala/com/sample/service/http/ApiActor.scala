package com.sample.service
package http

import akka.actor.ActorLogging
import spray.routing.{ Route, HttpService, HttpServiceActor }
import spray.http.StatusCodes

class ApiActor(settings: Settings) extends HttpServiceActor with HttpService with ActorLogging {
  import ApiActor._

  private[http] val timeout = settings.Timeout

  def receive = runRoute(route)

  private[service] def route: Route = {
    path(Ping) {
      get {
        complete(StatusCodes.OK -> "pong")
      }
    } ~
      pathPrefix(Api) {
        path(Service) {
          post {
            complete(StatusCodes.OK -> "TODO :)")
          }
        }
      }
  }
}

object ApiActor {
  private[service] val Ping = "ping"
  private[service] val Api = "api"
  private[service] val Service = "service"
}
