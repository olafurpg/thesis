#!/usr/local/bin/python
import csv, sys
rows = list(csv.reader(sys.stdin))

def get_row(row):
  return "  " + " & ".join(row)

def hline():
  print "  \\hline"

cols = len(rows[0])
print "\\begin{tabular}{" + ("l" * cols) + "}"
print get_row(rows[0])
hline()
to_print = [get_row(row) for row in rows[1:]]
print "\\\\\n".join(to_print)
print "\\end{tabular}"
