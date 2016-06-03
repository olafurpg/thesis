sealed abstract class Length
case class Num(n: Int) extends Length
case object StateColumn extends Length

case class Indent[T <: Length](length: T, expire: Token, inclusive: Boolean)
