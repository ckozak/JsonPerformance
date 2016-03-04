package com.github.ckozak

import java.util.UUID
import java.util.concurrent.TimeUnit

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper

import scala.util.Random

case class CampaignSpend(
  campaignId: String,
  targetId: String,
  moneySpent: Double,
  maxEventTs: Long,
  messageTs: Long
)

object Utils {
  def randomId: String = UUID.randomUUID().toString
  def randomDouble = Random.nextDouble()

  val objectMapper = {
    val objectMapper = new ObjectMapper with ScalaObjectMapper
    objectMapper.registerModule(DefaultScalaModule)
    objectMapper
  }

  def randomCampaignSpend =
    CampaignSpend(randomId, randomId, randomDouble, System.currentTimeMillis(), System.currentTimeMillis())

  def createList(count: Int): List[String] =
    (1 to count map (_ => randomCampaignSpend) map objectMapper.writeValueAsString).toList
}

object JacksonTest extends App {

  import Utils._

  val list = createList(1000000)

  // warmup
  list.take(100).map(a => objectMapper.readValue[CampaignSpend](a))

  1 to 5 foreach { _ =>
    val start = System.nanoTime()
    list.foreach { s =>
      objectMapper.readValue[CampaignSpend](s)
    }
    val end = System.nanoTime()
    println(s"${TimeUnit.MILLISECONDS.convert(end - start, TimeUnit.NANOSECONDS)}ms")
  }
}

object CirceTest extends App  {
  import Utils._
  import io.circe._, io.circe.generic.auto._, io.circe.syntax._, io.circe.parser._

  val list = createList(1000000)

  list.take(100).map(a => decode[CampaignSpend](a))

  1 to 5 foreach { _ =>
    val start = System.nanoTime()
    list.foreach { s =>
      decode[CampaignSpend](s)
    }
    val end = System.nanoTime()
    println(s"${TimeUnit.MILLISECONDS.convert(end - start, TimeUnit.NANOSECONDS)}ms")
  }
}
