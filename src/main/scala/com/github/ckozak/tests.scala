package com.github.ckozak

import java.util.UUID

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper
import org.json4s.DefaultFormats

import spray.json.DefaultJsonProtocol


import scala.util.Random

case class Example(
  id: String,
  string: String,
  double: Double,
  date: Long,
  date2: Long
)

object Utils {
  def randomId: String = UUID.randomUUID().toString
  def randomDouble = Random.nextDouble()

  def randomExample =
    Example(randomId, randomId, randomDouble, System.currentTimeMillis(), System.currentTimeMillis())
}

object SprayJsonUtils {
  object MyJsonProtocol extends DefaultJsonProtocol {
    implicit val exampleFormat = jsonFormat5(Example)
  }
}

object JacksonUtils {
  val objectMapper = {
    val objectMapper = new ObjectMapper with ScalaObjectMapper
    objectMapper.registerModule(DefaultScalaModule)
    objectMapper
  }
}

object Json4sUtils {
  implicit val formats = DefaultFormats
}

object PlayUtils {
  import play.api.libs.json._
  implicit val modelFormat = Json.format[Example]
}

object ArgonautUtils {
  import argonaut._, Argonaut._, Shapeless._

  implicit val encode = EncodeJson.of[Example]
  implicit val decode = DecodeJson.of[Example]
}