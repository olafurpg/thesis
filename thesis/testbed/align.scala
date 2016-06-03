sealed abstract class Planet extends Serializable with Product {
  val asString: String
  def fromString(s: String): Planet = {
    (Uranus fromString s) orElse
    (Mars fromString s) orElse
    (Venus fromString s) orElse
    (Neptune fromString s) orElse
    (Earth fromString s) getOrElse
    Pluto(s)
  }
}
