object AbstractingFunctionBodies {

  def myFunction(input : String, count : Int) : List[String] = {
    (for(i <- 0 until count) yield {
      if(i%2 == 0) {
        input.toUpperCase
      } else {
        input.toLowerCase
      }
    }).toList
  }

  def myFunction2(input : String, count : Int) : List[String] = {
    (0 until count).map(i =>
      if(i%2 == 0) {
        input.toUpperCase
      } else {
        input.toLowerCase
      }
    ).toList
  }

  def myFunction3(
                   input : String,
                   count : Int,
                   predicate : Int => Boolean = i => i%2 == 0) : List[String] = {
    (0 until count).map(i =>
      if(predicate(i)) {
        input.toUpperCase
      } else {
        input.toLowerCase
      }
    ).toList
  }

  implicit val predicate : Int => Boolean = i => i%2 == 0

  def myFunction4(input : String,count : Int)
                 (implicit predicate : Int => Boolean) : List[String] = {
    (0 until count).map(i =>
      if(predicate(i)) {
        input.toUpperCase
      } else {
        input.toLowerCase
      }
    ).toList
  }

  def main(args : Array[String]) : Unit = {
    println(myFunction("hello world", 5))
    println(myFunction2("hello world", 5))
    println(myFunction3("hello world", 5))
    println(myFunction3("hello world", 5, i => i%3 == 0))
    println(myFunction4("hello world", 5))
    println(myFunction4("hello world", 5)(i => i%3 == 0))
  }

}
