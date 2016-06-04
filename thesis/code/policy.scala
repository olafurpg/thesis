case class Decision(formatToken: FormatToken, splits: Seq[Split])
case class Policy(f: PartialFunction[Decision, Decision], expire: Token)
