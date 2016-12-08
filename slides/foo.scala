object a {
  case class User()
  val user = User()
  val msg = s"$user logged out"
  List(1,2,3).tail
  def liftedType = Unit
  def doComputation() = Unit

  def main(args: Seq[String]): Unit = {
  }

  @volatile lazy val x = doComputation()

  1

  implicit val tt: TypedTree[Int] = liftedType
}
