object DefsInVars {

  var f : String => String = toLowerCase

  def myFunction(input : String) : String = {
    if(input.length % 2 == 0) {
      f = toUpperCase
    }
    f(input)
  }

  def myFunction2(input : String) : String = {
    var converter : String => String = input => input.toLowerCase
    if(input.length % 2 == 0) {
      converter = input => input.toUpperCase
    }
    converter(input)
  }

  def toLowerCase(input : String) : String = {
    input.toLowerCase
  }

  def toUpperCase(input : String) : String = {
    input.toUpperCase
  }

  def main(args : Array[String]) : Unit = {
    println(myFunction("My String"))
    println(myFunction2("My String!"))
  }

}
