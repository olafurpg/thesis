// ...
val fastStates: mutable.Map[FormatToken, State]
while (Q.nonEmpty) {
  val currentState = Q.pop
  if (fastStates.get(currentState.formatToken)
                .exists(_.cost <= currentState.state) {
    // do nothing, eliminate currentState because it's slow.
  } else {
    if (!fastStates.contains(currentState.formatToken)) {
      // currentState is the fastest state to reach this token.
      fastStates.update(currentState.formatToken, currentState)
    }
    // continue with algorithm
  }
}
