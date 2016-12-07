import xsbti.Severity

scalatex.SbtPlugin.projectSettings

name := "scalafmt-slides"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-xml" % "1.0.3",
  "com.lihaoyi" %% "scalatags" % "0.5.5"
)

scalacOptions += "-deprecation"

TaskKey[Unit]("check") := {
  val analysis = compile.in(Compile).dependsOn(clean.in(Compile)).value
  analysis.infos.allInfos.toList.foreach {
    case (a, b) =>
      if (b.reportedProblems.nonEmpty) {
        b.reportedProblems.foreach { prob =>
          println(s"""Problem: $prob
                     |Category: ${prob.category()}
                     |Message: ${prob.message()}
                     |Severity: ${prob.severity() == Severity.Warn}
                     |Position: ${prob.position()}
                     |""".stripMargin)
        }
      }
  }
}
