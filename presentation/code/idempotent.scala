forAll { code =>
  format(code) == format(format(code))
}
