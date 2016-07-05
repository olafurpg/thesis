def singleLinePolicy(expire: Token) =
  Policy({
    case Decision(formatToken, splits) =>
      Decision(formatToken, splits.filterNot(_.modification.isNewline))
  }, expire: Token)
