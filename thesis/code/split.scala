case class Split(
    modification: Modification,
    cost: Int,
    policy: Policy = NoPolicy,
    optimalAt: Option[OptimalToken] = None
    indents: Vector[Indent[Length]] = Vector.empty[Indent[Length]])(
    implicit val line: sourcecode.Line)
