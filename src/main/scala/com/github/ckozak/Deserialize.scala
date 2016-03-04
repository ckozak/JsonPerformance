package com.github.ckozak

import Utils._
import org.openjdk.jmh.annotations.{Scope, State, Benchmark}
import io.circe._, io.circe.generic.auto._, io.circe.syntax._

@State(Scope.Benchmark)
class ListHolder {
  val item = objectMapper.writeValueAsString(randomCampaignSpend)
}

class Deserialize {

  @Benchmark
  def jackson(state: ListHolder): Unit = {
    objectMapper.readValue[CampaignSpend](state.item)
  }

  @Benchmark
  def circeJackson(state: ListHolder): Unit = {
    import io.circe.jackson._
    decode[CampaignSpend](state.item)
  }

  @Benchmark
  def circeJawn(state: ListHolder): Unit = {
    import io.circe.jawn._
    decode[CampaignSpend](state.item)
  }
}
