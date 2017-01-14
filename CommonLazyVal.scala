object CommonLazyVal {

  case class Foo(input : List[String]) {
    val lengths = {
      Thread.sleep(1000)
      input.map(_.length)
    }
    lazy val lowered = {
      Thread.sleep(1000)
      input.map(_.toLowerCase)
    }
  }

  def myFunction(foo : Foo) : Unit = {
    println(foo.lengths)
    separator()
    println(foo.lowered)
  }

  lazy val fileContents = {
    val f = io.Source.fromURL(ClassLoader.getSystemResource("foo.txt"))
    f.getLines().mkString("\n")
  }

  var lineSeparator = "\n"

  lazy val fileContents2 = {
    val f = io.Source.fromURL(ClassLoader.getSystemResource("foo.txt"))
    f.getLines().mkString(lineSeparator)
  }

  def main(args : Array[String]) : Unit = {
    separator()
    myFunction(Foo(List("Foo", "Bar", "Sha", "Baz")))
    separator()
    println(fileContents)
    separator()
    lineSeparator = "&"
    println(fileContents2)
  }

  def separator() = {
    for(i <- 0 until 10) print("-")
    println()
  }

}
