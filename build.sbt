ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "dawkinsWeasel"
  )

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.8" % "test"
)