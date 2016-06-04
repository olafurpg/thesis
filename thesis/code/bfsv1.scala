/** @returns Splits that produce and optimal formatting layout */
def bestFirstSearch(formatTokens: FormatTokens, router: Router): List[Split] = {
  val lastFormatToken = formatTokens.last
  val Q = mutable.PriorityQueue(State.init(formatTokens.head))
  while (Q.nonEmpty) {
    val currentState = Q.pop
    if (currentState.formatToken == lastFormatToken) {
      return currentState.splits // reached the final state.
    } else {
      val decisions = router.getSplits(currentState.formatToken)
      decisions.foreach { decision =>
        Q += State.nextState(currentState, decision)
      }
    }
  }
  // Error: No formatting solution found.
  ???
}
