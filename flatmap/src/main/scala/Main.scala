import scala.xml.XML
import scalatags.Text.all._
import scalatex.Hello

import java.nio.file.Files
import java.nio.file.Paths

import com.geirsson.reavealjs.RevealJs

object Main extends App {
  val pp = new scala.xml.PrettyPrinter(80, 2)
  val scalatexOutput = RevealJs.render(Hello())
  println(scalatexOutput)
  Files.write(Paths.get("target", "index.html"), scalatexOutput.getBytes)
}
