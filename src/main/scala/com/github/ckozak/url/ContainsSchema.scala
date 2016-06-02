package com.github.ckozak.url

import org.openjdk.jmh.annotations.{ Benchmark, Scope, State }

@State(Scope.Benchmark)
class ContainsSchemaState {
  val validUrl = "google://calendar.html"
  val invalidUrl = "google.com/calendar.html"
}

class ContainsSchema {

  @Benchmark
  def successWithRegex(state: ValidateState): Unit = {
    state.validUrl.matches(".*://.*")
  }

  @Benchmark
  def successWithContains(state: ValidateState): Unit = {
    state.validUrl.contains("://")
  }

  @Benchmark
  def successWithIndexOf(state: ValidateState): Unit = {
    state.validUrl.indexOf("://") != -1
  }

  @Benchmark
  def failureWithRegex(state: ValidateState): Unit = {
    state.invalidUrl.matches(".*://.*")
  }

  @Benchmark
  def failureWithContains(state: ValidateState): Unit = {
    state.invalidUrl.contains("://")
  }

  @Benchmark
  def failureWithIndexOf(state: ValidateState): Unit = {
    state.invalidUrl.indexOf("://") != -1
  }

}
