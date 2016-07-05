var fastestState: State
val visits: mutable.Map[FormatToken, Int].withDefaultValue(0)
while (Q.nonEmpty) {
  val currentState = Q.pop
  visits.update(currentState.formatToken, 1 + visits(currentState.formatToken))
  if (currentState.length > fastestState.length && currentState.isSafe) {
    fastestState = currentState
  }
  if (visits(currentState.formatToken) == MAX_VISITS_PER_TOKEN) {
    Q.dequeueAll
    Q += fastestState
    Q += currentState
    visits.clear()
  } else {
    // continue with algorithm
  }
}
