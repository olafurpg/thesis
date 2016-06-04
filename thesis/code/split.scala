case class Split(modification: Modification,
                 cost: Int,
                 policy: Policy,
                 optimalAt: Option[OptimalToken],
                 indents: Vector[Indent[Length]])(
    implicit val line: sourcecode.Line)
