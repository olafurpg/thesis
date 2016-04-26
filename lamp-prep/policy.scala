case class Policy(f: PartialFunction[Decision, Decision], expire: Token)(
    implicit val line: sourcecode.Line) {
  def andThen(other: Policy): Policy
}
object Policy {
  val NoPolicy: Policy
}
