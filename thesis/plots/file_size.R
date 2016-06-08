library(xtable, lib.loc="plots")
options(xtable.floating = FALSE)
options(xtable.timestamp = "")
sizes <- read.table("data/file_sizes.dat")
summary(sizes)
xtable(quantile(sizes$V1, c(.50, .75, .90, .99)))

