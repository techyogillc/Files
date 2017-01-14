object FunctionsAreTestable {

  def myFunction(input : String) : String = {
    if(input.length%2 == 0) {
      input.toUpperCase
    } else {
      input.toLowerCase
    }
  }

  def myFunction2(input : String) : Option[String] = {
    if(input == null || input.trim.isEmpty) {
      None
    } else if(input.length%2 == 0) {
      Some(input.toUpperCase)
    } else {
      Some(input.toLowerCase)
    }
  }

  def myFunction3(input : String) : Option[String] = {
    if(input == null) {
      None
    } else {
      val trimmedInput = input.trim
      if(trimmedInput.isEmpty) {
        None
      } else if(trimmedInput.length % 2 == 0) {
        Some(trimmedInput.toUpperCase)
      } else {
        Some(trimmedInput.toLowerCase)
      }
    }
  }

  def main(args : Array[String]) : Unit = {
    println(myFunction("Hello World"))
    println(myFunction2("Hello World"))
    println(myFunction2(null))
    println(myFunction2(""))
    println(myFunction2("           "))
    println(myFunction2("    Hello World    "))

    println(myFunction3("Hello World"))
    println(myFunction3(null))
    println(myFunction3(""))
    println(myFunction3("           "))
    println(myFunction3("    Hello World    "))

  }

}