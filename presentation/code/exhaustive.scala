formatToken match {
  case FormatToken(_, _: Keyword) => Seq(Split(Space, 0))
  // ...
  case FormatToken(_, _: `else`)  => Seq(Newline(, 0)) // Unreachable code!
}
