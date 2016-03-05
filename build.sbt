name := "JsonBenchmark"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core" % "0.3.0",
  "io.circe" %% "circe-generic" % "0.3.0",
  "io.circe" %% "circe-parser" % "0.3.0",
  "io.circe" %% "circe-jackson" % "0.3.0"
)

libraryDependencies ++= Seq(
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.7.2",
  "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.7.2"
)

libraryDependencies += "org.json4s" %% "json4s-jackson" % "3.3.0"
libraryDependencies += "io.spray" %%  "spray-json" % "1.3.2"
libraryDependencies += "net.liftweb" % "lift-json_2.11" % "3.0-M8"
libraryDependencies += "com.typesafe.play" % "play-json_2.11" % "2.5.0"

libraryDependencies ++= Seq(
  "io.argonaut" %% "argonaut" % "6.1",
  "com.github.alexarchambault" %% "argonaut-shapeless_6.1" % "1.0.0-RC1"
)



enablePlugins(JmhPlugin)