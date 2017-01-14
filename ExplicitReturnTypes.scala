object ExplicitReturnTypes {

  def myFunction(input : String) = {
    if(input.contains("@")) {
      Right(input.toLowerCase)
    } else {
      Left(new IllegalArgumentException("Invalid email"))
    }
  }

  /*def myFunction2(input : String) : Either[IllegalArgumentException, String] = {
    if(input.contains("@")) {
      input.toLowerCase
    } else {
      Left(new IllegalArgumentException("Invalid email"))
    }
  }*/

  def main(args : Array[String]) : Unit = {
    println(myFunction("Foo"))
  }

}
