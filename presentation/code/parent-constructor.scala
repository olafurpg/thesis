case FormatToken(_, els: `else`, _) =>
  val expire = rhsOptimalToken(
      leftTok2tok(rightOwner.tokens.last))
  Seq(
      Split(Space, 0, ignoreIf = newlines > 0)
        .withOptimalToken(expire)
        .withPolicy(SingleLineBlock(expire)),
      Split(Newline, 1)
  )
