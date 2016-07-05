case FormatToken(_, els: `else`, _) =>
  val expire = owners(els).tokens.last
  Seq(
      Split(Space, 0, ignoreIf = newlines > 0)
        .withOptimalToken(expire)
        .withPolicy(SingleLineBlock(expire)),
      Split(Newline, 1)
  )
