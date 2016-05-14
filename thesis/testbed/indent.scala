object UserRepo {
  def update(): Unit = {
    DB.insert(User(1, "Marco", Friends(
      1, 2, 3
    ), "secret-password",
      3))
  }
}
