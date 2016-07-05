> import scala.meta._
> dialects.Sbt0137(
    """lazy val root = project.dependsOn(core)
       lazy val core = project""").parse[Source] // OK
> dialects.Sbt0136(
    """lazy val root = project.dependsOn(core)
       lazy val core = project""").parse[Source] // Parse error: missing newline
> dialects.Scala211(
    """lazy val root = project""").parse[Source] // Parse error: no class/...
