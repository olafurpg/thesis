forAll { code =>
  ast(code) == ast(format(code))
}
