package com.github.ckozak

import com.github.ckozak.models.Apps
import org.openjdk.jmh.annotations.{Benchmark, Scope, State}
import upickle.default._

import org.scalacheck.Shapeless._
import org.scalacheck._

@State(Scope.Benchmark)
class AppHolder {
  val item = Arbitrary.arbitrary[Apps].sample.get
}

class SerializeApp {

  @Benchmark
  def jackson(state: AppHolder): Unit = {
    import JacksonUtils._
    objectMapper.writeValueAsString(state.item)
  }

  @Benchmark
  def circeJackson(state: AppHolder): Unit = {
    import io.circe.generic.auto._, io.circe.syntax._, io.circe.jackson._
    state.item.asJson.noSpaces
  }

  @Benchmark
  def circeJawn(state: AppHolder): Unit = {
    import io.circe.generic.auto._, io.circe.jawn._, io.circe.syntax._
    state.item.asJson.noSpaces
  }

  @Benchmark
  def json4sJackson(state: AppHolder): Unit = {
    import Json4sUtils._
    org.json4s.jackson.Serialization.write(state.item)
  }

  @Benchmark
  def liftweb(state: AppHolder): Unit = {
    import LiftwebUtils._
    import net.liftweb.json.Serialization.write
    write(state.item)
  }

  @Benchmark
  def upickle(state: AppHolder): Unit = {
    write(state.item)
  }
}
