import scala.meta._
forAll { (code: String) =>
  val beforeAST = code.parse[Source].show[Structure]
  val afterAST = Scalafmt.format(code).parse[Source].show[Structure]
  beforeAST == afterAST
}
