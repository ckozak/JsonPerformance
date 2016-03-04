package com.github.ckozak

import Utils._
import org.openjdk.jmh.annotations.{Scope, State, Benchmark}
import io.circe._, io.circe.generic.auto._, io.circe.syntax._

@State(Scope.Benchmark)
class SpendHolder {
  val item = randomExample
}

class Serialize {

  @Benchmark
  def jackson(state: SpendHolder): Unit = {
    objectMapper.writeValueAsString(state.item)
  }

  @Benchmark
  def circeJackson(state: JsonHolder): Unit = {
    import io.circe.generic.auto._, io.circe.jackson._
    state.item.asJson.noSpaces
  }

  @Benchmark
  def circeJawn(state: JsonHolder): Unit = {
    import io.circe.generic.auto._, io.circe.jawn._
    state.item.asJson.noSpaces
  }

  @Benchmark
  def sprayJson(state: JsonHolder): Unit = {
    import spray.json._
    import Utils.MyJsonProtocol._
    state.item.toJson.compactPrint
  }

  @Benchmark
  def json4sNative(state: JsonHolder): Unit = {
    org.json4s.native.Serialization.write(state.item)
  }

  @Benchmark
  def json4sJackson(state: JsonHolder): Unit = {
    org.json4s.jackson.Serialization.write(state.item)
  }
}
