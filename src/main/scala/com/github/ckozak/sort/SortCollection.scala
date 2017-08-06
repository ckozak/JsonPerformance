package com.github.ckozak.sort

import org.openjdk.jmh.annotations.{ Benchmark, Scope, State }

@State(Scope.Benchmark)
class SortCollectionState {

  val r = new java.util.Random()
  val unsorted = (1 to 9000000).toList.map(_ => r.nextInt())

  val sorted = unsorted.sorted

}

class SortCollection {
  @Benchmark
  def sortUnsorted(state: SortCollectionState): List[Int] = {
    state.unsorted.sorted
  }

  @Benchmark
  def sortSorted(state: SortCollectionState): List[Int] = {
    state.sorted.sorted
  }
}
