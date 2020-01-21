package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int) : Int = {

    if (n < 1) 1 else {

      println(s"Computing factorial of ${n} - I first need factorial of ${n-1}")
      val result = n * factorial(n - 1)
      println(s"Computed factorial of ${n}")

      result
    }
  }

  //println(factorial(10000))


  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator else factHelper(x - 1, x * accumulator) //TAIL RECURSION

    factHelper(n, 1)

  }

  //println(anotherFactorial(10000))

  //EXERCISES

  @tailrec
  def stringRepeater(aString: String, n: Int, stringAccumulator: String) : String =
    if (n == 1) stringAccumulator + aString
    else stringRepeater(aString, n - 1, stringAccumulator + aString)


  println(stringRepeater("hello ", 1, ""))


  def fibonacci(n: Int) : Int = {
    @tailrec
    def fiboTailRec(i: Int, last: Int, nextToLast: Int): Int = {
      if (i >= n) last
      else fiboTailRec(i + 1, last + nextToLast, last)
    }
    if (n == 0) 0 else {
      if (n <= 2) 1
      else fiboTailRec(2, 1, 1)
    }
  }

  println(fibonacci(10))


  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailRec(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailRec(t - 1, n % t != 0 && isStillPrime)
    }
    if (n <= 1) false else
    isPrimeTailRec(n / 2, true)
  }

  println(isPrime(2003))
  println(isPrime(2))

}
