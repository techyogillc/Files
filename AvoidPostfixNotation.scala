object AvoidPostfixNotation {

  /*def myFunction() : Unit = {
    var length = 0
    val names = List("foo", "bar", "sha", "baz")

    names toList
    length = names.length

    println(length)
  }*/

  def myFunction() : Unit = {
    val names = List("foo", "bar", "sha", "baz")

    names.map {_.toLowerCase}.filter {_.length > 2}

    names map {_.toLowerCase} filter {_.length > 2}
  }

  def myFunction1() : Unit = {
    val names = List("foo", "bar", "sha", "baz")

    names.map(_.toLowerCase).filter(_.length > 2)
  }

  def main(args : Array[String]) : Unit = {
    myFunction()
    myFunction1()
  }

}
