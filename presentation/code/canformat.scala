forAll { code =>
  whenever(scalaCompilerCanParse(code)) {
    format(code).isInstanceOf[Success]
  }
}
