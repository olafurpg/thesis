import scala.meta._
dialects.Sbt0137(
  """lazy val root = project.dependsOn(core)
     lazy val core = project""").parse[Source] // OK
dialects.Sbt0136(
  """lazy val root = project.dependsOn(core)
     lazy val core = project""").parse[Source] // Missing blank line
// Default dialect, regular Scala compilation unit
"""lazy val root = project""".parse[Source] // No top-level statements
