package com.github.ckozak.maps

import cats.Semigroup
import org.openjdk.jmh.annotations.{ Benchmark, Scope, State }

import scala.util.Random
import cats.implicits._

@State(Scope.Benchmark)
class SemigroupListBenchmarkState {

  def generateApp() =
    TestApp(Random.nextString(20), Random.nextInt(1000).toString)

  val rawApps = for {
    i <- 1 to 100000
  } yield generateApp()

  val appList = rawApps.map(app => app.id -> List(app)).toMap
  val appSet = rawApps.map(app => app.id -> Set(app)).toMap

  val candidate = generateApp()

  val mapAdditionSemigroup: Semigroup[Map[String, List[TestApp]]] = new Semigroup[Map[String, List[TestApp]]] {
    override def combine(x: Map[String, List[TestApp]], y: Map[String, List[TestApp]]): Map[String, List[TestApp]] = {
      y.foldLeft(x) {
        case (agg, (id, list)) =>
          val newList = list ::: agg.getOrElse(id, List.empty)
          agg + (id -> newList)
      }
    }
  }
}

case class TestApp(id: String, foreignKey: String)

class SemigroupListBenchmark {

  @Benchmark
  def appListSemigroupCustom(state: SemigroupListBenchmarkState): Map[String, List[TestApp]] = {
    val appByCompany = Map(state.candidate.foreignKey -> List(state.candidate))
    state.mapAdditionSemigroup.combine(state.appList, appByCompany)
  }

  @Benchmark
  def appListSemigroup(state: SemigroupListBenchmarkState): Map[String, List[TestApp]] = {
    val appByCompany = Map(state.candidate.foreignKey -> List(state.candidate))
    state.appList |+| appByCompany
  }

  @Benchmark
  def appListRaw(state: SemigroupListBenchmarkState): Map[String, List[TestApp]] = {
    val templatesForEncoding = state.candidate :: state.appList.getOrElse(state.candidate.foreignKey, List.empty)
    state.appList + (state.candidate.foreignKey -> templatesForEncoding)
  }

  //  @Benchmark
  //  def appSetSemigroup(state: SemigroupAppBenchmarkState): Map[String, Set[TestApp]] = {
  //    val appByCompany = Map(state.candidate.foreignKey -> Set(state.candidate))
  //    state.appSet |+| appByCompany
  //  }
  //
  //  @Benchmark
  //  def appSetRaw(state: SemigroupAppBenchmarkState): Map[String, Set[TestApp]] = {
  //    val templatesForEncoding = state.appSet.getOrElse(state.candidate.foreignKey, Set.empty) + state.candidate
  //    state.appSet + (state.candidate.foreignKey -> templatesForEncoding)
  //  }
}
