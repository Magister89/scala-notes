package lectures.part1basics

import scala.sys.ShutdownHookThread

object ValuesVariablesTypes extends App {

  //val x: Int = 42

  val x = 42

  println(x)

  //VALS ARE IMMUTABLE
  //COMPILER CAN INFER TYPES

  val aString: String = "Hello, Scala!"
  val aBoolean: Boolean = true
  val aChar: Char = 'a'
  val anInt: Int = x
  val aShort: Short = 324
  val aLong: Long = 2342424242424242L
  val aDouble: Double = 3.14

  //VARIABLES

  var aVariable: Int = 5
  aVariable = 6
}
