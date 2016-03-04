name := "JsonBenchmark"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core" % "0.3.0",
  "io.circe" %% "circe-generic" % "0.3.0",
  "io.circe" %% "circe-parser" % "0.3.0"
)

libraryDependencies += "io.circe" % "circe-jackson_2.11" % "0.3.0"


libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.7.2"
libraryDependencies += "com.fasterxml.jackson.module" % "jackson-module-scala_2.11" % "2.7.2"

enablePlugins(JmhPlugin)