object PatternMatchingAllStatements {

  def myFunction(input : Int) : Boolean = input match {
    case 0 => true
    case _ => false
  }

  def myFunction2(input : String) : Boolean = input match {
    case "foo"|"" => true
    case _ => false
  }

  def myFunction3(input : String) : Int = input.isEmpty match {
    case true => 0
    case false => input.length
  }

  def main(args : Array[String]) : Unit = {
    println(myFunction(10))
    println(myFunction2("Foo"))
    println(myFunction2("foo"))
    println(myFunction3(""))
  }

}
