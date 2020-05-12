package exercises

import java.util.NoSuchElementException

abstract class MyList[+A] {

  /*
    list of integers

    head => first element of the list
    tail => remainder of the list

    isEmpty => is this list empty
    add(int) => new List with element added
    toString => string representation
   */
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"
  //high-order functions
  def map[B](transformer: A => B): MyList[B]
  def flatMap[B](transformer: A => MyList[B]): MyList[B]
  def filter(predicate: A => Boolean): MyList[A]
  def ++[B >: A](list: MyList[B]): MyList[B]
  def foreach(function: A => Unit): Unit
  def sort(compare: (A, A) => Int): MyList[A]
  def zipWith[B, C](list: MyList[B], zip:(A, B) => C): MyList[C]
  def fold[B](start: B)(operator: (B, A) => B): B
}

case object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: Nothing = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)
  def printElements: String = ""
  def map[B](transformer: Nothing => B): MyList[B] = Empty
  def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty
  def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty
  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
  def foreach(function: Nothing => Unit): Unit = ()
  def sort(compare: (Nothing, Nothing) => Int) = Empty
  def zipWith[B, C](list: MyList[B], zip:(Nothing, B) => C): MyList[C] =
    if (!list.isEmpty) throw new RuntimeException("Lists do not have the same length")
    else Empty
  def fold[B](start: B)(operator: (B, Nothing) => B): B = start
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B] = new Cons(element, this)
  def printElements: String =
    if (t.isEmpty) "" + h
    else h + ", " + t.printElements

  def filter(predicate: A => Boolean): MyList[A] = {
    if(predicate(h)) new Cons[A](h, t.filter(predicate))
    else t.filter(predicate)
  }

  def map[B](transformer: A => B): MyList[B] = {
    new Cons(transformer(h), t.map(transformer))
  }

  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)

  def flatMap[B](transformer: A => MyList[B]): MyList[B] =
    transformer(h) ++ t.flatMap(transformer)

  def foreach(f: A => Unit): Unit = {
    f(h)
    t.foreach(f)
  }

  def sort(compare: (A, A) => Int): MyList[A] = {

    def insert(x: A, sortedList: MyList[A]): MyList[A] = {
      if (sortedList.isEmpty) new Cons(x, Empty)
      else if (compare(x, sortedList.head) <= 0) new Cons(x, sortedList)
      else new Cons(sortedList.head, insert(x, sortedList.tail))
    }

    val sortedTail = t.sort(compare)
    insert(h, sortedTail)
  }

  def zipWith[B, C](list: MyList[B], zip:(A, B) => C): MyList[C] = {
    if (list.isEmpty) throw new RuntimeException("Lists do not have the same length")
    else new Cons(zip(h, list.head), t.zipWith(list.tail, zip))
  }

  def fold[B](start: B)(operator: (B, A) => B): B = {
    t.fold(operator(start, h))(operator)
  }
}

object ListTest extends App {
  val listOfIntegers = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val anotherListOfIntegers = new Cons(4, new Cons(5, Empty))
  val listOfIntegersNotSorted = new Cons(3, new Cons(2, new Cons(5, Empty)))
  println(listOfIntegers.tail.head)
  println(listOfIntegers.add(4).head)
  println(listOfIntegers.toString)

  val listOfStrings = new Cons("Hello", new Cons("Scala", Empty))
  println(listOfStrings.toString)

  println(listOfIntegers.map(_ * 2))

  println(listOfIntegers.filter(_ % 2 == 0))

  println(listOfIntegers ++ anotherListOfIntegers)

  println(listOfIntegers.flatMap(elem => new Cons(elem, new Cons(elem + 1, Empty))))

  val cloneLisOfIntegers = listOfIntegers.copy()

  println(cloneLisOfIntegers == listOfIntegers)

  println(listOfIntegers.foreach(elem => println(elem)))
  println(listOfIntegersNotSorted.sort((elem1, elem2) => elem1 - elem2))
  println(anotherListOfIntegers.zipWith[String, String](listOfStrings, _ + "-" + _))
  println(listOfIntegers.fold(5)((elem1, elem2) => elem1 * elem2))

}