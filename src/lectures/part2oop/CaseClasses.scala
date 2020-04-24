package lectures.part2oop

object CaseClasses extends App {

  case class Person(name: String, age: Int)

  val giorgio = new Person("Giorgio", 30)

  println(giorgio.name)
  println(giorgio) // syntactic sugar

  val giorgio2 = new Person("Giorgio", 30)

  println(giorgio == giorgio2)

  val giorgio3 = giorgio.copy(age = 35)

  println(giorgio3)

  val john = Person("John", 32)

  println(john)

  case object UK {
    def name: String = "UK"
  }

}
