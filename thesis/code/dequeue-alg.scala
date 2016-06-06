// ...
val statementStarts: Set[Token]
while (Q.nonEmpty) {
  val currentState = Q.pop
  if (statementStarts.contains(currentState.formatToken.left)) {
    Q.dequeueAll // empty search queue
  }
  // ...
}
