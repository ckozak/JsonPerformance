package com.github.ckozak

import java.util.UUID

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