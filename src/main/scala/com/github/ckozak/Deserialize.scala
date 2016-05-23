package com.github.ckozak

import org.openjdk.jmh.annotations.{ Scope, State, Benchmark }
import argonaut._, Argonaut._

import org.scalacheck.Shapeless._
import org.scalacheck._

import upickle.default._

@State(Scope.Benchmark)
class JsonHolder {
  val item = """{
               	"id": "sdfhls",
               	"string": "khojkm",
               	"double": 3.2,
               	"date": 345678987654,
               	"date2": 4567890098765
               }"""
}

class Deserialize {

  @Benchmark
  def jackson(state: JsonHolder): Unit = {
    import JacksonUtils._
    objectMapper.readValue[Example](state.item)
  }

  @Benchmark
  def json4sJackson(state: JsonHolder): Unit = {
    import Json4sUtils._
    org.json4s.jackson.Serialization.read[Example](state.item)
  }

  @Benchmark
  def circeJackson(state: JsonHolder): Unit = {
    import io.circe.generic.auto._, io.circe.jackson._
    decode[Example](state.item)
  }

  @Benchmark
  def circeJawn(state: JsonHolder): Unit = {
    import io.circe.generic.auto._, io.circe.jawn._
    decode[Example](state.item)
  }

  @Benchmark
  def sprayJson(state: JsonHolder): Unit = {
    import spray.json._
    import SprayJsonUtils.MyJsonProtocol._
    state.item.parseJson.convertTo[Example]
  }

  @Benchmark
  def argonaut(state: JsonHolder): Unit = {
    import ArgonautUtils._
    state.item.decodeOption[Example]
  }

  @Benchmark
  def playJson(state: JsonHolder): Unit = {
    import play.api.libs.json._
    import PlayUtils._
    Json.fromJson[Example](Json.parse(state.item))
  }

  @Benchmark
  def liftweb(state: JsonHolder): Unit = {
    import LiftwebUtils._
    import net.liftweb.json.Serialization.read
    read[Example](state.item)
  }

  @Benchmark
  def upickle(state: JsonHolder): Unit = {
    read[Example](state.item)
  }
}
