package com.github.ckozak

import Utils._
import org.openjdk.jmh.annotations.{Scope, State, Benchmark}
import io.circe._, io.circe.generic.auto._, io.circe.syntax._

@State(Scope.Benchmark)
class SpendHolder {
  val item = randomCampaignSpend
}

class Serialize {

  @Benchmark
  def jackson(state: SpendHolder): Unit = {
    objectMapper.writeValueAsString(state.item)
  }

  @Benchmark
  def circe(state: SpendHolder): Unit = {
    state.item.asJson.noSpaces
  }
}
