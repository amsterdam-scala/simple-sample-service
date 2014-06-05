package com.sample.service

import java.util.concurrent.TimeUnit

import scala.concurrent.duration._
import akka.actor.ActorSystem
import com.typesafe.config.Config

object ServiceMain extends App {
  implicit val system = ActorSystem("simple-service")

  // TODO setup & startup

  private[this] def startup(implicit system: ActorSystem, settings: Settings): Unit = {
    // TODO
  }
}

case class Settings(private val config: Config) {
  val Host = config.getString("service.http.host")
  val Port = config.getInt("service.http.port")
  val Timeout = FiniteDuration(config.getDuration("service.processing.timeout", TimeUnit.SECONDS), TimeUnit.SECONDS)
}
