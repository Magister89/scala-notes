package lectures.part2oop

object Objects extends App {

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY "STATIC"

  object Person { // type + is only instance
    // "static"/"class" - level functionality
    val N_EYES = 2
    def canFly: Boolean = false
    //factory method
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }

  class Person(val name: String) {
    // instance-level functionality
  }

  //COMPANIONS

  println(Person.N_EYES)
  println(Person.canFly)

  // SCALA OBJECT = SINGLETON INSTANCE

  val mary = new Person("Mary")
  val john = new Person("John")
  println(mary == john)

  val person1 = Person
  val person2 = Person
  println(person1 == person2)

  val bobbie = Person.apply(mary, john)
  println(bobbie.name)

  //Scala Applications = Scala object with
  // def main(args: Array[String]): Unit

}
