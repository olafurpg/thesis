def bestFirstSearch(start: State, stop: Token, maxCost: Int): List[Split] = {
  // while (...) { ...
  val splits = Router.getSplits(currentState.formatToken)
  var optimalFound = false
  splits.withFilter(_.cost < maxCost).foreach { split =>
    val nextState = State.nextState(currentState, split)
    split.optimalToken match {
      case Some(OptimalToken(expire, killOnFail)) =>
        val nextNextState = bestFirstSearch(nextState, expire, maxCost = 0)
        if (nextNextState.expire == expire) {
          optimalFound = true
          Q += nextNextState
        } else if (!killOnFail) {
          Q += nextState
        }
      case _ if !optimalFound =>
        Q += nextState
    }
  }
  // ...
  // }
}
