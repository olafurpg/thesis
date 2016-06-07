case class FormatLocation(formatToken: FormatToken, split: Split, state: State)
/** Returns true if location is eligible for vertical alignment */
def isCandidate(location: FormatLocation): Boolean
/** Returns true if all vertical alignment candidates in a and b match */
def allColumnsMatch(a: Array[FormatLocation], b: Array[FormatLocation]): Boolean
/** Returns map where the keys are (0 to block.length) and values are the
    corresponding column index where all candidates should align */
def getMaxColumns(block: Vector[Array[FormatLocation]]): Map[Int, Int]

def getAlignTokens(
    locations: Array[FormatLocation],
    alignConfiguration: Map[String, Regex]): Map[Split, Int] = {
  val finalResult = Map.newBuilder[Split, Int]
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
          for ((tokenToAlign, columnIndex) <- line.zipWithIndex) {
            finalResult += (tokenToAlign.split,
                            maxColumns(columnIndex) - tokenToAlign.state.column)
          }
        }
      }
    }
  }
}
