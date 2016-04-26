object AST {
  private def extractRhino(e: js.Dynamic): js.Array[String] = {
    (e.stack.asInstanceOf[js.UndefOr[String]]).getOrElse("")
      .jsReplace("""^\s+at\s+""".re("gm"), "") // remove 'at' and indentation
      .jsReplace("""^(.+?)(?: \((.+)\))?$""".re("gm"), "$2@$1")
      .jsReplace("""\r\n?""".re("gm"), "\n") // Rhino has platform-dependent EOL's
      .jsSplit("\n")
  }
}
