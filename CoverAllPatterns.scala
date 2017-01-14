object CoverAllPatterns {

  def myFunction(input : Option[String]) : Boolean = input match {
    case Some("foo") => false
    case Some("bar") => true
  }

  def myFunction2(input : Option[String]) : String = input match {
    case Some(in) => in
  }

  def myFunction3(input : Option[String]) : String = input match {
    case Some(in) => in
    case None => "(None)"
  }

  def myFunction4(input : Option[String]) : String = input match {
    case Some(in) => in
    case None => "(None)"
    case _ => "(null)"
  }

  def main(args : Array[String]) : Unit = {
    println(myFunction(Some("bar")))
    try {
      println(myFunction2(None))
    } catch {
      case e : Throwable => e.printStackTrace()
    }
    println(myFunction3(None))
    try {
      println(myFunction3(null))
    } catch {
      case e : Throwable => e.printStackTrace()
    }
    println(myFunction4(null))
  }

}