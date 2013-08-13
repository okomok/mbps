import sbt._
import Keys._

object build extends Build {
    lazy val theSettings = Project.defaultSettings ++ Seq(
        organization := "com.github.okomok",
        version := "0.0.1-SNAPSHOT",
        scalaVersion := "2.10.2",

        scalacOptions ++=
            Seq("-unchecked", "-deprecation", "-feature") ++
            Seq("-Yrecursion", "50") ++ Seq("-language", "higherKinds"),


        libraryDependencies ++= Seq(
            "org.scalatest" % "scalatest_2.10" % "1.9.1" % "test",
            "junit" % "junit" % "4.4" % "test"
        ),

        resolvers += Resolver.sonatypeRepo("snapshots"),
        addCompilerPlugin("org.scala-lang.plugins" % "macro-paradise_2.10.2" % "2.0.0-SNAPSHOT"),

        parallelExecution := false,
        publishArtifact in packageDoc := false//,
//        offline := true
    )

    lazy val root = Project(
        "root",
        file("core"),
        settings = theSettings
    ) aggregate(macros, core)

    lazy val macros = Project(
        "macros",
        file("macros"),
        settings = theSettings ++ Seq(
            libraryDependencies <+= (scalaVersion)("org.scala-lang" % "scala-reflect" % _))
    )

    lazy val core = Project(
        "core",
        file("core"),
        settings = theSettings
    ) dependsOn(macros)
}
