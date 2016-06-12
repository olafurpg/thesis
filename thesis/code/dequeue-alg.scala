// ...
val statementStarts: Set[Token]
while (Q.nonEmpty) {
  val currentState = Q.pop
  if (statementStarts.contains(currentState.formatToken.left)) {
    Q.dequeueAll // currentState is optimal at this point, empty search queue
  }
  // ...
}
