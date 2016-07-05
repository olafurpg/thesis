// Column 80                                                                   |
object a {
  Ok(
      Json.obj("api" -> Json.obj("current" -> api.currentVersion,
                                 "olds" -> api.oldVersions.map { old =>
                           Json.obj("version" -> old.version,
                                    "deprecatedAt" -> old.deprecatedAt,
                                    "unsupportedAt" -> old.unsupportedAt)
                         }))) as JSON
}
