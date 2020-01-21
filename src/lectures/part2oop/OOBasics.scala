package lectures.part2oop

object OOBasics extends App {

  val person = new Person("John", 26)
  println(person.age)
  person.greet("Daniel")
  person.greet()

  val writer = new Writer("Giorgio", "Cembran", 1989)
  val newWriter = new Writer("Giorgio", "Cembran", 1989)
  println(writer.fullName)

  val novel = new Novel("La mia vita", 2019, writer)
  println(novel.authorAge)
  println(novel.isWrittenBy(writer))
  println(novel.isWrittenBy(newWriter))
  println(novel.copy(2021).authorAge)
  val counter = new Counter
  counter.increment(10).print
  counter.increment.increment.decrement.print
  counter.print
}

// constructor
class Person(name: String, val age: Int = 0) {

  //Class parameters are not FIELDS

  // method
  def greet(name: String) : Unit = println(s"${this.name} says: Hi, $name")

  //overloading ({this.} implied)
  def greet() : Unit = println(s"Hi, I am $name")

  //multiple constructor - auxiliary
  def this(name: String) = this(name, 0)
  def this() = this("Jon Doe")

}

// class parameters are NOT FIELDS

class Writer(name: String, surname: String, val year: Int) {

  def fullName = name + " " + surname

}

class Novel(name: String, yearOfRelease: Int, author: Writer) {

  def authorAge = yearOfRelease - author.year

  def isWrittenBy(author: Writer) = author == this.author

  def copy(newYearOfRelease: Int) = new Novel(name, newYearOfRelease, author)

}

class Counter(val value: Int = 0) {

  def increment = {
    println("increment")
    new Counter(value + 1)
  }

  def decrement = {
    println("decrement")
    new Counter(value - 1)
  }

  def increment(n: Int): Counter = {
    if (n <= 0) this
    else increment.increment(n - 1)
  }

  def decrement(n: Int) : Counter = {
    if (n <= 0) this
    else decrement.decrement(n - 1)
  }

  def print = println(value)

}



