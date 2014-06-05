
package com.sample.service
package processor

import akka.actor.{ ActorLogging, Actor }

class ProcessingActor extends Actor with ActorLogging {

  override def preStart() {
    log.debug("Starting new processor...")
  }

  def receive = ???
}
