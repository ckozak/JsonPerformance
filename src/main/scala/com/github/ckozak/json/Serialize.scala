package com.github.ckozak.json

import com.github.ckozak.json.models.Example
import org.openjdk.jmh.annotations.{ Benchmark, Scope, State }
import org.scalacheck._
import upickle.default._

import org.scalacheck.Shapeless._
import org.scalacheck._

@State(Scope.Benchmark)
class SpendHolder {
  val item = Arbitrary.arbitrary[Example].sample.get
}

class Serialize {

  @Benchmark
  def jackson(state: SpendHolder): Unit = {
    import JacksonUtils._
    objectMapper.writeValueAsString(state.item)
  }

  @Benchmark
  def circeJackson(state: SpendHolder): Unit = {
    import io.circe.generic.auto._, io.circe.syntax._, io.circe.jackson._
    state.item.asJson.noSpaces
  }

  @Benchmark
  def circeJawn(state: SpendHolder): Unit = {
    import io.circe.generic.auto._, io.circe.jawn._, io.circe.syntax._
    state.item.asJson.noSpaces
  }

  @Benchmark
  def sprayJson(state: SpendHolder): Unit = {
    import spray.json._
    import SprayJsonUtils.MyJsonProtocol._
    state.item.toJson.compactPrint
  }

  @Benchmark
  def json4sJackson(state: SpendHolder): Unit = {
    import Json4sUtils._
    org.json4s.jackson.Serialization.write(state.item)
  }

  /*@Benchmark
  def argonautJson(state: SpendHolder): Unit = {

    import ArgonautUtils._
    import argonaut.Argonaut._

    state.item.asJson.nospaces
  }*/

  @Benchmark
  def playJson(state: SpendHolder): Unit = {
    import play.api.libs.json._
    import PlayUtils._
    Json.toJson(state.item)
  }

  @Benchmark
  def liftweb(state: SpendHolder): Unit = {
    import LiftwebUtils._
    import net.liftweb.json.Serialization.write
    write(state.item)
  }

  @Benchmark
  def upickle(state: SpendHolder): Unit = {
    write(state.item)
  }
}
