object ValueMatchesOverGuards {

  case class Foo(field1 : Int, field2 : String)

  def myFunction(input : Foo) : Boolean = input match {
    case Foo(f1, f2) if f1 == 0 && f2 == "" => true
    case _ => false
  }

  def myFunction2(input : Foo) : Boolean = input match {
    case Foo(0, "") => true
    case _ => false
  }

  def myFunction3(input : Foo) : Boolean = input match {
    case Foo(0, f2) if f2.trim.isEmpty => true
    case _ => false
  }

  def myFunction4(input : Foo) : Boolean = input match {
    case Foo(0|2, "") => true
    case _ => false
  }

  val acceptableWords = List("", "undefined", "null", "blank")

  def myFunction5(input : Foo) : Boolean = input match {
    case Foo(0, f2) if acceptableWords.contains(f2) => true
    case _ => false
  }

  def main(args : Array[String]) : Unit = {
    println(myFunction(Foo(0, "")))
    println(myFunction2(Foo(0, "")))
    println(myFunction3(Foo(0, "")))
    println(myFunction3(Foo(0, "                 ")))
    println(myFunction4(Foo(2, "")))
  }

}
