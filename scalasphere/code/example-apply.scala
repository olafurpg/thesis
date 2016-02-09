40 columns                              |
MyObject(config.getBoolean("shortKey"),
         config.getString("reallyReallyReallyLongKey"),
         liveAnalysis.check(options.has("live"),
                            options.has("analysis")))
>>>
MyObject(
    config.getBoolean("shortKey"),
    config.getString(
        "reallyReallyReallyLongKey"),
    liveAnalysis
      .check(options.has("live"),
             options.has("analysis")))
