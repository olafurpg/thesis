#!/usr/local/bin/python
import pandas as pd
import sys

pd.set_option("precision", 5)
data = []
for line in sys.stdin.readlines():
    n = int(line.split()[0])
    if n > 0:
        data.append(n)
df = pd.DataFrame({"sizes": data})
summary = (df.describe(percentiles=[0.25, 0.50, 0.75, 0.90, 0.95, 0.99])
        .drop([ "count", "min", "std" ], 0)
        .transpose())
summary.columns = ["Mean", "25th", "Median", "75th", "90th", "95th", "99th", "Max"]
summary = summary[["25th", "Median", "Mean", "75th", "90th", "95th", "99th", "Max"]]
print summary.to_csv(index=False, float_format="%d")
