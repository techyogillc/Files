object ReturnTypes {

  def myFunction1(str : String) = {
    str.toLowerCase
  }

  /*def myFunction2(str : String) = {
    if(str == "FoO") {
      str.toLowerCase
    } else {
      str.length
    }
  }*/

  def myFunction2(str : String) : String = {
    if(str == "FoO") {
      str.toLowerCase
    } else {
      str.length.toString
    }
  }

  def main(args : Array[String]) : Unit = {
    println(myFunction1("FoO"))
    println(myFunction2("blah"))
    myFunction1(myFunction2("blah")) // OH NOES!
  }

}
