package lectures.part1basics

object CBNvsCBV extends App {

  def callByValue(x: Long): Unit = {
    println(s"by value: ${x}")
    println(s"by value: ${x}")
  }

  def callByName(x: => Long): Unit = {
    println(s"by name: ${x}")
    println(s"by name: ${x}")
  }

  callByValue(System.nanoTime())
  callByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  //printFirst(infinite(), 34)
  printFirst(34, infinite())

}

