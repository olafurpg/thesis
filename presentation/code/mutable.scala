val input = List(1, 2, 3)
val output = mutable.ListBuffer.empty[Int] // mutable list
input.foreach { elem =>
  if (elem + 1 > 2) { // filter
    output += elem + 1 // map
  }
}
output // ListBuffer(3, 4)
