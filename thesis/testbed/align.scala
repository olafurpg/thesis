 object host extends StringColumn(this) with PartitionKey[String]
  object date_time extends DateTimeColumn(this) with PartitionKey[DateTime]
  object client_id extends OptionalStringColumn(this) with PartitionKey[Option[String]]
  //
