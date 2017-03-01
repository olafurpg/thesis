package com.geirsson.reavealjs

import scala.util.Try
import scalatags.Escaping
import scalatags.Text
import scalatags.Text.all._

import java.nio.file.Files
import java.nio.file.Paths

case class SlideDeck(
  title: String,
  description: String,
  author: String,
  theme: String,
  slides: Text.all.Frag
)

object Themes {
  val night = "night"
  val blood = "blood"
  val serif = "serif"
  val simple = "simple"
  val beige = "beige"
  val sky = "sky"
  val league = "league"
  val white = "white"
  val solarized = "solarized"
  val black = "black"
  val moon = "moon"
}

object RevealJs extends com.geirsson.scalatags.Tags {
  def twitter = a(href:="https://twitter.com/olafurpg", "@olafurpg")
  def fragment = `class` := "fragment"

  `font` := "white"

  def inlineJs(file: String) = {
    val contents = new String(Files.readAllBytes(
      Paths.get("src", "main", "resources", "js", file).toAbsolutePath
    ))
    script(raw(contents))
  }

  def header(deck: SlideDeck) =
    raw(s"""
           |	<head>
           |		<meta charset="utf-8">
           |
           |		<title>${deck.title}</title>
           |
           |		<meta name="description" content="${deck.description}">
           |		<meta name="author" content="${deck.author}">
           |
           |		<meta name="apple-mobile-web-app-capable" content="yes">
           |		<meta name="apple-mobile-web-app-status-bar-style" content="black-translucent">
           |
           |		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
           |
           |		<link rel="stylesheet" href="css/reveal.css">
           |		<link rel="stylesheet" href="css/theme/${deck.theme}.css" id="theme">
           |		<link rel="stylesheet" href="css/custom.css">
           |
           |		<!-- Theme used for syntax highlighting of code -->
           |		<link rel="stylesheet" href="lib/css/darkula.css">
           |
           |		<!-- Printing and PDF exports -->
           |		<script>
           |			var link = document.createElement( 'link' );
           |			link.rel = 'stylesheet';
           |			link.type = 'text/css';
           |			link.href = window.location.search.match( /print-pdf/gi ) ? 'css/print/pdf.css' : 'css/print/paper.css';
           |			document.getElementsByTagName( 'head' )[0].appendChild( link );
           |		</script>
           |
           |		<!--[if lt IE 9]>
           |		<script src="lib/js/html5shiv.js"></script>
           |		<![endif]-->
           |	</head>
    """.stripMargin)
  def footer =
    raw("""
          |		<script src="lib/js/head.min.js"></script>
          |		<script src="js/reveal.js"></script>
          |  <style>
          |    body:after {
          |      content: url(img/scalacenter-small.png);
          |      position: fixed;
          |      top: 3.5em;
          |      right: 3.5em;
          |      box-shadow: none;
          |    }
          |  </style>
          |
          |		<script>
          |			// More info https://github.com/hakimel/reveal.js#configuration
          |			Reveal.initialize({
          |				slideNumber: true,
          |				controls: false,
          |				progress: true,
          |				history: true,
          |				center: true,
          |				transition: 'none', // none/fade/slide/convex/concave/zoom
          |				// More info https://github.com/hakimel/reveal.js#dependencies
          |				dependencies: [
          |					{ src: 'lib/js/classList.js', condition: function() { return !document.body.classList; } },
          |					{ src: 'plugin/markdown/marked.js', condition: function() { return !!document.querySelector( '[data-markdown]' ); } },
          |					{ src: 'plugin/markdown/markdown.js', condition: function() { return !!document.querySelector( '[data-markdown]' ); } },
          |					{ src: 'plugin/highlight/highlight.js', async: true, callback: function() { hljs.initHighlightingOnLoad(); } },
          |					{ src: 'plugin/zoom-js/zoom.js', async: true },
          |					{ src: 'plugin/notes/notes.js', async: true }
          |				]
          |			});
          |		</script>
          |
    """.stripMargin)
  import com.geirsson.scalatags.Tags._
  def skipSlide(tags: Text.Modifier*) = span("")

  def wrap(tags: Text.Modifier*) = section(tags: _*)

  def slide(tags: Text.Modifier*) = section(tags: _*)
  def embedVideo(file: String) = {
    require(file.endsWith(".mp4"))
    video(
      width := "70%",
      "controls".emptyAttr,
      "loop".emptyAttr,
      source(src := file, `type` := "video/mp4"),
      "Your browser does not support the video tag."
    )
  }

  def markdownSlide(tags: Text.Modifier*) =
    section(
      data("markdown") := "",
      script(Seq(`type` := "text/template") ++ tags: _*)
    )

  def tabulate(
    header: Seq[String],
    rows: Seq[Seq[String]],
    align: Map[Int, String]
  ) = {
    table(
      thead(
        tr(
          header.zipWithIndex.map { case (h, _) => th(h) }
        )
      ),
      tbody(
        rows.map { row =>
          tr(
            row.zipWithIndex.map {
              case (d, i) =>
                td(textAlign := align.getOrElse(i, "left"), d)
            }
          )
        }
      )
    )
  }

  def render(deck: SlideDeck): String =
    html(
      header(deck),
      body(
        div(
          `class` := s"reveal ${deck.theme}",
          div(
            `class` := "slides",
            deck.slides
          )
        ),
        footer
      )
    ).render

  private def fixBrokenIndent(frag: String): String = {
    // Fix broken indentation by scalatex
    val toStrip =
      " " * Try(frag.trim.lines
        .drop(1)
        .withFilter(_.nonEmpty)
        .map(_.takeWhile(_ == ' ').length)
        .min).getOrElse(0)
    frag.lines.map(_.stripPrefix(toStrip)).mkString("\n")
  }



  def highlight(codeToHighlight: String) = hl.scala(codeToHighlight)

  class hl(lang: String) {
    def apply(codeToHighlight: String) = {
      pre(
        style := "font-size: 0.56em", // fits 80 characters on column in my machine
        code(
          `class` := s"hljs $lang",
          contentEdit,
          dataTrim,
          fixBrokenIndent(codeToHighlight)
        )
      )
    }
  }

  def lnk(title: String, url: String) = a(target:="_blank",href:=url, title)
  def comment(str: String) = span("")

  object hl {
    val scala = new hl("scala")
    val diff = new hl("diff")
  }
}
