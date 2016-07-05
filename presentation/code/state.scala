case class State(splits: Vector[Split],
                 totalCost: Int,
                 policies: Vector[Policy],
                 indents: Vector[Indent[Num]],
                 column: Int,
                 formatOff: Boolean) extends Ordered[State] {

  def compare(that: State): Int
}

object State {
  def nextState(currentState: State, formatToken: FormatToken, split: Split): State
}
