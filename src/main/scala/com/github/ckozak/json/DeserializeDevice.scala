package com.github.ckozak.json

import argonaut.Argonaut._
import com.github.ckozak.json.models.Device
import org.openjdk.jmh.annotations.{Benchmark, Scope, State}
import upickle.default._

@State(Scope.Benchmark)
class DevicesHolder {
  val item = """{
                 "deviceId": "SLFH;SDLFJAS;FJASDLFKJSADFJKDFN",
                 "lists": [
                   "lsdfjsd",
                   "sdf",
                   "sdfdsfdsfdsf",
                   "sdflsdfj",
                   "sdfhlsdjf",
                   "skdfsdlfja",
                   "sdfhalksjf",
                   "skfhslkdjf"
                 ],
                 "moreLists": [
                   "ksdjfksdf",
                   "sdhfalsdf",
                   "sdfla"
                 ]
               }"""
}

class DeserializeDevice {

  @Benchmark
  def jackson(state: DevicesHolder): Unit = {
    import JacksonUtils._
    objectMapper.readValue[Device](state.item)
  }

  @Benchmark
  def json4sJackson(state: DevicesHolder): Unit = {
    import Json4sUtils._
    org.json4s.jackson.Serialization.read[Device](state.item)
  }

  @Benchmark
  def circeJackson(state: DevicesHolder): Unit = {
    import io.circe.generic.auto._, io.circe.jackson._
    decode[Device](state.item)
  }

  @Benchmark
  def circeJawn(state: DevicesHolder): Unit = {
    import io.circe.generic.auto._, io.circe.jawn._
    decode[Device](state.item)
  }

  @Benchmark
  def sprayJson(state: DevicesHolder): Unit = {
    import spray.json._
    import SprayJsonUtils.MyJsonProtocol._
    state.item.parseJson.convertTo[Device]
  }

  /*@Benchmark
  def argonaut(state: DevicesHolder): Unit = {
    import ArgonautUtils._
    state.item.decodeOption[Device]
  }*/

  @Benchmark
  def playJson(state: DevicesHolder): Unit = {
    import play.api.libs.json._
    import PlayUtils._
    Json.fromJson[Device](Json.parse(state.item))
  }

  @Benchmark
  def liftweb(state: DevicesHolder): Unit = {
    import LiftwebUtils._
    import net.liftweb.json.Serialization.read
    read[Device](state.item)
  }

  @Benchmark
  def upickle(state: DevicesHolder): Unit = {
    read[Device](state.item)
  }
}
