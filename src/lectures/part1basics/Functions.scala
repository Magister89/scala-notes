package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int): String = { a + " " + b }

  println(aFunction("Hello", 3))

  def aParameterLessFunction(): Int = 42

  println(aParameterLessFunction)

  def aRepeatedFunction(aString: String, n: Int) : String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }

  println(aRepeatedFunction("Hello ", 3))

  def aFunctionsWithSideEffects(aString: String) = { println(aString) }

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int) : Int = { a + b }

    aSmallerFunction(n, n - 1)
  }


  //EXERCISES

  def greeting(name: String, age: Int) : String = { s"Hi, my name is ${name} and I am ${age} years old" }

  def factorial(n: Int) : Int = {

    if (n < 1) 1 else n * factorial(n - 1)

  }


  def fibonacci(n: Int) : Int = {

   if (n == 0) 0 else {
     if (n == 1) 1 else fibonacci(n - 1) + fibonacci(n - 2)
   }

  }

  def isPrime(n: Int): Boolean = {

    def remainder(tuple: (Int, Int)): (Int, Int) = {
      if (tuple._1 % (tuple._2 ) == 0) (tuple._1, tuple._2)
      else remainder((tuple._1, tuple._2 - 1))
    }

    if (n <= 1) false else {
      if (remainder((n, (n - 1)/2)) == (n, 1)) true else false
    }

  }


  println(greeting("Giorgio", 29))
  println(factorial(5))
  println(fibonacci(24))
  println(isPrime(71596))






}
