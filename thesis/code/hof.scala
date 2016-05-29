def twice(f: Int => Int) = (x: Int) => f(f(x))
twice(_ + 2)(6)  // 10
