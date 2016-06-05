def bestFirstSearch(start: State, stop: Token): List[Split] = {
  val Q = mutable.PriorityQueue(start)
  while (Q.nonEmpty) {
    val currentState = Q.pop
    if (currentState.formatToken.left == stop) {
      return currentState
    } else if (currentState.formatToken != start.formatToken &&
               currentState.formatToken.left.isInstanceOf[`{`]) {
      bestFirstSearch(currentState, closingCurly(currentState.formatToken.left))
    }
   // ...
  }
}
