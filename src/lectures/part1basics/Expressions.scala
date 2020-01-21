package lectures.part1basics

object Expressions extends App {

  val x = 1 + 2
  println(x)

  println(12 + 5 * 4)

  println(1 == x)

  println(!(1 == x))

  var aVariable = 3

  aVariable += 1

  println(aVariable)

  val aCondition = true
  val aConditionValue = if(aCondition) 5 else 3

  println(aConditionValue)

  //NEVER WRITE THIS!

  var i = 0
  while(i < 10) {
    println(i)
    i += 1
  }

  //EVERYTHING in Scala is an expression!

  val aWeirdValue = (aVariable = 3) // Unit === void

  println(aWeirdValue)

  //side effects: println(), reassigning a variable, whiles loop -> expressions returning Unit

  val codeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "Hello" else "Goodbye"
  }

  val someValue = {
    2 < 3
  }

  println(someValue)

  val anotherValue = {
    if (someValue) 239 else 986
    42
  }

  println(anotherValue)

}
