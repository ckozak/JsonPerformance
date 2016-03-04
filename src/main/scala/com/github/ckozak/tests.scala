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

  implicit val formats = DefaultFormats

  object MyJsonProtocol extends DefaultJsonProtocol {
    implicit val exampleFormat = jsonFormat5(Example)
  }

  val objectMapper = {
    val objectMapper = new ObjectMapper with ScalaObjectMapper
    objectMapper.registerModule(DefaultScalaModule)
    objectMapper
  }

  def randomExample =
    Example(randomId, randomId, randomDouble, System.currentTimeMillis(), System.currentTimeMillis())
}