object FilteringMappingOverOptions {

  def myFunction(input : Option[String]) : Boolean = {
    input.exists(in => in.trim.isEmpty)
  }

  def myFunction2(input : Option[String]) : Option[Int] = input match {
    case Some(in) if !in.trim.isEmpty => Some(in.length)
    case _ => None
  }

  def myFunction3(input : Option[String]) : Option[Int] = {
    input.filter(_.nonEmpty).map(_.length)
  }

  def myFunction4(input : Option[String]) : Option[String] = input match {
    case Some(in) => Some(in.toLowerCase)
    case _ => None
  }

  def myFunction5(input : Option[String]) : Option[String] = {
    input.map(_.toLowerCase)
  }

  def main(args : Array[String]) : Unit = {
    println(myFunction(Some("")))
    println(myFunction(Some("Foo")))
    println(myFunction(None))

    println(myFunction2(Some("")))
    println(myFunction2(Some("Foo")))
    println(myFunction2(None))

    println(myFunction3(Some("")))
    println(myFunction3(Some("Foo")))
    println(myFunction3(None))

    println(myFunction4(Some("Hello World")))
    println(myFunction5(Some("Hello World")))
  }

}
