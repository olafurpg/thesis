/** @returns Splits that produce and optimal formatting layout */
def bestFirstSearch(formatTokens: List[FormatTokens]): List[Split] = {
  val Q = mutable.PriorityQueue(State.init(formatTokens.head))
  while (Q.nonEmpty) {
    val currentState = Q.pop
    if (currentState.formatToken == formatTokens.last) {
      return currentState.splits // reached the final state.
    } else {
      val decisions = Router.getSplits(currentState.formatToken)
      decisions.foreach { decision =>
        Q += State.nextState(currentState, decision)
      }
    }
  }
  // Error: No formatting solution found.
  ???
}
