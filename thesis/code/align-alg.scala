case class FormatLocation(formatToken: FormatToken, split: Split, state: State)
/** Returns true if this location is eligible for vertical alignment */
def isCandidate(location: FormatLocation): Boolean
/** Returns true if all alignment candidates match */
def allColumnsMatch(a: Array[FormatLocation], b: Array[FormatLocation]): Boolean
/** Returns the index at which each column should align */
def getMaxColumns(block: Vector[Array[formatLocation]]): Map[Int, Int]

def getAlignTokens(
    locations: Array[FormatLocation],
    alignConfiguration: Map[String, Regex]): Map[FormatToken, Int] = {
  val finalResult = Map.newBuilder[FormatToken, Int]
  val lines: Array[Array[FormatLocation]] = getLines(locations)
  var block = Vector.empty[Array[FormatLocation]]
  for (formatLocations <- lines) {
    val candidates: Array[FormatLocation] = formatLocations.filter(isCandidate)
    if (block.isEmpty) { // Starting a new block.
      if (candidates.nonEmpty) block = block :+ candidates
    } else {
      if (columnsMatch(block.last, candidates)) {
        block = block :+ candidates
      } else { // release alignment
        val maxColumns = getMaxColumns(block)
        for (line <- block) {
          for ((tokenToAlign: FormatToken, columnIndex: Int) <- line.zipWithIndex) {
            finalResult += (tokenToAlign,
                            maxColumns(columnIndex) - tokenToAlign.state.column)
          }
        }
      }
    }
  }
}
