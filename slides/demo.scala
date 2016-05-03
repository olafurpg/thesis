// Columns 80                                                                  |
object Demo {

  DBObject(User(Name("Martin", "Odersky"), Language("Scala")), Address("Lausanne", "Switzerland"))

  StandardOutLogger.print(Error(new LoggerException, logName, this.getClass, "unknown akka.loglevel " + system.settings.LogLevel))

  checkAll("CofreeZipLazyOption", applicative.laws[CofreeZipLazyOption](implicitly, implicitly, implicitly, CofreeZipLazyOptionEqual))
}
