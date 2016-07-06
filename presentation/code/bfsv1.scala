def search(xs: Seq[FormatToken]): Seq[Split] = {
  val Q = mutable.PriorityQueue(State.init(xs.head))
  while (Q.nonEmpty) {
    val currentState = Q.pop
    if (currentState.formatToken == xs.last) {
      return currentState.splits // final state.
    } else {
      val splits =
        Router.getSplits(currentState.formatToken)
      splits.foreach { split =>
        Q += State.nextState(currentState, split)
      }
    }
  }
  ??? // ERROR: No formatting found.
}
