case class Policy(f: PartialFunction[Decision, Decision],
                  isProhibitive: Boolean,
                  expire: Token)
