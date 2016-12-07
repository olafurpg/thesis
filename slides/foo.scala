trait Context
object a {
  case class User()
  val user = User()
  val msg = s"$user logged out"
  List(1,2,3).tail
  def liftedType = 2
  def doComputation() = Unit

  def foo(a: Int, b: Int) = ???

  type Ctx[T] = Int
  type TypedTree[T] = Int
  def main(args: Seq[String]): Unit = {
  }

  println(1)
  @volatile lazy val x = doComputation()
  println(1)

  implicit val tt: TypedTree[Int] = liftedType
  val pairs = List.empty[(Int, Int)]


  def typecheck[T]: Ctx[T] = ???

  pairs.map {
    case (a, b) => a + b
  }
}
