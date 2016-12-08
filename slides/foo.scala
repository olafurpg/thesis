object a {
  case class User()
  val user = User()
  val msg = s"$user logged out"
  List(1,2,3).tail
  def liftedType = Unit
  def doComputation() = Unit

  def main(args: Seq[String]) {
  }

  println(1)
  lazy val x = doComputation()
  println(1)

  implicit val tt = liftedType
}
