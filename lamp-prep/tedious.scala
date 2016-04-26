// Columns 80                                                                  |
case class Split(modification: Modification,
                 cost: Int,
                 ignoreIf: Boolean = false,
                 indents: Vector[Indent[Length]] = Vector.empty[Indent[Length]],
                 policy: Policy = NoPolicy,
                 penalty: Boolean = false,
                 optimalAt: Option[OptimalToken] = None)(implicit val line: sourcecode.Line)
