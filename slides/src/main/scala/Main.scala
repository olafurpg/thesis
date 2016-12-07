import scala.xml.XML
import scalatags.Text.all._

import java.nio.file.Files
import java.nio.file.Paths

import com.geirsson.reavealjs.RevealJs
import com.geirsson.reavealjs.SlideDeck
import com.geirsson.reavealjs.Themes

object Decks {
  val flatMap_Oslo = SlideDeck(
      "Opinionated, automatic code formatting with scalafmt",
      "",
      "Ólafur Páll Geirsson",
      Themes.moon,
      scalatex.flatMap2016())
  val scala_Italy = SlideDeck(
    "Opinionated, automatic code formatting with scalafmt",
    "",
    "Ólafur Páll Geirsson",
    Themes.white,
    scalatex.scalaItaly())
  val scala_eXchange = SlideDeck(
    "Smooth migrations to Dotty with scalafix",
    "",
    "Ólafur Páll Geirsson",
    Themes.beige,
    scalatex.scalax())
}

object Main extends App {
  val pp = new scala.xml.PrettyPrinter(80, 2)
  val scalatexOutput = RevealJs.render(Decks.scala_eXchange)
  println(scalatexOutput)
  Files.write(Paths.get("target", "scala-2.11", "classes", "index.html"),
              scalatexOutput.getBytes)
}

