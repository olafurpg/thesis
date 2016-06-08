library(plyr)
library(ggplot2)
library(doBy)
source("plots/compare.R")
t <- read.csv("data/macro.csv")

t
ddply(dt,~formatter,summarise,mean=mean(Q2),sd=sd(Q2))

# tgc <- summarySE(t, measurevar="ns", groupvars=c("Formatter", "loc"))
# tgc


# The errorbars overlapped, so use position_dodge to move them horizontally
pd <- position_dodge(0.1) # move them .05 to the left and right

# ggplot(tgc, aes(x=loc, y=ns, colour=Formatter, group=Formatter)) + 
#     geom_errorbar(aes(ymin=ns-se, ymax=ns+se), colour="black", width=.1, position=pd) +
#     geom_line(position=pd) +
#     geom_point(position=pd, size=3, shape=21, fill="white") + # 21 is filled circle
#     xlab("LoC") +
#     ylab("Ms") +
#     scale_colour_hue(name="Supplement type",    # Legend label, use darker colors
#                      breaks=c("OJ", "VC"),
#                      labels=c("Orange juice", "Ascorbic acid"),
#                      l=40) +                    # Use darker colors, lightness=40
#     ggtitle("Formatting time depending on file size") +
#     expand_limits(y=0) +                        # Expand y range
#     scale_y_continuous(breaks=0:20*4) +         # Set tick every 4
#     theme_bw() +
#     theme(legend.justification=c(1,0),
#           legend.position=c(1,0))               # Position legend in bottom right
# print("complete")
# ggsave("target/out.png")
