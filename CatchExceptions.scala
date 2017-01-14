import java.io.{FileNotFoundException, File}

object CatchExceptions {

  def myFunction1(filename : String) : String = {
    io.Source.fromFile(new File(filename)).mkString
  }

  def myFunction2(filename : String) : Option[String] = {
    try {
      Some(io.Source.fromFile(new File(filename)).mkString)
    } catch {
      case ex : FileNotFoundException => {
        ex.printStackTrace()
        None
      }
    }
  }

  def main(args : Array[String]) : Unit = {
    //println(myFunction1("foo"))
    println(myFunction2("foo"))
  }

}
