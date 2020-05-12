package lectures.part3fp

object WhatsAFunction extends App {

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2))

  val stringToIntConverter = new Function1[String, Int] {
    override def apply(element: String): Int = element.toInt
  }

  println(stringToIntConverter("40") + 2)

  val adder: (Int, Int) => Int = new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }

  println(adder(2, 5))

  val concatenator: (String, String) => String = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }

  println(concatenator("Hello ", "Scala"))

  val superAdder: (Int) => ((Int) => Int) = new ((Int) => ((Int) => Int)) {
    override def apply(x: Int): Int => Int = new ((Int) => Int) {
      override def apply(y: Int): Int = x + y
    }
  }

  val adder3 = superAdder(3)

  println(adder3(4))
  println(superAdder(3)(4)) //curried functions
}

trait MyFunction[A, B] {
  def apply(element: A): B
}