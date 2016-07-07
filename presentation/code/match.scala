case FormatToken(_: Keyword, _) => Seq(Split(Space, 0))
case FormatToken(_, _: `=`)     => Seq(Split(Space, 0))
case FormatToken(_: `=`, _)     => Seq(Split(Space, 0)
                                       Split(Newline, 1))
// ...
