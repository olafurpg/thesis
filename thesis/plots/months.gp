#
#
# Stacked histograms
#
set terminal epslatex size 8.89cm,6.65cm color colortext

set output "target/month.tex"

set key invert reverse Left outside
set key autotitle columnheader
set style data histogram
set style histogram rowstacked
set style fill solid border -1
set boxwidth 0.75
#
# plot 'data/month.dat' using 2:xtic(1), for [i=2:2] '' using i
#

