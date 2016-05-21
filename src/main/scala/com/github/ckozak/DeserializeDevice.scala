package com.github.ckozak

import org.openjdk.jmh.annotations.{Benchmark, Scope, State}
import argonaut._
import Argonaut._
import com.github.ckozak.models.Apps
import org.scalacheck.Shapeless._
import org.scalacheck._

@State(Scope.Benchmark)
class DevicesHolder {
  val item = {
    import JacksonUtils._
    objectMapper.writeValueAsString(Arbitrary.arbitrary[Apps].sample.get)
  }
}

class DeserializeDevice {

  @Benchmark
  def jackson(state: DevicesHolder): Unit = {
    import JacksonUtils._
    objectMapper.readValue[Apps](state.item)
  }

  @Benchmark
  def json4sJackson(state: DevicesHolder): Unit = {
    import Json4sUtils._
    org.json4s.jackson.Serialization.read[Apps](state.item)
  }

  @Benchmark
  def circeJackson(state: DevicesHolder): Unit = {
    import io.circe.generic.auto._, io.circe.jackson._
    decode[Apps](state.item)
  }

  @Benchmark
  def circeJawn(state: DevicesHolder): Unit = {
    import io.circe.generic.auto._, io.circe.jawn._
    decode[Apps](state.item)
  }

  @Benchmark
  def sprayJson(state: DevicesHolder): Unit = {
    import spray.json._
    import SprayJsonUtils.MyJsonProtocol._
    state.item.parseJson.convertTo[Apps]
  }

  @Benchmark
  def argonaut(state: DevicesHolder): Unit = {
    import ArgonautUtils._
    state.item.decodeOption[Apps]
  }

  @Benchmark
  def playJson(state: DevicesHolder): Unit = {
    import play.api.libs.json._
    import PlayUtils._
    Json.fromJson[Apps](Json.parse(state.item))
  }

  @Benchmark
  def liftweb(state: DevicesHolder): Unit = {
    import LiftwebUtils._
    import net.liftweb.json.Serialization.read
    read[Apps](state.item)
  }
}
