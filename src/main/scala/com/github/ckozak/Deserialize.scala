package com.github.ckozak

import Utils._
import org.openjdk.jmh.annotations.{Scope, State, Benchmark}
import io.circe._, io.circe.generic.auto._, io.circe.syntax._

@State(Scope.Benchmark)
class JsonHolder {
  val item = objectMapper.writeValueAsString(randomCampaignSpend)
}

class Deserialize {

  @Benchmark
  def jackson(state: JsonHolder): Unit = {
    objectMapper.readValue[Example](state.item)
  }

  @Benchmark
  def circeJackson(state: JsonHolder): Unit = {
    import io.circe.jackson._
    decode[Example](state.item)
  }

  @Benchmark
  def circeJawn(state: JsonHolder): Unit = {
    import io.circe.jawn._
    decode[Example](state.item)
  }
}
