# library(stargazer, lib.loc="plots")
library(xtable, lib.loc="plots")
# library(Hmisc, lib.loc="plots")

options(xtable.floating = FALSE)
options(xtable.timestamp = "")
sizes <- read.table("data/file_sizes.dat")
# summary(sizes)
sizes <- quantile(sizes$V1, c(.50, .75, .90, .99))
# append(sizes, 1)
# sizes

# summary(sizes)
# colnames(sizes) = c("Mean", "3rd Q", "90th", "99th")
sizes
# summary(sizes)
# xtable(summary(sizes))
