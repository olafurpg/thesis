case class Policy(f: PartialFunction[Decision, Decision], expire: Token)
