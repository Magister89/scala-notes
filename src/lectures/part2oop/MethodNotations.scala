package lectures.part2oop

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String) = movie == favoriteMovie
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(newName: String): Person = new Person(s"${this.name} ($newName)", favoriteMovie, age)
    def unary_! : String = s"$name what the heck!"
    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)
    def learns(what: String): String = s"$name is learning $what"
    def learnScala: String = this learns "Scala"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"
    def apply(number: Int): String = s"$name watched $favoriteMovie $number times"
  }

  val mary = new Person("Mary", "Inception")
  val tom = new Person("Tom", "Fight Club")

  println(tom + mary)
  println(mary learns "Scala")
  println(mary learnScala)
  println((+tom).age)

  println((tom + "the faggio").name)

  println(!mary)

  println(mary.likes("Inception"))
  println(mary likes "Inception") //infix notation - operator

  println(1 + 2)
  println(1.+(2))
  //ALL OPERATORS ARE METHODS


  val x = -1
  val y = 1.unary_- //equivalent to -1

  println(mary.isAlive)
  println(mary isAlive)

  println(mary.apply())
  println(mary(2))
  println(mary()) //equivalent to apply()

}
