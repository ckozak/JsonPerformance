package com.github.ckozak

import Utils._
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper
import org.openjdk.jmh.annotations.{Scope, State, Benchmark}
import io.circe._, io.circe.generic.auto._, io.circe.syntax._, io.circe.jackson._

@State(Scope.Benchmark)
class ListHolder {
  val list = createList(1000000)
}

class Deserialize {

  @Benchmark
  def jackson(state: ListHolder): Unit = {
    state.list map { s =>
      objectMapper.readValue[CampaignSpend](s)
    }
  }

  @Benchmark
  def circe(state: ListHolder): Unit = {
    state.list map { s =>
      decode[CampaignSpend](s)
    }
  }
}
