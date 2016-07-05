def twice(f: Function[Int, Int]) =
  new Function[Int, Int]() { def apply(x: Int) = f.apply(f.apply(x)) }
twice(new Function[Int, Int]() { def apply(x: Int) = x + 2 }).apply(6)  // 10
