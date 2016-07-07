forAll { code =>
  ast(code) structuralEquals ast(format(code))
}
