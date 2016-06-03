import scala.meta._
// SBT latest dialect
"""lazy val root = project.dependsOn(core)
lazy val core = project""".parse[Sbt0137] // OK
// SBT legacy dialect
"""lazy val root = project.dependsOn(core)
lazy val core = project""".parse[Sbt0136] // Missing blank line
// Scala compilation unit
"""lazy val root = project""".parse[Source] // No top-level statements
