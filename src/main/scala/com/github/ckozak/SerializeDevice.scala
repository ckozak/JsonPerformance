package com.github.ckozak

import com.github.ckozak.models.Device
import org.openjdk.jmh.annotations.{Benchmark, Scope, State}
import upickle.default._
import org.scalacheck.Shapeless._
import org.scalacheck._

@State(Scope.Benchmark)
class DeviceHolder {
  val item = Arbitrary.arbitrary[Device].sample.get
}

class SerializeDevice {

  @Benchmark
  def jackson(state: DeviceHolder): Unit = {
    import JacksonUtils._
    objectMapper.writeValueAsString(state.item)
  }

  @Benchmark
  def circeJackson(state: DeviceHolder): Unit = {
    import io.circe.generic.auto._, io.circe.syntax._, io.circe.jackson._
    state.item.asJson.noSpaces
  }

  @Benchmark
  def circeJawn(state: DeviceHolder): Unit = {
    import io.circe.generic.auto._, io.circe.jawn._, io.circe.syntax._
    state.item.asJson.noSpaces
  }

  @Benchmark
  def sprayJson(state: DeviceHolder): Unit = {
    import spray.json._
    import SprayJsonUtils.MyJsonProtocol._
    state.item.toJson.compactPrint
  }

  @Benchmark
  def json4sJackson(state: DeviceHolder): Unit = {
    import Json4sUtils._
    org.json4s.jackson.Serialization.write(state.item)
  }

  @Benchmark
  def argonautJson(state: DeviceHolder): Unit = {

    import ArgonautUtils._
    import argonaut.Argonaut._

    state.item.asJson.nospaces
  }

  @Benchmark
  def playJson(state: DeviceHolder): Unit = {
    import play.api.libs.json._
    import PlayUtils._
    Json.toJson(state.item)
  }

  @Benchmark
  def liftweb(state: DeviceHolder): Unit = {
    import LiftwebUtils._
    import net.liftweb.json.Serialization.write
    write(state.item)
  }

  @Benchmark
  def upickle(state: DeviceHolder): Unit = {
    write(state.item)
  }
}
