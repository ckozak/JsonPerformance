package com.github.ckozak.maps

import org.openjdk.jmh.annotations.{ Benchmark, Scope, State }

import scala.util.Random

@State(Scope.Benchmark)
class CollectionAddBenchmarkState {

  val smallSeq = (for (i <- 1 to 1000) yield Random.nextInt()).toSeq
  val mediumSeq = (for (i <- 1 to 100000) yield Random.nextInt()).toSeq
  val largeSeq = (for (i <- 1 to 1000000) yield Random.nextInt()).toSeq
  val hugeSeq = (for (i <- 1 to 10000000) yield Random.nextInt()).toSeq

  val smallList = (for (i <- 1 to 1000) yield Random.nextInt()).toList
  val mediumList = (for (i <- 1 to 100000) yield Random.nextInt()).toList
  val largeList = (for (i <- 1 to 1000000) yield Random.nextInt()).toList
  val hugeList = (for (i <- 1 to 10000000) yield Random.nextInt()).toList

  val candidate = Random.nextInt()
}

class CollectionAddBenchmark {

  @Benchmark
  def seqSmall(state: CollectionAddBenchmarkState): Seq[Int] = {
    state.smallSeq :+ state.candidate
  }

  @Benchmark
  def seqMedium(state: CollectionAddBenchmarkState): Seq[Int] = {
    state.mediumSeq :+ state.candidate
  }

  @Benchmark
  def seqLarge(state: CollectionAddBenchmarkState): Seq[Int] = {
    state.largeSeq :+ state.candidate
  }

  @Benchmark
  def seqHuge(state: CollectionAddBenchmarkState): Seq[Int] = {
    state.hugeSeq :+ state.candidate
  }

  @Benchmark
  def listSmall(state: CollectionAddBenchmarkState): Seq[Int] = {
    state.candidate :: state.smallList
  }

  @Benchmark
  def listMedium(state: CollectionAddBenchmarkState): Seq[Int] = {
    state.candidate :: state.mediumList
  }

  @Benchmark
  def listLarge(state: CollectionAddBenchmarkState): Seq[Int] = {
    state.candidate :: state.largeList
  }

  @Benchmark
  def listHuge(state: CollectionAddBenchmarkState): Seq[Int] = {
    state.candidate :: state.hugeList
  }
}

