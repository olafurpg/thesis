#
#
# Stacked histograms
#
set terminal postscript enhanced color size 5cm,4cm font 'Verdana,9'
set output "target/month.eps"


set xdata time
set timefmt "%Y-%m"
set datafile separator ","
set ylabel "Downloads"
set xrange ["2016-3":"2016-5"]
set pointsize 0.8
set format x "%B"
set border 11
set tics front
set key below
set xtics ("2016-3", "2016-4", "2016-5")



plot \
  "data/month.dat" using 1:($2+$3+$4) title 'Github' with filledcurves x1, \
  "data/month.dat" using 1:($2+$3) title 'Maven' with filledcurves x1, \
  "data/month.dat" using 1:($2) title 'IntelliJ' with filledcurves x1
