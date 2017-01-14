object NoReturnKeyword {

  def myFunction(input : String) : String = {
    val output = input.split("@")
    return output(0).toLowerCase
  }

  def myFunction2(input : String) : String = {
    input.split("@")(0).toLowerCase
  }

  def myFunction3(input : Option[String]) : Option[String] = {
    if(input.isEmpty) { return None }
    Some(input.get.split("@")(0).toLowerCase)
  }

  def myFunction4(input : Option[String]) : Option[String] = {
    input.map(_.split("@")(0).toLowerCase)
  }

  def myFunction5(input : Option[String]) : Option[String] = if(input.isEmpty) {
    None
  } else {
    Some(input.get.split("@")(0).toLowerCase)
  }

  def main(args : Array[String]) : Unit = {
    println(myFunction("foo@bar.com"))
    println(myFunction2("foo@bar.com"))
    println(myFunction3(Some("foo@bar.com")))
    println(myFunction4(Some("foo@bar.com")))
    println(myFunction5(Some("foo@bar.com")))
  }

}
