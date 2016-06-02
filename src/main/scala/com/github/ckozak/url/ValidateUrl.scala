package com.github.ckozak.url

import java.net.URL

import org.apache.commons.validator.routines.UrlValidator
import org.openjdk.jmh.annotations.{Benchmark, Scope, State}

import scala.util.Try

@State(Scope.Benchmark)
class ValidateState {
  val validUrl = "http://google.com/calendar.html"
  val invalidUrl = "dfjkdlsfdsf"

  val validator = UrlValidator.getInstance()
}

class ValidateUrl {

  @Benchmark
  def successWithNewUrl(state: ValidateState): Unit = {
    Try(new URL(state.validUrl)).isSuccess
  }

  @Benchmark
  def successWithUrlValidator(state: ValidateState): Unit = {
    state.validator.isValid(state.validUrl)
  }

  @Benchmark
  def failureWithNewUrl(state: ValidateState): Unit = {
    Try(new URL(state.invalidUrl)).isSuccess
  }

  @Benchmark
  def failureWithUrlValidator(state: ValidateState): Unit = {
    state.validator.isValid(state.invalidUrl)
  }

}
