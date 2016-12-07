package com.geirsson.scalatags

import scalatags.Text.all._
import scalatags.text.Builder

object Tags extends Tags
trait Tags {
  val section = "section".tag[String]
  val contentEdit = "contenteditable".emptyAttr
  val dataTrim = "data-trim".emptyAttr
}
