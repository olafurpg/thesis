/** @returns Splits that produce and optimal formatting layout */
def bestFirstSearch(formatTokens: FormatTokens, router: Router): List[Split] = {
  val lastFormatToken = formatTokens.last
  val Q = PriorityQueue(State(formatTokens.head))
  while (Q.nonEmpty) {
    val currentState = Q.pop
    if (currentState.formatToken == lastFormatToken) {
      return currentState.splits // reached the final state.
    } else {
      val decisions = router.getSplits(currentState.formatToken)
      for (decision <- decisions) {
        Q += State.nextState(currentState, decision)
      }
    }
  }
  // Error: No formatting solution found.
  ???
}
