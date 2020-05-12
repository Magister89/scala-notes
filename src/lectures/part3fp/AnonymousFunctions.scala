package lectures.part3fp

object AnonymousFunctions extends App {

  //anonymous class (lambda)
  val doubler = (x: Int) => x * 2
  val doubler2 : Int => Int = x => x * 2

  val adder: (Int, Int) => Int = (a, b) => a + b
  val justDoSomething: () => Int = () => 3

  println(justDoSomething) //function itself
  println(justDoSomething()) //function call

  val stringToInt = { (str: String) => str.toInt }
  val niceIncrementer: Int => Int = _ + 1 //equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ //equivalent to (a, b) => a + b

  val superAdder = (x: Int) => (y: Int) => x + y
  println(superAdder(3)(4))
}
