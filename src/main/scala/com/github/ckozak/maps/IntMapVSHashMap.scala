package com.github.ckozak.maps

import org.openjdk.jmh.annotations.{ Benchmark, Scope, State }

import scala.collection.immutable.{ HashMap, IntMap, TreeMap }
import scala.util.Random

@State(Scope.Benchmark)
class IntMapVSHashMapState {
  private val numbers1000 = (0 to 1000).map(_ => Random.nextInt()).toArray
  private val numbers100000 = (0 to 100000).map(_ => Random.nextInt()).toArray
  private val numbers1000000 = (0 to 1000000).map(_ => Random.nextInt()).toArray

  private val base1000 = numbers1000.map(i => (i, new Object))
  private val base100000 = numbers100000.map(i => (i, new Object))
  private val base1000000 = numbers1000000.map(i => (i, new Object))

  val select1000 = Random.nextInt(numbers1000.length)
  val select1000_10 = 0 to 10 map (_ => Random.nextInt(numbers1000.length))

  val select100000 = Random.nextInt(numbers100000.length)
  val select100000_10 = 0 to 10 map (_ => Random.nextInt(numbers100000.length))

  val select1000000 = Random.nextInt(numbers1000000.length)
  val select1000000_10 = 0 to 10 map (_ => Random.nextInt(numbers1000000.length))

  val intMap1000 = IntMap(base1000: _*)
  val hashMap1000 = HashMap(base1000: _*)
  val treeMap1000 = TreeMap(base1000: _*)

  val intMap100000 = IntMap(base100000: _*)
  val hashMap100000 = HashMap(base100000: _*)
  val treeMap100000 = TreeMap(base100000: _*)

  val intMap1000000 = IntMap(base1000000: _*)
  val hashMap1000000 = HashMap(base1000000: _*)
  val treeMap1000000 = TreeMap(base1000000: _*)
}

class IntMapVSHashMapVsTreeMapOne {
  @Benchmark
  def intMap1000Get(state: IntMapVSHashMapState): Unit = {
    state.intMap1000.get(state.select1000)
  }

  @Benchmark
  def hashMap1000Get(state: IntMapVSHashMapState): Unit = {
    state.hashMap1000.get(state.select1000)
  }

  @Benchmark
  def treeMap1000Get(state: IntMapVSHashMapState): Unit = {
    state.treeMap1000.get(state.select1000)
  }

  @Benchmark
  def intMap100000Get(state: IntMapVSHashMapState): Unit = {
    state.intMap100000.get(state.select100000)
  }

  @Benchmark
  def hashMap100000Get(state: IntMapVSHashMapState): Unit = {
    state.hashMap100000.get(state.select100000)
  }

  @Benchmark
  def treeMap100000Get(state: IntMapVSHashMapState): Unit = {
    state.treeMap100000.get(state.select100000)
  }

  @Benchmark
  def intMap1000000Get(state: IntMapVSHashMapState): Unit = {
    state.intMap1000000.get(state.select1000000)
  }

  @Benchmark
  def hashMap1000000Get(state: IntMapVSHashMapState): Unit = {
    state.hashMap1000000.get(state.select1000000)
  }

  @Benchmark
  def treeMap1000000Get(state: IntMapVSHashMapState): Unit = {
    state.treeMap1000000.get(state.select1000000)
  }
}

class IntMapVSHashMapVsTreeMapTen {
  @Benchmark
  def intMapGet10(state: IntMapVSHashMapState): Unit = {
    state.select1000_10 map (i => state.intMap1000.get(i))
  }

  @Benchmark
  def hashMapGet10(state: IntMapVSHashMapState): Unit = {
    state.select1000_10 map (i => state.hashMap1000.get(i))
  }

  @Benchmark
  def treeMapGet10(state: IntMapVSHashMapState): Unit = {
    state.select1000_10 map (i => state.treeMap1000.get(i))
  }

  @Benchmark
  def intMapGet100000(state: IntMapVSHashMapState): Unit = {
    state.select100000_10 map (i => state.intMap100000.get(i))
  }

  @Benchmark
  def hashMapGet100000(state: IntMapVSHashMapState): Unit = {
    state.select100000_10 map (i => state.hashMap100000.get(i))
  }

  @Benchmark
  def treeMapGet100000(state: IntMapVSHashMapState): Unit = {
    state.select100000_10 map (i => state.treeMap100000.get(i))
  }

  @Benchmark
  def intMapGet1000000(state: IntMapVSHashMapState): Unit = {
    state.select1000000_10 map (i => state.intMap1000000.get(i))
  }

  @Benchmark
  def hashMapGet1000000(state: IntMapVSHashMapState): Unit = {
    state.select1000000_10 map (i => state.hashMap1000000.get(i))
  }

  @Benchmark
  def treeMapGet1000000(state: IntMapVSHashMapState): Unit = {
    state.select1000000_10 map (i => state.treeMap1000000.get(i))
  }
}
