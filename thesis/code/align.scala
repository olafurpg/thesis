object VerticalAlignment {
  x match {
    // Align by => and -> and //
    case 1  => 1  -> 2  // first
    case 11 => 11 -> 22 // second

    // Blank lines separate alignment blocks.
    case ignoreMe => 111 -> 222
  }

  def name   = column[String]("name")
  def status = column[Int]("status")
  val x  = 1
  val xx = 22

  libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-compiler" % scalaVersion.value,
      "com.lihaoyi"    %% "sourcecode"    % "0.1.1"
  )
}
