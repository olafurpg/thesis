case class FormatToken(left: Token,
                       right: Token,
                       between: Vector[Whitespace])

def router(formatToken: FormatToken): Seq[Split]
