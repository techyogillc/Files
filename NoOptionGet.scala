object NoOptionGet {

  def myFunction(input : Option[String]) : String = {
    input.map(_.toLowerCase).get
  }

  def myFunction2(input : Option[String]) : String = {
    input.map(_.toLowerCase).getOrElse("default")
  }

  def main(args : Array[String]) : Unit = {
    try {
      println(myFunction(None))
    } catch {
      case e : Throwable => e.printStackTrace()
    }
    println(myFunction(Some("FOO")))
    println(myFunction2(None))
    println(myFunction2(Some("FOO")))
  }

}
