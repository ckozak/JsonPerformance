package com.github.ckozak

import java.util.UUID

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper

import scala.util.Random

case class Example(
  id: String,
  string: String,
  double: Double,
  date: Long,
  date2: Long
)

case class ExampleSemiAuto(
  id: String,
  string: String,
  double: Double,
  date: Long,
  date2: Long
)

object ExampleSemiAuto {
  import io.circe._, io.circe.generic.semiauto._

  implicit val decodeFoo: Decoder[ExampleSemiAuto] = deriveDecoder[ExampleSemiAuto]
  implicit val encodeFoo: Encoder[ExampleSemiAuto] = deriveEncoder[ExampleSemiAuto]
}

object Utils {
  def randomId: String = UUID.randomUUID().toString
  def randomDouble = Random.nextDouble()

  val objectMapper = {
    val objectMapper = new ObjectMapper with ScalaObjectMapper
    objectMapper.registerModule(DefaultScalaModule)
    objectMapper
  }

  def randomCampaignSpend =
    Example(randomId, randomId, randomDouble, System.currentTimeMillis(), System.currentTimeMillis())
}