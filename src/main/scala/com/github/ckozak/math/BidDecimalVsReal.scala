package com.github.ckozak.math

import org.openjdk.jmh.annotations.{ Benchmark, Scope, State }
import spire.math.Real

import scala.util.Random

@State(Scope.Benchmark)
class BidDecimalVsRealState {

  val seed = Random.nextDouble()
  val seed2 = Random.nextDouble()

  val bidDecimal = BigDecimal(seed)
  val bidDecimal2 = BigDecimal(seed2)

  val real = Real(seed)
  val real2 = Real(seed2)
}

class BidDecimalVsReal {

  @Benchmark
  def multiplyBigDecimal(state: BidDecimalVsRealState): BigDecimal = {
    val result = state.bidDecimal * state.bidDecimal2
    result
  }

  @Benchmark
  def multiplyReal(state: BidDecimalVsRealState): Real = {
    val result = state.real * state.real2
    result
  }

  //@Benchmark
  def divideBigDecimal(state: BidDecimalVsRealState): Unit = {
    state.bidDecimal / state.bidDecimal2
  }

  //@Benchmark
  def divideReal(state: BidDecimalVsRealState): Unit = {
    state.real / state.real2
  }

  //@Benchmark
  def addBigDecimal(state: BidDecimalVsRealState): Unit = {
    state.bidDecimal + state.bidDecimal2
  }

  //@Benchmark
  def addReal(state: BidDecimalVsRealState): Unit = {
    state.real + state.real2
  }

}
