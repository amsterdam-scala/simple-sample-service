package com.sample.service
package http

import akka.actor.ActorLogging
import spray.routing.{ HttpService, HttpServiceActor }

class ApiActor(settings: Settings) extends HttpServiceActor with HttpService with ActorLogging {
  def receive = ???
}