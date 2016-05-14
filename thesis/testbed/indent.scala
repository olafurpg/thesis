object UserRepo {
  def update(): Unit = {
    User(1, "Marco", Friends(
      1, 2, 3), "secret-password",
      3)
  }
}
